package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.models.entities.CitaLibro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CitaLibroRepository extends PagingAndSortingRepository<CitaLibro, Long> {

    @Query("select c from CitaLibro c where c.libro.id = ?1")
    List<CitaLibro> findAllCitasByLibro(Long id);
}
