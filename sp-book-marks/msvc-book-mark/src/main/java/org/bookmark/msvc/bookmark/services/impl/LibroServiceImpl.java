package org.bookmark.msvc.bookmark.services.impl;

import org.bookmark.msvc.bookmark.models.entities.Libro;
import org.bookmark.msvc.bookmark.repositories.LibroRepository;
import org.bookmark.msvc.bookmark.services.LibroService;
import org.springcloud.msvc.commons.services.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl extends CommonServiceImpl<Libro, LibroRepository> implements LibroService {

    @Override
    public Optional<Libro> buscarByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public List<Libro> findAllByAutor(Long id) {
        return repository.findAllByAutor(id);
    }

    @Override
    public List<Libro> findAllByCategoria(Long id) {
        return repository.findAllByCategoria(id);
    }

    @Override
    @Transactional
    public Libro save(Libro libro) {
        libro.setNombre(libro.getNombre().toUpperCase());
        libro.setCreateAt(new Date());
        return repository.save(libro);
    }
}
