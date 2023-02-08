package org.bookmark.msvc.bookmark.controllers;

import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.bookmark.msvc.bookmark.services.CategoriaService;
import org.springcloud.msvc.commons.controllers.CommonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController extends CommonController<Categoria, CategoriaService> {

    @PostMapping
    @Override
    public ResponseEntity<?> crear(@Valid @RequestBody Categoria categoria, BindingResult result) {

        if (result.hasErrors()) {
            return validar(result);
        }

        if (!categoria.getNombre().isEmpty() && service.existeNombre(categoria.getNombre().toUpperCase())) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("message", "La categoria ya existe en BD"));
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Categoria categoria, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return validar(result);
        }

        Optional<Categoria> categoriaO = service.findById(id);
        if (categoriaO.isPresent()) {
            Categoria categoriaDB = categoriaO.get();

            if (!categoria.getNombre().isEmpty() &&
                    !categoria.getNombre().toUpperCase().equalsIgnoreCase(categoriaDB.getNombre()) &&
                    service.buscarByNombre(categoria.getNombre().toUpperCase()).isPresent()) {
                return ResponseEntity.badRequest().body(Collections.singletonMap("message", "La categoria ya existe en BD"));
            }

            categoriaDB.setNombre(categoria.getNombre());
            categoriaDB.setDescripcion(categoria.getDescripcion());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(categoriaDB));
        }
        return ResponseEntity.notFound().build();
    }
}
