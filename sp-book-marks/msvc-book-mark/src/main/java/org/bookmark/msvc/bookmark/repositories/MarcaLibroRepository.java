package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.models.entities.MarcaLibro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MarcaLibroRepository extends PagingAndSortingRepository<MarcaLibro, Long> {

    @Query("select ml from MarcaLibro ml where ml.capitulo.libro.id = ?1")
    List<MarcaLibro> findAllMarcasByLibro(Long id);

    @Query("select ml from MarcaLibro ml where ml.capitulo.id = ?1")
    List<MarcaLibro> findAllMarcasByCapitulo(Long id);
}
