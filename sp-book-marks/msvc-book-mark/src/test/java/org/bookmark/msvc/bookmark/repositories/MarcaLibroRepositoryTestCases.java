package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.models.entities.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class MarcaLibroRepositoryTestCases {

    @Autowired
    MarcaLibroRepository repository;

    @DisplayName("Test: Buscar Marcas Libros")
    @Test
    void testFindAllMarcasLibros_returnMarcasLibros() {
        // When
        Iterable<MarcaLibro> listBD = repository.findAll();
        List<MarcaLibro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(7, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Marca Libro por Id Existente")
    @Test
    void testFindMarcaLibroByIdExistente_returnMarcaLibro() {

        Autor autor = new Autor(7L, "'JONATHAN'", "'BLACK'");
        Categoria categoria = new Categoria(6L, "'ESOTERISMO'", "Libros sobre esoterismo, religion, teología");
        // Given
        Libro libro = new Libro();
        libro.setId(6l);
        libro.setNombre("LA HISTORIA SECRETA DEL MUNDO");
        libro.setDescripcion("El mundo que nos rodea, los edificios, monumentos, las obras de arte , la literatura, los nombres de los dias de la semana, y hasta los cuentos infantiles encierran una filosofia secreta. Este libros nos da las claves para interpretarla");
        libro.setPortada(null);
        libro.setAutor(autor);
        libro.setCategoria(categoria);
        libro.setCreateAt(new Date());

        Capitulo capitulo = new Capitulo();
        capitulo.setLibro(libro);
        capitulo.setId(7L);
        capitulo.setNumero("0");
        capitulo.setNombre("INTRODUCCION");
        capitulo.setDescripcion("Introducción");

        MarcaLibro testObject = new MarcaLibro();
        testObject.setPaginas("13");
        testObject.setCapitulo(capitulo);
        testObject.setResumen("Rarezas");
        testObject.setId(1l);
        testObject.setDescripcion("Rarezas");

        // When
        Optional<MarcaLibro> expected = repository.findById(1L);

        // Then
        assertAll(() -> {
            assertTrue(expected.isPresent(), () -> ErrorMessageTestCases.MARCA_LIBRO_MUST_EXIST);
        }, () -> {
            assertEquals(testObject.getDescripcion(), expected.get().getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        },() -> {
            assertEquals(testObject.getResumen(), expected.get().getResumen(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_RESUMEN);
        }, () -> {
            assertNotNull(expected.get().getCapitulo(), () -> ErrorMessageTestCases.CAPITULO_MUST_EXIST);
        });
    }

    @DisplayName("Test: Buscar Marca Libro por Id No Existente")
    @Test
    void testFindMarcaLibroByNoneExistingId_returnException() {
        // When
        Optional<MarcaLibro> objectToFind = repository.findById(10L);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, objectToFind::orElseThrow);
        }, () -> {
            assertFalse(objectToFind.isPresent(), () -> ErrorMessageTestCases.MARCA_LIBRO_MUST_NOT_EXIST);
        });
    }

    @DisplayName("Test: Guardar Marca Libro")
    @Test
    void testSaveMarcaLibro_returnMarcaLibroSaved() {
        // Given
        Autor autor = new Autor(7L, "'JONATHAN'", "'BLACK'");
        Categoria categoria = new Categoria(6L, "'ESOTERISMO'", "Libros sobre esoterismo, religion, teología");

        Libro libro = new Libro();
        libro.setId(6l);
        libro.setNombre("LA HISTORIA SECRETA DEL MUNDO");
        libro.setDescripcion("El mundo que nos rodea, los edificios, monumentos, las obras de arte , la literatura, los nombres de los dias de la semana, y hasta los cuentos infantiles encierran una filosofia secreta. Este libros nos da las claves para interpretarla");
        libro.setPortada(null);
        libro.setAutor(autor);
        libro.setCategoria(categoria);
        libro.setCreateAt(new Date());

        Capitulo capitulo = new Capitulo();
        capitulo.setLibro(libro);
        capitulo.setId(7L);
        capitulo.setNumero("0");
        capitulo.setNombre("INTRODUCCION");
        capitulo.setDescripcion("Introducción");

        MarcaLibro objectToSave = new MarcaLibro();
        objectToSave.setDescripcion("Rarezas II");
        objectToSave.setPaginas("34-27");
        objectToSave.setResumen("Rarezas II");
        objectToSave.setCapitulo(capitulo);

        // When
        MarcaLibro expected = repository.save(objectToSave);

        Iterable<MarcaLibro> listBd = repository.findAll();
        List<MarcaLibro> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertNotNull(expected.getId(), () -> ErrorMessageTestCases.GENERIC_NOT_NULL_ID);
        }, () -> {
            assertEquals(objectToSave.getDescripcion(), expected.getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        },() -> {
            assertEquals(objectToSave.getResumen(), expected.getResumen(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_RESUMEN);
        }, () -> {
            assertEquals(8, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Eliminar Marca Libro")
    @Test
    void testDeleteMarcaLibro() {
        // Given
        MarcaLibro objectToDelete = repository.findById(1L).orElseThrow();

        // When
        repository.delete(objectToDelete);

        Iterable<MarcaLibro> listBd = repository.findAll();
        List<MarcaLibro> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, () -> repository.findById(1L).orElseThrow());
        }, () -> {
            assertEquals(6, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Marcas Libros por Libro Existente")
    @Test
    void testFindMarcasLibrosByLibroExistente_returnMarcasLibros() {
        // Given
        Long libroId = 6L;
        // When
        Iterable<MarcaLibro> listBD = repository.findAllMarcasByLibro(libroId);
        List<MarcaLibro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(7, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Marcas Libros por Libro No Existente")
    @Test
    void testFindMarcasLibrosByLibroNoExistente_returnListaVacia() {
        // Given
        Long libroId = 4L;
        // When
        Iterable<MarcaLibro> listBD = repository.findAllMarcasByLibro(libroId);
        List<MarcaLibro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertTrue(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_FULL_LIST);
        });
    }

    @DisplayName("Test: Buscar Marcas Libros por Capitulo Existente")
    @Test
    void testFindMarcasLibrosByCapituloExistente_returnMarcasLibros() {
        // Given
        Long capituloId = 9L;
        // When
        Iterable<MarcaLibro> listBD = repository.findAllMarcasByCapitulo(capituloId);
        List<MarcaLibro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(3, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Marcas Libros por Capitulo No Existente")
    @Test
    void testFindMarcasLibrosByCapituloExistente_returnListaVacia() {
        // Given
        Long capituloId = 1L;
        // When
        Iterable<MarcaLibro> listBD = repository.findAllMarcasByCapitulo(capituloId);
        List<MarcaLibro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertTrue(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_FULL_LIST);
        });
    }
}
