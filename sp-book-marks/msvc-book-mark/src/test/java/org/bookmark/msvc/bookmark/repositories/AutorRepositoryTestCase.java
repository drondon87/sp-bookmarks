package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class AutorRepositoryTestCase {

    @Autowired
    AutorRepository repository;

    @DisplayName("Test: Buscar Autores")
    @Test
    void testFindAllAutores_returnAutores() {
        // When
        Iterable<Autor> listBD = repository.findAll();
        List<Autor> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(7, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Autor por Id Existente")
    @Test
    void testFindAutorByIdExistente_returnAutor() {
        // Given
        Autor testObject = new Autor();
        testObject.setId(2L);
        testObject.setNombre("ANABEL");
        testObject.setApellido("HERNANDEZ");

        // When
        Optional<Autor> expected = repository.findById(2l);

        // Then
        assertAll(() -> {
            assertTrue(expected.isPresent(), () -> ErrorMessageTestCases.AUTOR_MUST_EXIST);
        }, () -> {
            assertEquals(testObject.getNombre(), expected.get().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals(testObject.getApellido(), expected.get().getApellido(), () -> ErrorMessageTestCases.AUTOR_DIFERENT_LAST_NAME);
        });
    }

    @DisplayName("Test: Buscar Autor por Id No Existente")
    @Test
    void testFindAutorByNoneExistingId_returnException() {
        // When
        Optional<Autor> objectToFind = repository.findById(15L);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, objectToFind::orElseThrow);
        }, () -> {
            assertFalse(objectToFind.isPresent(), () -> ErrorMessageTestCases.AUTOR_MUST_NOT_EXIST);
        });
    }

    @DisplayName("Test: Guardar Autor")
    @Test
    void testSaveAutor_returnAutorSaved() {
        // Given
        Autor objectToSave = new Autor();
        objectToSave.setNombre("Thays".toUpperCase());
        objectToSave.setApellido("Peñalver".toUpperCase());

        // When
        Autor expected = repository.save(objectToSave);

        Iterable<Autor> listBd = repository.findAll();
        List<Autor> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertNotNull(expected.getId(), () -> ErrorMessageTestCases.GENERIC_NOT_NULL_ID);
        }, () -> {
            assertEquals(objectToSave.getNombre(), expected.getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals(8, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Eliminar Autor")
    @Test
    void testDeleteAutor() {
        // Given
        Autor objectToDelete = repository.findById(6L).orElseThrow();

        // When
        repository.delete(objectToDelete);

        Iterable<Autor> listBd = repository.findAll();
        List<Autor> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, () -> repository.findById(6L).orElseThrow());
        }, () -> {
            assertEquals(6, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }
}
