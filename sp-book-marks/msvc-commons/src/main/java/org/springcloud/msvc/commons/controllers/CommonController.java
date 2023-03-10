package org.springcloud.msvc.commons.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springcloud.msvc.commons.constants.MessagesConstants;
import org.springcloud.msvc.commons.constants.ResponseConstants;
import org.springcloud.msvc.commons.response.CommonsResponse;
import org.springcloud.msvc.commons.services.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommonController<E, S extends ICommonService<E>> {

    @Autowired
    protected S service;

    @Operation(description = "Return List modelo seleccionado", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping
    public CommonsResponse<Iterable<E>> listar() {
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.findAll());
    }

    @Operation(description = "Return List modelo seleccionado paginado", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/pagina")
    public CommonsResponse<Iterable<E>> listar(Pageable pageable) {
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.findAll());
    }

    @Operation(description = "Return Objeto buscado", summary = "Return 200, 404, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/{id}")
    public CommonsResponse<E> ver(@PathVariable Long id) {
        Optional<E> o = service.findById(id);
        if (o.isPresent()) {
            return new CommonsResponse<E>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                    ResponseConstants.OK, o.get());
        }
        return new CommonsResponse<E>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                MessagesConstants.NOT_FOUND_MSG);
    }

    @Operation(description = "Retorna Objeto guardada o errores en la petici??n", summary = "Return 201, 400, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @PostMapping
    public CommonsResponse<E> crear(@Valid @RequestBody E entity, BindingResult result) {
        if (result.hasErrors()) {
            return this.validar(result);
        }
        E entityDB = service.save(entity);
        return new CommonsResponse<E>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), MessagesConstants.CREATED_MSG,
                entityDB);
    }

    @Operation(description = "Elimina el objeto indicado", summary = "Return 204, 404, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "NO_CONTENT"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @DeleteMapping("/{id}")
    public CommonsResponse<E> eliminar(@PathVariable Long id) {
        Optional<E> o = service.findById(id);
        if (o.isPresent()) {
            service.deleteById(id);
            return new CommonsResponse<E>(ResponseConstants.OK, String.valueOf(HttpStatus.NO_CONTENT),
                    MessagesConstants.DELETED_MSG);
        }
        return new CommonsResponse<E>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                MessagesConstants.NOT_FOUND_MSG);
    }

    protected CommonsResponse<E> validar(BindingResult result) {
        Map<String, Object> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El Campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return new CommonsResponse<E>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.BAD_REQUEST),
                MessagesConstants.BAD_REQUEST_MSG, errors);
    }

}
