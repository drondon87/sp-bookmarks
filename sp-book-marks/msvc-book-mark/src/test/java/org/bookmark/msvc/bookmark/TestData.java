package org.bookmark.msvc.bookmark;

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
}
