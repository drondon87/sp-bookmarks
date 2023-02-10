package org.bookmark.msvc.bookmark;

import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.bookmark.msvc.bookmark.models.entities.Categoria;

public class TestData {

    public static Categoria getCategoria01() {
        return new Categoria(1L, "Historia".toUpperCase(), "Libros sobre Historia");
    }

    public static Categoria getCategoria02() {
        return new Categoria(2L, "Novela".toUpperCase(), "Novelas historicas, psicologicas, politicas");
    }

    public static Categoria getCategoria03() {
        return new Categoria(3L, "Psicologia".toUpperCase(), "Libros de Psicología");
    }

    public static Autor getAutor01() {
        return new Autor(1L, "ARTURO", "PEREZ REVERTE");
    }

    public static Autor getAutor02() {
        return new Autor(2L, "ANABEL", "HERNANDEZ");
    }

    public static Autor getAutor03() {
        return new Autor(3L, "SANTIAGO", "POSTEGUILLO");
    }
}
