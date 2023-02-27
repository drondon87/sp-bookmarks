package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.TestData;
import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.bookmark.msvc.bookmark.repositories.AutorRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@SpringBootTest
public class AutorServiceTestCases {

    @MockBean
    AutorRepository repository;

    @Autowired
    AutorService service;

    @DisplayName("Test: Listar Autor")
    @Test
    void testFindAutores_returnAutores() {

        // Given
        Iterable<Autor> listMockBD = Arrays.asList(TestData.getAutor01(), TestData.getAutor02(), TestData.getAutor03());
        when(repository.findAll()).thenReturn(listMockBD);

        // When
        List<Autor> expectedList = (List<Autor>) service.findAll();

        assertAll(() -> {
            assertEquals(3, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertTrue(expectedList.contains(TestData.getAutor03()), () -> ErrorMessageTestCases.GENERIC_NOT_FOUND_OBJECT_IN_LIST);
        }, () -> {
            verify(repository, times(1)).findAll();
        });
    }

    @DisplayName("Test: Buscar Autor por Id")
    @Test
    void testFindAutorById_returnAutor() {

        // Given
        Long objectId = 2L;
        when(repository.findById(anyLong())).thenReturn(Optional.of(TestData.getAutor02()));

        // When
        Optional<Autor> expected = service.findById(objectId);

        // Then
        assertAll(() -> {
                    assertNotNull(expected.get(), () -> ErrorMessageTestCases.AUTOR_MUST_EXIST);
                }, () -> {
                    assertEquals("ANABEL".toUpperCase(), expected.get().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
                }, () -> {
                    assertEquals("HERNANDEZ".toUpperCase(), expected.get().getApellido(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_LAST_NAMES);
                },
                () -> {
                    verify(repository, times(1)).findById(anyLong());
                });
    }

    @DisplayName("Test: Guardar Autor")
    @Test
    void testSaveAutor_returnAutor() {

        // Given
        Autor objectToSave = new Autor(null, "Thays".toUpperCase(), "Peñalver".toUpperCase());

        when(repository.save(any())).then(invocation -> {
            Autor c = invocation.getArgument(0);
            c.setId(4l);
            return c;
        });

        // When
        Autor expected = service.save(objectToSave);

        // Then
        assertAll(() -> {
            assertEquals("Thays".toUpperCase(), expected.getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals("Peñalver".toUpperCase(), expected.getApellido(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_LAST_NAMES);
        },
        () -> {
            assertEquals(4, expected.getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            verify(repository, times(1)).save(any());
        });
    }

    @DisplayName("Test: Eliminar Autor")
    @Test
    void testDeleteAutor() {

        // Given
        doNothing().when(repository).deleteById(anyLong());

        // When
        service.deleteById(3L);

        // Then
        verify(repository, times(1)).deleteById(anyLong());
    }
}
