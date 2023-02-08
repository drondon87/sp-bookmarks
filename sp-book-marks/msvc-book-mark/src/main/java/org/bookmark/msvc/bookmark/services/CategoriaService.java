package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.springcloud.msvc.commons.services.ICommonService;

import java.util.Optional;

public interface CategoriaService extends ICommonService<Categoria> {

    Optional<Categoria> buscarByNombre(String nombre);

    boolean existeNombre(String nombre);

    Categoria save(Categoria categoria);
}
