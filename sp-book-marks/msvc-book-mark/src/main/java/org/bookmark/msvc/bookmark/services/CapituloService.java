package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.models.entities.Capitulo;
import org.springcloud.msvc.commons.services.ICommonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CapituloService extends ICommonService<Capitulo> {

    List<Capitulo> listarCapitulosByLibro(Long idLibro);

    Page<Capitulo> listarCapitulosByLibro(Pageable pageable, Long idLibro);

    Capitulo save(Capitulo capitulo);
}
