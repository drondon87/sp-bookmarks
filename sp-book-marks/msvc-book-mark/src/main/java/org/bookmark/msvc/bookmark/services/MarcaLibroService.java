package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.models.entities.MarcaLibro;
import org.springcloud.msvc.commons.services.ICommonService;

import java.util.List;

public interface MarcaLibroService extends ICommonService<MarcaLibro> {

    List<MarcaLibro> listarMarcasByLibro(Long idLibro);

    List<MarcaLibro> listarMarcasByCapitulo(Long idCapitulo);
}
