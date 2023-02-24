package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.bookmark.msvc.bookmark.models.entities.Libro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class LibroRepositoryTestCases {

    @Autowired
    LibroRepository repository;

    @DisplayName("Test: Buscar Libros")
    @Test
    void testFindAllLibros_returnLibros() {
        // When
        Iterable<Libro> listBD = repository.findAll();
        List<Libro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(6, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Libro por Id Existente")
    @Test
    void testFindLibroByIdExistente_returnLibro() {
        // Given
        Libro testObject = new Libro();
        testObject.setId(1L);
        testObject.setNombre("LOS ASESINOS DEL EMPERADOR".toUpperCase());
        testObject.setDescripcion("Trilogia de Trajano Volumen I");

        Autor autor = new Autor(3L, "SANTIAGO", "POSTEGUILLO");
        testObject.setAutor(autor);

        Categoria categoria = new Categoria(2L, "NOVELA", "Novelas historicas, psicologicas, politicas");
        testObject.setCategoria(categoria);

        // When
        Optional<Libro> expected = repository.findById(1L);

        // Then
        assertAll(() -> {
            assertTrue(expected.isPresent(), () -> ErrorMessageTestCases.LIBRO_MUST_EXIST);
        }, () -> {
            assertEquals(testObject.getNombre(), expected.get().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals(testObject.getDescripcion(), expected.get().getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        }, () -> {
            assertNotNull(expected.get().getAutor(), () -> "El autor no puede estar nulo");
        }, () -> {
            assertEquals(testObject.getAutor().getId(), expected.get().getAutor().getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        },() -> {
            assertEquals(testObject.getAutor().getNombre(), expected.get().getAutor().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertNotNull(expected.get().getCategoria(), () -> ErrorMessageTestCases.CATEGORIA_MUST_EXIST);
        }, () -> {
            assertEquals(testObject.getCategoria().getNombre(), expected.get().getCategoria().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        });
    }

    @DisplayName("Test: Buscar Libro por Id No Existente")
    @Test
    void testFindLibroByNoneExistingId_returnException() {
        // When
        Optional<Libro> objectToFind = repository.findById(7L);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, objectToFind::orElseThrow);
        }, () -> {
            assertFalse(objectToFind.isPresent(), () -> ErrorMessageTestCases.GENERIC_NAME_MUST_EXIST);
        });
    }

    @DisplayName("Test: Guardar Libro")
    @Test
    void testSaveLibro_returnLibroSaved() {
        // Given
        Libro objectToSave = new Libro();
        objectToSave.setNombre("PASION DE SANGRE");
        objectToSave.setDescripcion("Las aventuras del capitan alatriste Volumen II");
        objectToSave.setCreateAt(new Date());

        Autor autor = new Autor(1L, "ARTURO", "PEREZ REVERTE");
        objectToSave.setAutor(autor);

        Categoria categoria = new Categoria(2L, "NOVELA", "Novelas historicas, psicologicas, politicas");
        objectToSave.setCategoria(categoria);

        // When
        Libro expected = repository.save(objectToSave);

        Iterable<Libro> listBd = repository.findAll();
        List<Libro> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertNotNull(expected.getId(), () -> ErrorMessageTestCases.GENERIC_NOT_NULL_ID);
        }, () -> {
            assertEquals(objectToSave.getNombre(), expected.getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals(7, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Eliminar Libro")
    @Test
    void testDeleteLibro() {
        // Given
        Libro objectToDelete = repository.findById(3L).orElseThrow();

        // When
        repository.delete(objectToDelete);

        Iterable<Libro> listBd = repository.findAll();
        List<Libro> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, () -> repository.findById(3L).orElseThrow());
        }, () -> {
            assertEquals(5, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Libro por Nombre Existente")
    @Test
    void testFindLibroByNombreExistente_returnLibro() {
        // Given
        String objectName = "CIRCO MAXIMO";
        // When
        Optional<Libro> expected = repository.findByNombre(objectName);

        // Then
        assertAll(() -> {
            assertTrue(expected.isPresent(), () -> ErrorMessageTestCases.LIBRO_MUST_EXIST);
        }, () -> {
            assertEquals(objectName, expected.get().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals(2, expected.get().getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        });
    }

    @DisplayName("Test: Buscar Libro por Nombre No Existente")
    @Test
    void testFindLibroByNonExistingNombre_returnException() {
        // Given
        String objectName = "HUMOR";

        // When
        Optional<Libro> expected = repository.findByNombre(objectName);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, expected::orElseThrow);
        }, () -> {
            assertFalse(expected.isPresent(), () -> ErrorMessageTestCases.LIBRO_MUST_NOT_EXIST);
        });
    }

    @DisplayName("Test: Buscar Libros por Categoria Existente")
    @Test
    void testFindLibrosByCategoriaExistente_returnLibros() {
        // Given
        Long categoriaId = 2L;
        // When
        Iterable<Libro> listBD = repository.findAllByCategoria(categoriaId);
        List<Libro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(4, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Libros por Categoria No Existente")
    @Test
    void testFindLibrosByCategoriaNoneExistente_returnLibrosVacio() {
        // Given
        Long categoriaId = 4L;
        // When
        Iterable<Libro> listBD = repository.findAllByCategoria(categoriaId);
        List<Libro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertTrue(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_FULL_LIST);
        }, () -> {
            assertEquals(0, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Libros por Autor Existente")
    @Test
    void testFindLibrosByAutorExistente_returnLibros() {
        // Given
        Long autorId = 3L;
        // When
        Iterable<Libro> listBD = repository.findAllByAutor(autorId);
        List<Libro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(2, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Libros por Autor No Existente")
    @Test
    void testFindLibrosByAutorNoneExistente_returnLibrosVacios() {
        // Given
        Long autorId = 8L;
        // When
        Iterable<Libro> listBD = repository.findAllByAutor(autorId);
        List<Libro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertTrue(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_FULL_LIST);
        }, () -> {
            assertEquals(0, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }
}
