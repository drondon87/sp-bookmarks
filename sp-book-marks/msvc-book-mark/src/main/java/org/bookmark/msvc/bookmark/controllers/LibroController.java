package org.bookmark.msvc.bookmark.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.bookmark.msvc.bookmark.models.entities.Libro;
import org.bookmark.msvc.bookmark.services.LibroService;
import org.bookmark.msvc.bookmark.services.UploadFileService;
import org.springcloud.msvc.commons.constants.MessagesConstants;
import org.springcloud.msvc.commons.constants.ResponseConstants;
import org.springcloud.msvc.commons.controllers.CommonController;
import org.springcloud.msvc.commons.response.CommonsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.core.io.Resource;
import javax.validation.Valid;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Optional;

@Tag(name = "Libros", description = "API controlador de las Libros")
@RestController
@Slf4j
@RequestMapping("/api/libros")
public class LibroController extends CommonController<Libro, LibroService> {

    @Autowired
    private UploadFileService uploadFileService;

    @Operation(description = "Retorna Libro guardado o errores en la petición", summary = "Return 201, 400, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @PostMapping
    @Override
    public CommonsResponse<Libro> crear(@Valid @RequestBody Libro libro, BindingResult result) {

        if (result.hasErrors()) {
            return validar(result);
        }

        if (service.buscarByNombre(libro.getNombre().toUpperCase()).isPresent()) {
            return new CommonsResponse<Libro>(
                    ResponseConstants.NOT_OK,
                    String.valueOf(HttpStatus.BAD_REQUEST),
                    MessagesConstants.CATEGORIA_EXISTE_MSG);
        }

        return new CommonsResponse<Libro>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), MessagesConstants.CREATED_MSG,
                service.save(libro));
    }

    @Operation(description = "Return Libro Modificado", summary = "Return 201, 400, 404, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @PutMapping("/{id}")
    public CommonsResponse<Libro> editar(@Valid @RequestBody Libro libro, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return validar(result);
        }

        Optional<Libro> libroO = service.findById(id);
        if (libroO.isPresent()) {
            Libro libroBD = libroO.get();

            if (service.buscarByNombre(libro.getNombre().toUpperCase()).isPresent()) {
                return new CommonsResponse<Libro>(
                        ResponseConstants.NOT_OK,
                        String.valueOf(HttpStatus.BAD_REQUEST),
                        MessagesConstants.CATEGORIA_EXISTE_MSG);
            }

            libroBD.setNombre(libro.getNombre());
            libroBD.setCategoria(libro.getCategoria());
            libroBD.setDescripcion(libro.getDescripcion());
            libroBD.setAutor(libro.getAutor());
            libroBD.setPortada(libro.getPortada());
            return new CommonsResponse<Libro>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), MessagesConstants.MODIFIED_MSG,
                    service.save(libroBD));
        }
        return new CommonsResponse<Libro>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                MessagesConstants.NOT_FOUND_MSG);
    }

    @Operation(description = "Return Libro Encontrado", summary = "Return 200, 404, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/nombre/{nombre}")
    public CommonsResponse<Libro> verByNombre(@PathVariable String nombre) {
        Optional<Libro> o = service.buscarByNombre(nombre);
        if (o.isPresent()) {
            return new CommonsResponse<Libro>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK),
                    ResponseConstants.OK, o.get());
        }
        return new CommonsResponse<Libro>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                MessagesConstants.NOT_FOUND_MSG);
    }

    @Operation(description = "Retorna Lista de Libros por Categoria", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/categoria/{idCategoria}")
    public CommonsResponse<Iterable<Libro>> listarLibrosPorCategoria(@PathVariable Long idCategoria) {
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.findAllByCategoria(idCategoria));
    }

    @Operation(description = "Retorna Lista de Libros por Autor", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/autor/{autorId}")
    public CommonsResponse<Iterable<Libro>> listarLibrosPorAutor(@PathVariable Long autorId) {
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.findAllByAutor(autorId));
    }

    @Operation(description = "Retorna Lista de Libros Paginado", summary = "Return 200, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @GetMapping("/page/{page}/size/{size}")
    public CommonsResponse<Page<Libro>> listarLibrosPaginado(@PathVariable Integer page, @PathVariable Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return new CommonsResponse<>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.OK), ResponseConstants.OK,
                service.findAll(pageable));
    }

    @Operation(description = "Cargar Archivo portada Libro", summary = "Return 201, 400, 404, 500")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "CREATED"),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST"),
            @ApiResponse(responseCode = "404", description = "NOT_FOUND"),
            @ApiResponse(responseCode = "500", description = "INTERNAL_SERVER_ERROR")})
    @PostMapping("/upload")
    public CommonsResponse<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {
        Optional<Libro> libroO = service.findById(id);

        if (libroO.isPresent()) {
            Libro libroBD = libroO.get();

            if (!archivo.isEmpty()) {
                String nombreArchivo = null;
                try {
                    nombreArchivo = uploadFileService.copiar(archivo);

                } catch (IOException e) {
                    log.error(e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                    return new CommonsResponse<Libro>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR), MessagesConstants.ERROR_IMAGE_MSG);
                }

                String nombreFotoAnterior = libroBD.getPortada();
                uploadFileService.eliminar(nombreFotoAnterior);
                libroBD.setPortada(nombreArchivo);
                return new CommonsResponse<Libro>(ResponseConstants.SUCCESS, String.valueOf(HttpStatus.CREATED), MessagesConstants.FILE_UPLOAD_SUCCESS_MSG,
                        service.save(libroBD));
            }

            return new CommonsResponse<Libro>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.BAD_REQUEST),
                    MessagesConstants.FILE_UPLOAD_NOT_FOUND_MSG);
        }

        return new CommonsResponse<Libro>(ResponseConstants.NOT_OK, String.valueOf(HttpStatus.NOT_FOUND),
                MessagesConstants.NOT_FOUND_MSG);
    }

    @Operation(description = "Descargar Archivo portada Libro", summary = "Return 200")
    @GetMapping("/upload/img/{nombreFoto:.+}")
    public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {

        Resource recurso = null;

        try {
            recurso = uploadFileService.cargar(nombreFoto);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

        return new ResponseEntity<Resource>(recurso, cabecera, HttpStatus.OK);
    }
}
