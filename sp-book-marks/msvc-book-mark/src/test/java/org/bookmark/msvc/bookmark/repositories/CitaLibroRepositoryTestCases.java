package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.bookmark.msvc.bookmark.models.entities.CitaLibro;
import org.bookmark.msvc.bookmark.models.entities.Libro;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CitaLibroRepositoryTestCases {

    @Autowired
    CitaLibroRepository repository;

    @DisplayName("Test: Buscar Citas Libros")
    @Test
    void testFindAllCitasLibros_returnCitasLibros() {
        // When
        Iterable<CitaLibro> listBD = repository.findAll();
        List<CitaLibro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(1, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Cita Libro por Id Existente")
    @Test
    void testFindCitaLibroByIdExistente_returnCitaLibro() {

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

        CitaLibro testObject = new CitaLibro();
        testObject.setId(1L);
        testObject.setLibro(libro);
        testObject.setPagina("65");
        testObject.setDescripcion("El Cita de Jung");

        // When
        Optional<CitaLibro> expected = repository.findById(1L);

        // Then
        assertAll(() -> {
            assertTrue(expected.isPresent(), () -> ErrorMessageTestCases.CITA_LIBRO_MUST_EXIST);
        }, () -> {
            assertEquals(testObject.getDescripcion(), expected.get().getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        }, () -> {
            assertNotNull(expected.get().getLibro(), () -> ErrorMessageTestCases.LIBRO_MUST_EXIST);
        });
    }

    @DisplayName("Test: Buscar Cita Libro por Id No Existente")
    @Test
    void testFindCitaLibroByNoneExistingId_returnException() {
        // When
        Optional<CitaLibro> objectToFind = repository.findById(7L);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, objectToFind::orElseThrow);
        }, () -> {
            assertFalse(objectToFind.isPresent(), () -> ErrorMessageTestCases.CITA_LIBRO_MUST_NOT_EXIST);
        });
    }

    @DisplayName("Test: Guardar Cita Libro")
    @Test
    void testSaveCitaLibro_returnCitaLibroSaved() {
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

        CitaLibro objectToSave = new CitaLibro();
        objectToSave.setLibro(libro);
        objectToSave.setPagina("65");
        objectToSave.setCreateAt(new Date());
        objectToSave.setDescripcion("El Cita de Jung 2");

        // When
        CitaLibro expected = repository.save(objectToSave);

        Iterable<CitaLibro> listBd = repository.findAll();
        List<CitaLibro> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertNotNull(expected.getId(), () -> ErrorMessageTestCases.GENERIC_NOT_NULL_ID);
        }, () -> {
            assertEquals(objectToSave.getDescripcion(), expected.getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        },() -> {
            assertEquals(objectToSave.getPagina(), expected.getPagina(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_PAGES);
        }, () -> {
            assertEquals(2, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Eliminar Cita Libro")
    @Test
    void testDeleteCitaLibro() {
        // Given
        CitaLibro objectToDelete = repository.findById(1L).orElseThrow();

        // When
        repository.delete(objectToDelete);

        Iterable<CitaLibro> listBd = repository.findAll();
        List<CitaLibro> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, () -> repository.findById(3L).orElseThrow());
        }, () -> {
            assertEquals(0, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Citas Libros por Libro Existente")
    @Test
    void testFindCitasLibrosByLibroExistente_returnCitasLibros() {
        // Given
        Long libroId = 6L;
        // When
        Iterable<CitaLibro> listBD = repository.findAllCitasByLibro(libroId);
        List<CitaLibro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(1, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Citas Libros por Libro No Existente")
    @Test
    void testFindCitasLibrosByLibroNoExistente_returnListaVacia() {
        // Given
        Long libroId = 4L;
        // When
        Iterable<CitaLibro> listBD = repository.findAllCitasByLibro(libroId);
        List<CitaLibro> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertTrue(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_FULL_LIST);
        });
    }
}
