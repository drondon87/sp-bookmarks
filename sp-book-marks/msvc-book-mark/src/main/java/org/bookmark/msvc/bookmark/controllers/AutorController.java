package org.bookmark.msvc.bookmark.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.bookmark.msvc.bookmark.services.AutorService;
import org.springcloud.msvc.commons.controllers.CommonController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Autores", description = "API controlador de las Autores")
@RestController
@RequestMapping("/api/autores")
public class AutorController extends CommonController<Autor, AutorService> {
}
