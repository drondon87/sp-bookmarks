package org.bookmark.msvc.bookmark.repositories;

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
            assertFalse(expected.isEmpty(), () -> "Las categorias no pueden estar vacios");
        }, () -> {
            assertEquals(5, expected.size(), () -> "La cantidad de categorias no es igual a la esperada");
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
            assertTrue(expected.isPresent(), () -> "La categoria debe existir");
        }, () -> {
            assertEquals(testObject.getNombre(), expected.get().getNombre(), () -> "Los nombres de categoria no son iguales");
        }, () -> {
            assertEquals(testObject.getDescripcion(), expected.get().getDescripcion(), () -> "La descripcion de la categoria no son iguales");
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
            assertFalse(objectToFind.isPresent(), () -> "La categoria no debería de existir");
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
            assertNotNull(expected.getId(), () -> "El id no debe estar nulo");
        }, () -> {
            assertEquals(objectToSave.getNombre(), expected.getNombre(), () -> "Los nombres no son iguales");
        }, () -> {
            assertEquals(6, expectedList.size(), () -> "La lista no tiene la cantidad de categorias esperado");
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
            assertEquals(4, expectedList.size(), () -> "La cantidad de categorias no son iguales");
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
            assertTrue(expected.isPresent(), () -> "La categoria debe existir");
        }, () -> {
            assertEquals(objectName, expected.get().getNombre(), () -> "Los nombres no son iguales");
        }, () -> {
            assertEquals(3, expected.get().getId(), () -> "Los id no son iguales");
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
            assertFalse(expected.isPresent(), () -> "La categoria no debería de existir");
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
            assertTrue(expected, () -> "El usuario debe existir");
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
            assertFalse(expected, () -> "El usuario no debe existir");
        });
    }

}
