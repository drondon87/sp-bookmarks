package org.bookmark.msvc.bookmark.repositories;

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
public class AutorRepositoryTestCases {

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
            assertFalse(expected.isEmpty(), () -> "Los autores no pueden estar vacios");
        }, () -> {
            assertEquals(6, expected.size(), () -> "La cantidad de autores no es igual a la esperada");
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
            assertTrue(expected.isPresent(), () -> "El autor debe existir");
        }, () -> {
            assertEquals(testObject.getNombre(), expected.get().getNombre(), () -> "Los nombres no son iguales");
        }, () -> {
            assertEquals(testObject.getApellido(), expected.get().getApellido(), () -> "Los apellidos no son iguales");
        });
    }

    @DisplayName("Test: Buscar Autor por Id No Existente")
    @Test
    void testFindAutorByNoneExistingId_returnException() {
        // When
        Optional<Autor> objectToFind = repository.findById(7L);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, objectToFind::orElseThrow);
        }, () -> {
            assertFalse(objectToFind.isPresent(), () -> "El autor no debería de existir");
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
            assertNotNull(expected.getId(), () -> "El id no debe estar nulo");
        }, () -> {
            assertEquals(objectToSave.getNombre(), expected.getNombre(), () -> "Los nombres no son iguales");
        }, () -> {
            assertEquals(7, expectedList.size(), () -> "La lista no tiene la cantidad de categorias esperado");
        });
    }

    @DisplayName("Test: Eliminar Autor")
    @Test
    void testDeleteAutor() {
        // Given
        Autor objectToDelete = repository.findById(3L).orElseThrow();

        // When
        repository.delete(objectToDelete);

        Iterable<Autor> listBd = repository.findAll();
        List<Autor> expectedList = new ArrayList<>();
        listBd.forEach(expectedList::add);

        // Then
        assertAll(() -> {
            assertThrows(NoSuchElementException.class, () -> repository.findById(3L).orElseThrow());
        }, () -> {
            assertEquals(5, expectedList.size(), () -> "La cantidad de autores no son iguales");
        });
    }
}
