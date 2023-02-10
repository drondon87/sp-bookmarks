package org.bookmark.msvc.bookmark.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.bookmark.msvc.bookmark.services.CategoriaService;
import org.springcloud.msvc.commons.constants.MessagesConstants;
import org.springcloud.msvc.commons.constants.ResponseConstants;
import org.springcloud.msvc.commons.controllers.CommonController;
import org.springcloud.msvc.commons.response.CommonsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Tag(name = "Categorías", description = "API controlador de las Categorías")
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController extends CommonController<Categoria, CategoriaService> {

    @Operation(description = "Retorna Categoría guardada o errores en la petición", summary = "Return 201, 400, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @PostMapping
    @Override
    public CommonsResponse<Categoria> crear(@Valid @RequestBody Categoria categoria, BindingResult result) {

        if (result.hasErrors()) {
            return validar(result);
        }

        if (!categoria.getNombre().isEmpty() && service.existeNombre(categoria.getNombre().toUpperCase())) {
            return new CommonsResponse<Categoria>(
                    ResponseConstants.NOT_OK,
                    String.valueOf(HttpStatus.BAD_REQUEST),
                    MessagesConstants.CATEGORIA_EXISTE_MSG);
        }
        return new CommonsResponse<Categoria>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), MessagesConstants.CREATED_MSG,
                service.save(categoria));
    }

    @Operation(description = "Return Categoría Modificada", summary = "Return 201, 400, 404, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @PutMapping("/{id}")
    public CommonsResponse<Categoria> editar(@Valid @RequestBody Categoria categoria, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return validar(result);
        }

        Optional<Categoria> categoriaO = service.findById(id);
        if (categoriaO.isPresent()) {
            Categoria categoriaDB = categoriaO.get();

            if (!categoria.getNombre().isEmpty() &&
                    !categoria.getNombre().toUpperCase().equalsIgnoreCase(categoriaDB.getNombre()) &&
                    service.buscarByNombre(categoria.getNombre().toUpperCase()).isPresent()) {
                return new CommonsResponse<Categoria>(
                        ResponseConstants.NOT_OK,
                        String.valueOf(HttpStatus.BAD_REQUEST),
                        MessagesConstants.CATEGORIA_EXISTE_MSG);
            }

            categoriaDB.setNombre(categoria.getNombre());
            categoriaDB.setDescripcion(categoria.getDescripcion());
            return new CommonsResponse<Categoria>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), MessagesConstants.MODIFIED_MSG,
                    service.save(categoriaDB));
        }
        return new CommonsResponse<Categoria>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                MessagesConstants.NOT_FOUND_MSG);
    }

    @Operation(description = "Return Categoría Encontrada", summary = "Return 404 if categoria name exits")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "404", description = "Categoria no encontrada"),
            @ApiResponse(responseCode = "500", description = "Internal error")})
    @GetMapping("/nombre/{nombre}")
    public CommonsResponse<Categoria> verByNombre(@PathVariable String nombre) {
        Optional<Categoria> o = service.buscarByNombre(nombre);
        if (o.isPresent()) {
            return new CommonsResponse<Categoria>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                    ResponseConstants.OK, o.get());
        }
        return new CommonsResponse<Categoria>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                MessagesConstants.NOT_FOUND_MSG);
    }
}
