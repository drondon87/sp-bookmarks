package org.bookmark.msvc.bookmark.services.impl;

import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.bookmark.msvc.bookmark.repositories.AutorRepository;
import org.bookmark.msvc.bookmark.services.AutorService;
import org.springcloud.msvc.commons.services.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AutorServiceImpl extends CommonServiceImpl<Autor, AutorRepository> implements AutorService {

    @Override
    @Transactional
    public Autor save(Autor autor){
        autor.setNombre(autor.getNombre().toUpperCase());
        autor.setApellido(autor.getApellido().toUpperCase());
        return repository.save(autor);
    }
}
