package org.bookmark.msvc.bookmark.repositories;

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
            assertFalse(expected.isEmpty(), () -> "Los libros no pueden estar vacios");
        }, () -> {
            assertEquals(5, expected.size(), () -> "La cantidad de libros no es igual a la esperada");
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
            assertTrue(expected.isPresent(), () -> "El libro debe existir");
        }, () -> {
            assertEquals(testObject.getNombre(), expected.get().getNombre(), () -> "Los nombres no son iguales");
        }, () -> {
            assertEquals(testObject.getDescripcion(), expected.get().getDescripcion(), () -> "La descripcion no son iguales");
        }, () -> {
            assertNotNull(expected.get().getAutor(), () -> "El autor no puede estar nulo");
        }, () -> {
            assertEquals(testObject.getAutor().getId(), expected.get().getAutor().getId(), () -> "Los ids no son iguales");
        },() -> {
            assertEquals(testObject.getAutor().getNombre(), expected.get().getAutor().getNombre(), () -> "Los nombres no son iguales");
        }, () -> {
            assertNotNull(expected.get().getCategoria(), () -> "La categoria no puede estar nulo");
        }, () -> {
            assertEquals(testObject.getCategoria().getNombre(), expected.get().getCategoria().getNombre(), () -> "Los nombres no son iguales");
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
            assertFalse(objectToFind.isPresent(), () -> "El nombre no debería de existir");
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
            assertNotNull(expected.getId(), () -> "El id no debe estar nulo");
        }, () -> {
            assertEquals(objectToSave.getNombre(), expected.getNombre(), () -> "Los nombres no son iguales");
        }, () -> {
            assertEquals(6, expectedList.size(), () -> "La lista no tiene la cantidad de categorias esperado");
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
            assertEquals(4, expectedList.size(), () -> "La cantidad de libros no son iguales");
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
            assertTrue(expected.isPresent(), () -> "El libro debe existir");
        }, () -> {
            assertEquals(objectName, expected.get().getNombre(), () -> "Los nombres no son iguales");
        }, () -> {
            assertEquals(2, expected.get().getId(), () -> "Los id no son iguales");
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
            assertFalse(expected.isPresent(), () -> "El libro no debería de existir");
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
            assertFalse(expected.isEmpty(), () -> "Los libros no pueden estar vacios");
        }, () -> {
            assertEquals(4, expected.size(), () -> "La cantidad de libros no es igual a la esperada");
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
            assertTrue(expected.isEmpty(), () -> "Los libros no pueden estar lleno");
        }, () -> {
            assertEquals(0, expected.size(), () -> "La cantidad de libros no es igual a la esperada");
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
            assertFalse(expected.isEmpty(), () -> "Los libros no pueden estar vacios");
        }, () -> {
            assertEquals(2, expected.size(), () -> "La cantidad de libros no es igual a la esperada");
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
            assertTrue(expected.isEmpty(), () -> "Los libros no pueden estar lleno");
        }, () -> {
            assertEquals(0, expected.size(), () -> "La cantidad de libros no es igual a la esperada");
        });
    }
}
