package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.models.entities.Capitulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CapituloRepository extends PagingAndSortingRepository<Capitulo, Long> {

    @Query("select c from Capitulo c where c.libro.id = ?1")
    List<Capitulo> findAllByLibro(Long id);

    @Query("select c from Capitulo c where c.libro.id = ?1")
    Page<Capitulo> findAllByLibro(Pageable pageable, Long id);
}
