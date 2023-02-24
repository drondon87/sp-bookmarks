package org.bookmark.msvc.bookmark.repositories;

import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
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
public class CategoriaRepositoryTestCases {

    @Autowired
    CategoriaRepository repository;

    @DisplayName("Test: Buscar Categorias")
    @Test
    void testFindAllCategorias_returnCategorias() {
        // When
        Iterable<Categoria> listBD = repository.findAll();
        List<Categoria> expected = new ArrayList<>();
        listBD.forEach(expected::add);

        // Then
        assertAll(() -> {
            assertFalse(expected.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertEquals(6, expected.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Categoria por Id Existente")
    @Test
    void testFindCategoriaByIdExistente_returnCategoria() {
        // Given
        Categoria testObject = new Categoria();
        testObject.setId(2L);
        testObject.setNombre("Novela".toUpperCase());
        testObject.setDescripcion("Novelas historicas, psicologicas, politicas");

        // When
        Optional<Categoria> expected = repository.findById(2l);

        // Then
        assertAll(() -> {
            assertTrue(expected.isPresent(), () -> ErrorMessageTestCases.CATEGORIA_MUST_EXIST);
        }, () -> {
            assertEquals(testObject.getNombre(), expected.get().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals(testObject.getDescripcion(), expected.get().getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        });
    }

    @DisplayName("Test: Buscar Categoria por Id No Existente")
    @Test
    void testFindCategoriaByNoneExistingId_returnException() {
        // When
        Optional<Categoria> objectToFind = repository.findById(7L);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, objectToFind::orElseThrow);
        }, () -> {
            assertFalse(objectToFind.isPresent(), () -> ErrorMessageTestCases.CATEGORIA_MUST_NOT_EXIST);
        });
    }

    @DisplayName("Test: Guardar Categoria")
    @Test
    void testSaveCategoria_returnCategoriaSaved() {
        // Given
        Categoria objectToSave = new Categoria();
        objectToSave.setNombre("HUMOR");
        objectToSave.setDescripcion("Libro de Humor");

        // When
        Categoria expected = repository.save(objectToSave);

        Iterable<Categoria> listBd = repository.findAll();
        List<Categoria> expectedList = new ArrayList<>();
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

    @DisplayName("Test: Eliminar Categoria")
    @Test
    void testDeleteCategoria() {
        // Given
        Categoria objectToDelete = repository.findById(3L).orElseThrow();

        // When
        repository.delete(objectToDelete);

        Iterable<Categoria> listBd = repository.findAll();
        List<Categoria> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, () -> repository.findById(3L).orElseThrow());
        }, () -> {
            assertEquals(5, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Categoria por Nombre Existente")
    @Test
    void testFindCategoriaByNombreExistente_returnCategoria() {
        // Given
        String objectName = "Psicologia".toUpperCase();
        // When
        Optional<Categoria> expected = repository.findByNombre(objectName);

        // Then
        assertAll(() -> {
            assertTrue(expected.isPresent(), () -> ErrorMessageTestCases.CATEGORIA_MUST_EXIST);
        }, () -> {
            assertEquals(objectName, expected.get().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals(3, expected.get().getId(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        });
    }

    @DisplayName("Test: Buscar Categoria por Nombre No Existente")
    @Test
    void testFindCategoriaByNonExistingNombre_returnException() {
        // Given
        String objectName = "HUMOR";

        // When
        Optional<Categoria> expected = repository.findByNombre(objectName);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, expected::orElseThrow);
        }, () -> {
            assertFalse(expected.isPresent(), () -> ErrorMessageTestCases.CATEGORIA_MUST_NOT_EXIST);
        });
    }

    @DisplayName("Test: Buscar Categoria por Nombre Existente Boolean")
    @Test
    void testFindCategoriaByNombreExistenteBoolean_returnTrue() {
        // Given
        String objectName = "Psicologia".toUpperCase();
        // When
        boolean expected = repository.existsByNombre(objectName);

        // Then
        assertAll(() -> {
            assertTrue(expected, () -> ErrorMessageTestCases.GENERIC_NAME_MUST_EXIST);
        });
    }

    @DisplayName("Test: Buscar Categoria por Nombre No Existente Boolean")
    @Test
    void testFindCategoriaByNombreNoExistenteBoolean_returnFalse() {
        // Given
        String objectName = "HUMOR";
        // When
        boolean expected = repository.existsByNombre(objectName);

        // Then
        assertAll(() -> {
            assertFalse(expected, () -> ErrorMessageTestCases.GENERIC_NAME_MUST_NOT_EXIST);
        });
    }

}
