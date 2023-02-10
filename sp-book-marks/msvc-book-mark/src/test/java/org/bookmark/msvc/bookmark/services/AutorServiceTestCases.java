package org.bookmark.msvc.bookmark.services;

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
            assertEquals(3, expectedList.size(), () -> "No trajo la misma cantidad de autores");
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> "La lista no puede estar vacia");
        }, () -> {
            assertTrue(expectedList.contains(TestData.getAutor03()), () -> "La lista no tiene el autor buscado");
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
                    assertNotNull(expected.get(), () -> "El autor no puede ser nulo");
                }, () -> {
                    assertEquals("ANABEL".toUpperCase(), expected.get().getNombre(), () -> "El nombre no es igual al esperado");
                }, () -> {
                    assertEquals("HERNANDEZ".toUpperCase(), expected.get().getApellido(), () -> "El apellido no es igual al esperado");
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
            assertEquals("Thays".toUpperCase(), expected.getNombre(), () -> "Los Nombres no son iguales");
        }, () -> {
            assertEquals("Peñalver".toUpperCase(), expected.getApellido(), () -> "Los Apellidos no son iguales");
        },
        () -> {
            assertEquals(4, expected.getId(), () -> "Los ids no son iguales");
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
