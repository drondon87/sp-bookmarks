package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.TestData;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.bookmark.msvc.bookmark.repositories.CategoriaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CategoriaServiceTestCase {

    @MockBean
    CategoriaRepository repository;

    @Autowired
    CategoriaService service;

    @DisplayName("Test: Listar Categorias")
    @Test
    void testFindCategorias_returnCategorias() {

        // Given
        Iterable<Categoria> listMockBD = Arrays.asList(TestData.getCategoria01(), TestData.getCategoria02(), TestData.getCategoria03());
        when(repository.findAll()).thenReturn(listMockBD);

        // When
        List<Categoria> expectedList = (List<Categoria>) service.findAll();

        assertAll(() -> {
            assertEquals(3, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertTrue(expectedList.contains(TestData.getCategoria03()), () -> ErrorMessageTestCases.GENERIC_NOT_FOUND_OBJECT_IN_LIST);
        }, () -> {
            verify(repository, times(1)).findAll();
        });
    }

    @DisplayName("Test: Buscar Categoria por Id")
    @Test
    void testFindCategoriaById_returnCategoria() {

        // Given
        Long objectId = 2L;
        when(repository.findById(anyLong())).thenReturn(Optional.of(TestData.getCategoria02()));

        // When
        Optional<Categoria> expected = service.findById(objectId);

        // Then
        assertAll(() -> {
            assertNotNull(expected.get(), () -> ErrorMessageTestCases.CAPITULO_MUST_EXIST);
        }, () -> {
            assertEquals("Novela".toUpperCase(), expected.get().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            verify(repository, times(1)).findById(anyLong());
        });
    }

    @DisplayName("Test: Guardar Categoria")
    @Test
    void testSaveCategoria_returnCategoria() {

        // Given
        Categoria objectToSave = new Categoria(null, "Filosofía", "Libros de Filosofía");

        when(repository.save(any())).then(invocation -> {
            Categoria c = invocation.getArgument(0);
            c.setId(4l);
            return c;
        });

        // When
        Categoria expected = service.save(objectToSave);

        // Then
        assertAll(() -> {
            assertEquals("Filosofía".toUpperCase(), expected.getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals(4, expected.getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            verify(repository, times(1)).save(any());
        });
    }

    @DisplayName("Test: Eliminar Categoria")
    @Test
    void testDeleteCategoria() {

        // Given
        doNothing().when(repository).deleteById(anyLong());

        // When
        service.deleteById(3L);

        // Then
        verify(repository, times(1)).deleteById(anyLong());
    }

    @DisplayName("Test: Buscar Categoria por Nombre")
    @Test
    void testFindCategoriaByNombre_returnCategoria() {

        // Given
        String objectName = "NOVELA";
        when(repository.findByNombre(objectName)).thenReturn(Optional.of(TestData.getCategoria02()));

        // When
        Optional<Categoria> expected = service.buscarByNombre(objectName);

        // Then
        assertAll(() -> {
            assertNotNull(expected.get(), () -> ErrorMessageTestCases.CATEGORIA_MUST_EXIST);
        }, () -> {
            assertEquals("NOVELA", expected.get().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            verify(repository, times(1)).findByNombre(objectName);
        });
    }

    @DisplayName("Test: Existe Categoria por Nombre")
    @Test
    void testExisteCategoriaByNombre_returnCategoria() {

        // Given
        String objectName = "NOVELA";
        when(repository.existsByNombre(objectName)).thenReturn(true);

        // When
        boolean expected = service.existeNombre(objectName);

        // Then
        assertAll(() -> {
            assertTrue(expected, () -> ErrorMessageTestCases.CATEGORIA_MUST_EXIST);
        }, () -> {
            verify(repository, times(1)).existsByNombre(objectName);
        });
    }

}
