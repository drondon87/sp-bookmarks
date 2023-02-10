package org.bookmark.msvc.bookmark.controllers;

import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.bookmark.msvc.bookmark.services.AutorService;
import org.springcloud.msvc.commons.controllers.CommonController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/autores")
public class AutorController extends CommonController<Autor, AutorService> {
}
