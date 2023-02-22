package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.bookmark.msvc.bookmark.models.entities.Capitulo;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.bookmark.msvc.bookmark.models.entities.Libro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CapituloRepositoryTestCases {

    @Autowired
    CapituloRepository repository;

    @DisplayName("Test: Buscar Capitulos")
    @Test
    void testFindAllCapitulos_returnCapitulos() {
        // When
        Iterable<Capitulo> listBD = repository.findAll();
        List<Capitulo> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> "Los capitulos no pueden estar vacios");
        }, () -> {
            assertEquals(6, expected.size(), () -> "La cantidad de capitulos no es igual a la esperada");
        });
    }

    @DisplayName("Test: Buscar Capitulo por Id Existente")
    @Test
    void testFindCapituloByIdExistente_returnCapitulo() {
        // Given
        Libro libro = new Libro();
        libro.setId(1L);
        libro.setNombre("LOS ASESINOS DEL EMPERADOR".toUpperCase());
        libro.setDescripcion("Trilogia de Trajano Volumen I");

        Autor autor = new Autor(3L, "SANTIAGO", "POSTEGUILLO");
        libro.setAutor(autor);

        Categoria categoria = new Categoria(2L, "NOVELA", "Novelas historicas, psicologicas, politicas");
        libro.setCategoria(categoria);

        Capitulo testObject = new Capitulo();
        testObject.setId(1L);
        testObject.setNombre("EL GUARDIAN DEL RIN");
        testObject.setDescripcion("Dos meses antes del día marcado para el asesinato del emperador Domiciano");
        testObject.setNumero("1");
        testObject.setLibro(libro);

        // When
        Optional<Capitulo> expected = repository.findById(1L);

        // Then
        assertAll(() -> {
            assertTrue(expected.isPresent(), () -> "El capitulo debe existir");
        }, () -> {
            assertEquals(testObject.getNombre(), expected.get().getNombre(), () -> "Los nombres no son iguales");
        }, () -> {
            assertEquals(testObject.getDescripcion(), expected.get().getDescripcion(), () -> "La descripcion no son iguales");
        }, () -> {
            assertNotNull(expected.get().getLibro(), () -> "El autor no puede estar nulo");
        }, () -> {
            assertEquals(testObject.getNumero(), expected.get().getNumero(), () -> "Los numeros no son iguales");
        });
    }

    @DisplayName("Test: Buscar Capitulo por Id No Existente")
    @Test
    void testFindCapituloByNoneExistingId_returnException() {
        // When
        Optional<Capitulo> objectToFind = repository.findById(7L);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, objectToFind::orElseThrow);
        }, () -> {
            assertFalse(objectToFind.isPresent(), () -> "El nombre no debería de existir");
        });
    }

    @DisplayName("Test: Guardar Capitulo")
    @Test
    void testSaveCapitulo_returnCapituloSaved() {
        // Given
        Libro libro = new Libro();
        libro.setId(1L);
        libro.setNombre("LOS ASESINOS DEL EMPERADOR");
        libro.setDescripcion("Trilogia de Trajano Volumen I");
        libro.setCreateAt(new Date());

        Autor autor = new Autor(1L, "ARTURO", "PEREZ REVERTE");
        libro.setAutor(autor);

        Categoria categoria = new Categoria(2L, "NOVELA", "Novelas historicas, psicologicas, politicas");
        libro.setCategoria(categoria);

        Capitulo objectToSave = new Capitulo();
        objectToSave.setLibro(libro);
        objectToSave.setNumero("4");
        objectToSave.setDescripcion("Nueva guerra busca a trajano");
        objectToSave.setNombre("TRAJANO EL PODEROSO");

        // When
        Capitulo expected = repository.save(objectToSave);

        Iterable<Capitulo> listBd = repository.findAll();
        List<Capitulo> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertNotNull(expected.getId(), () -> "El id no debe estar nulo");
        }, () -> {
            assertEquals(objectToSave.getNombre(), expected.getNombre(), () -> "Los nombres no son iguales");
        }, () -> {
            assertEquals(7, expectedList.size(), () -> "La lista no tiene la cantidad de categorias esperado");
        });
    }

    @DisplayName("Test: Eliminar Capitulo")
    @Test
    void testDeleteCapitulo() {
        // Given
        Capitulo objectToDelete = repository.findById(3L).orElseThrow();

        // When
        repository.delete(objectToDelete);

        Iterable<Capitulo> listBd = repository.findAll();
        List<Capitulo> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, () -> repository.findById(3L).orElseThrow());
        }, () -> {
            assertEquals(5, expectedList.size(), () -> "La cantidad de libros no son iguales");
        });
    }

    @DisplayName("Test: Buscar Capitulos por Libro Existente")
    @Test
    void testFindCapitulosByLibroExistente_returnCapitulos() {
        // Given
        Long libroId = 1L;
        // When
        Iterable<Capitulo> listBD = repository.findAllByLibro(libroId);
        List<Capitulo> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> "Los capitulos no pueden estar vacios");
        }, () -> {
            assertEquals(3, expected.size(), () -> "La cantidad de capitulos no es igual a la esperada");
        });
    }
}
