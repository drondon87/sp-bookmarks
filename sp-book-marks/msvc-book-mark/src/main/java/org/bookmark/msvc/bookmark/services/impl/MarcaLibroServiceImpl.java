package org.bookmark.msvc.bookmark.services.impl;

import org.bookmark.msvc.bookmark.models.entities.MarcaLibro;
import org.bookmark.msvc.bookmark.repositories.MarcaLibroRepository;
import org.bookmark.msvc.bookmark.services.MarcaLibroService;
import org.springcloud.msvc.commons.services.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MarcaLibroServiceImpl extends CommonServiceImpl<MarcaLibro, MarcaLibroRepository> implements MarcaLibroService {

    @Transactional(readOnly = true)
    @Override
    public List<MarcaLibro> listarMarcasByLibro(Long idLibro) {
        return repository.findAllMarcasByLibro(idLibro);
    }

    @Transactional(readOnly = true)
    @Override
    public List<MarcaLibro> listarMarcasByCapitulo(Long idCapitulo) {
        return repository.findAllMarcasByCapitulo(idCapitulo);
    }
}
