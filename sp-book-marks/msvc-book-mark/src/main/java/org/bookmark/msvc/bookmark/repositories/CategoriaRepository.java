package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long> {

    Optional<Categoria> findByNombre(String nombre);

    boolean existsByNombre(String nombre);
}
