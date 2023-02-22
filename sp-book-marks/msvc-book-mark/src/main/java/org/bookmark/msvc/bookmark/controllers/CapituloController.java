package org.bookmark.msvc.bookmark.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bookmark.msvc.bookmark.models.entities.Capitulo;
import org.bookmark.msvc.bookmark.models.entities.Libro;
import org.bookmark.msvc.bookmark.services.CapituloService;
import org.bookmark.msvc.bookmark.services.LibroService;
import org.springcloud.msvc.commons.constants.MessagesConstants;
import org.springcloud.msvc.commons.constants.ResponseConstants;
import org.springcloud.msvc.commons.controllers.CommonController;
import org.springcloud.msvc.commons.response.CommonsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Tag(name = "Capitulos", description = "API controlador de las Capitulos")
@RestController
@RequestMapping("/api/capitulos")
public class CapituloController extends CommonController<Capitulo, CapituloService> {

    @Autowired
    private LibroService libroService;

    @Operation(description = "Retorna Capitulo guardado o errores en la petición", summary = "Return 201, 400, 404, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @PostMapping
    @Override
    public CommonsResponse<Capitulo> crear(@Valid @RequestBody Capitulo capitulo, BindingResult result) {

        if (result.hasErrors()) {
            return validar(result);
        }

        Optional<Libro> libroO = libroService.findById(capitulo.getId());

        if (!libroO.isPresent()) {
            return new CommonsResponse<Capitulo>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                    MessagesConstants.LIBRO_NOT_FOUND_MSG);
        }

        return new CommonsResponse<Capitulo>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), MessagesConstants.CREATED_MSG,
                service.save(capitulo));

    }

    @Operation(description = "Return Capitulo Modificado", summary = "Return 201, 400, 404, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @PutMapping("/{id}")
    public CommonsResponse<Capitulo> editar(@Valid @RequestBody Capitulo capitulo, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return validar(result);
        }

        Optional<Capitulo> capituloO = service.findById(id);
        if (capituloO.isPresent()) {

            Optional<Libro> libroO = libroService.findById(capitulo.getId());

            if (!libroO.isPresent()) {
                return new CommonsResponse<Capitulo>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                        MessagesConstants.LIBRO_NOT_FOUND_MSG);
            }

            Capitulo capituloBD = capituloO.get();
            capituloBD.setNombre(capitulo.getNombre());
            capituloBD.setNumero(capitulo.getNumero());
            capituloBD.setDescripcion(capitulo.getDescripcion());
            capituloBD.setLibro(libroO.get());

            return new CommonsResponse<Capitulo>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), MessagesConstants.MODIFIED_MSG,
                    service.save(capitulo));
        }
        return new CommonsResponse<Capitulo>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                MessagesConstants.NOT_FOUND_MSG);
    }

    @Operation(description = "Retorna Lista de Capitulos por Libro", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/libro/{idLibro}")
    public CommonsResponse<Iterable<Capitulo>> listarCapitulosByLibros(@PathVariable Long idLibro) {
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.listarCapitulosByLibro(idLibro));
    }

    @Operation(description = "Retorna Lista de Capitulos por Libro Paginado", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/libro/{idLibro}/page/{page}")
    public CommonsResponse<Page<Capitulo>> listarCapitulosByLibrosByPage(@PathVariable Long idLibro, @PathVariable Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.listarCapitulosByLibro(pageable, idLibro));
    }
}
