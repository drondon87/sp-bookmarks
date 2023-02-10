package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AutorRepository extends PagingAndSortingRepository<Autor, Long> {
}
