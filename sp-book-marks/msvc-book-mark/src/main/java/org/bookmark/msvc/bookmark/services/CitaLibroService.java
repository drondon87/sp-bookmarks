package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.models.entities.CitaLibro;
import org.springcloud.msvc.commons.services.ICommonService;

import java.util.List;

public interface CitaLibroService extends ICommonService<CitaLibro> {

    List<CitaLibro> listarCitasByLibro(Long idLibro);
}
