package org.bookmark.msvc.bookmark.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bookmark.msvc.bookmark.models.entities.CitaLibro;
import org.bookmark.msvc.bookmark.models.entities.Libro;
import org.bookmark.msvc.bookmark.services.CitaLibroService;
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


@Tag(name = "Citas Libros", description = "API controlador de las Citas de Libros")
@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api/citalibro")
public class CitaLibroController extends CommonController<CitaLibro, CitaLibroService> {

    @Autowired
    private LibroService libroService;

    @Operation(description = "Retorna Lista de Citas Libros por Libro", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/libro/{idLibro}")
    public CommonsResponse<Iterable<CitaLibro>> listarCitasLibroByLibros(@PathVariable Long idLibro) {
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.listarCitasByLibro(idLibro));
    }

    @Operation(description = "Retorna Lista de Citas Libros Paginado", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/page/{page}/size/{size}")
    public CommonsResponse<Page<CitaLibro>> listarCitasLibrosPaginado(@PathVariable Integer page, @PathVariable Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.findAll(pageable));
    }

    @Operation(description = "Return Cita Libro Modificado", summary = "Return 201, 400, 404, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @PutMapping("/{id}")
    public CommonsResponse<CitaLibro> editar(@Valid @RequestBody CitaLibro citaLibro, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return validar(result);
        }

        Optional<CitaLibro> citaLibroO = service.findById(id);
        if (citaLibroO.isPresent()) {

            Optional<Libro> libroO = libroService.findById(citaLibro.getLibro().getId());

            if (!libroO.isPresent()) {
                return new CommonsResponse<>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                        MessagesConstants.LIBRO_NOT_FOUND_MSG);
            }

            CitaLibro citaLibroDB = citaLibroO.get();
            citaLibroDB.setPagina(citaLibro.getPagina());
            citaLibroDB.setDescripcion(citaLibro.getDescripcion());
            citaLibroDB.setLibro(libroO.get());

            return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), MessagesConstants.MODIFIED_MSG,
                    service.save(citaLibroDB));
        }
        return new CommonsResponse<>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                MessagesConstants.NOT_FOUND_MSG);
    }
}
