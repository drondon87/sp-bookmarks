package org.bookmark.msvc.bookmark.services.impl;

import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.bookmark.msvc.bookmark.repositories.CategoriaRepository;
import org.bookmark.msvc.bookmark.services.CategoriaService;
import org.springcloud.msvc.commons.services.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CategoriaServiceImpl extends CommonServiceImpl<Categoria, CategoriaRepository> implements CategoriaService {

    @Override
    @Transactional(readOnly = true)
    public Optional<Categoria> buscarByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeNombre(String nombre) {
        return repository.existsByNombre(nombre);
    }

    @Override
    @Transactional
    public Categoria save(Categoria categoria){
        categoria.setNombre(categoria.getNombre().toUpperCase());
        return repository.save(categoria);
    }
}
