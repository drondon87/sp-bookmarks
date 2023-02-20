package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.models.entities.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface LibroRepository extends PagingAndSortingRepository<Libro, Long> {

    @Query("select l from Libro l where l.categoria.id = ?1")
    List<Libro> findAllByCategoria(Long id);

    Optional<Libro> findByNombre(String nombre);

    @Query("select l from Libro l where l.autor.id = ?1")
    List<Libro> findAllByAutor(Long id);
}
