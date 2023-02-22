package org.bookmark.msvc.bookmark.services.impl;

import org.bookmark.msvc.bookmark.models.entities.Capitulo;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.bookmark.msvc.bookmark.repositories.CapituloRepository;
import org.bookmark.msvc.bookmark.services.CapituloService;
import org.springcloud.msvc.commons.services.CommonServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CapituloServiceImpl extends CommonServiceImpl<Capitulo, CapituloRepository> implements CapituloService {

    @Override
    @Transactional(readOnly = true)
    public List<Capitulo> listarCapitulosByLibro(Long idLibro) {
        return repository.findAllByLibro(idLibro);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Capitulo> listarCapitulosByLibro(Pageable pageable, Long idLibro) {
        return repository.findAllByLibro(pageable, idLibro);
    }

    @Override
    @Transactional
    public Capitulo save(Capitulo capitulo){
        capitulo.setNombre(capitulo.getNombre().toUpperCase());
        return repository.save(capitulo);
    }
}
