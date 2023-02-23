package org.bookmark.msvc.bookmark.services.impl;

import org.bookmark.msvc.bookmark.models.entities.CitaLibro;
import org.bookmark.msvc.bookmark.repositories.CitaLibroRepository;
import org.bookmark.msvc.bookmark.services.CitaLibroService;
import org.springcloud.msvc.commons.services.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CitaLibroServiceImpl extends CommonServiceImpl<CitaLibro, CitaLibroRepository> implements CitaLibroService {

    @Transactional(readOnly = true)
    @Override
    public List<CitaLibro> listarCitasByLibro(Long idLibro) {
        return repository.findAllCitasByLibro(idLibro);
    }

    @Override
    @Transactional
    public CitaLibro save(CitaLibro citaLibro) {
        citaLibro.setCreateAt(new Date());
        return repository.save(citaLibro);
    }

}
