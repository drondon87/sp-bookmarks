package org.bookmark.msvc.bookmark.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.bookmark.msvc.bookmark.models.entities.Capitulo;
import org.bookmark.msvc.bookmark.models.entities.MarcaLibro;
import org.bookmark.msvc.bookmark.services.CapituloService;
import org.bookmark.msvc.bookmark.services.MarcaLibroService;
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

@Tag(name = "Marcas Libros", description = "API controlador de las Marcas de Libros")
@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api/marcalibro")
public class MarcaLibroController extends CommonController<MarcaLibro, MarcaLibroService> {

    @Autowired
    private CapituloService capituloService;

    @Operation(description = "Retorna Lista de Marcas Libros por Libro", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/libro/{idLibro}")
    public CommonsResponse<Iterable<MarcaLibro>> listarMarcaLibroByLibros(@PathVariable Long idLibro) {
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.listarMarcasByLibro(idLibro));
    }

    @Operation(description = "Retorna Lista de Marcas Libros por Libro", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/capitulo/{idCapitulo}")
    public CommonsResponse<Iterable<MarcaLibro>> listarMarcaLibroByCapitulos(@PathVariable Long idCapitulo) {
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.listarMarcasByCapitulo(idCapitulo));
    }

    @Operation(description = "Retorna Lista de Marcas Libros Paginado", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/page/{page}/size/{size}")
    public CommonsResponse<Page<MarcaLibro>> listarMarcasLibrosPaginado(@PathVariable Integer page, @PathVariable Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.findAll(pageable));
    }

    @Operation(description = "Return Marca Libro Modificado", summary = "Return 201, 400, 404, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @PutMapping("/{id}")
    public CommonsResponse<MarcaLibro> editar(@Valid @RequestBody MarcaLibro marcaLibro, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return validar(result);
        }

        Optional<MarcaLibro> marcaLibroOpt = service.findById(id);
        if (marcaLibroOpt.isPresent()) {

            Optional<Capitulo> capituloOpt = capituloService.findById(marcaLibro.getCapitulo().getId());

            if (!capituloOpt.isPresent()) {
                return new CommonsResponse<>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                        MessagesConstants.CAPITULO_NOT_FOUND_MSG);
            }

            MarcaLibro marcaLibroDB = marcaLibroOpt.get();
            marcaLibroDB.setResumen(marcaLibro.getResumen());
            marcaLibroDB.setDescripcion(marcaLibro.getDescripcion());
            marcaLibroDB.setCapitulo(capituloOpt.get());
            marcaLibroDB.setPaginas(marcaLibro.getPaginas());

            return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), MessagesConstants.MODIFIED_MSG,
                    service.save(marcaLibroDB));
        }
        return new CommonsResponse<>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                MessagesConstants.NOT_FOUND_MSG);
    }
}
