package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.bookmark.msvc.bookmark.models.entities.Libro;
import org.springcloud.msvc.commons.services.ICommonService;

import java.util.List;
import java.util.Optional;

public interface LibroService extends ICommonService<Libro> {

    Optional<Libro> buscarByNombre(String nombre);

    List<Libro> findAllByAutor(Long id);

    List<Libro> findAllByCategoria(Long id);

    Libro save(Libro libro);
}
