package org.bookmark.msvc.bookmark;

import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.bookmark.msvc.bookmark.models.entities.Libro;

import java.util.Date;

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

    public static Libro getLibro01() {
        Libro libro = new Libro();
        libro.setId(1l);
        libro.setNombre("LOS ASESINOS DEL EMPERADOR");
        libro.setDescripcion("Trilogia de Trajano Volumen I");
        libro.setCreateAt(new Date());
        libro.setAutor(getAutor03());
        libro.setCategoria(getCategoria02());
        return libro;
    }

    public static Libro getLibro02() {
        Libro libro = new Libro();
        libro.setId(2l);
        libro.setNombre("CIRCO MAXIMO");
        libro.setDescripcion("Trilogia de Trajano Volumen II");
        libro.setCreateAt(new Date());
        libro.setAutor(getAutor03());
        libro.setCategoria(getCategoria02());
        return libro;
    }

    public static Libro getLibro03() {
        Libro libro = new Libro();
        libro.setId(3L);
        libro.setNombre("NADIE SE VA A REIR");
        libro.setDescripcion("La increible historia de un juicio a la ironia");
        libro.setCreateAt(new Date());
        libro.setAutor(getAutor01());
        libro.setCategoria(getCategoria01());
        return libro;
    }
}
