package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.TestData;
import org.bookmark.msvc.bookmark.models.entities.Capitulo;
import org.bookmark.msvc.bookmark.repositories.CapituloRepository;
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
public class CapituloServiceTestCases {

    @MockBean
    CapituloRepository repository;

    @Autowired
    CapituloService service;

    @DisplayName("Test: Listar Capitulos")
    @Test
    void testFindCapitulos_returnCapitulos() {

        // Given
        Iterable<Capitulo> listMockBD = Arrays.asList(TestData.getCapitulo01(), TestData.getCapitulo02(), TestData.getCapitulo03());
        when(repository.findAll()).thenReturn(listMockBD);

        // When
        List<Capitulo> expectedList = (List<Capitulo>) service.findAll();

        assertAll(() -> {
            assertEquals(3, expectedList.size(), () -> "No trajo la misma cantidad de capitulos");
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> "La lista no puede estar vacia");
        }, () -> {
            assertTrue(expectedList.contains(TestData.getCapitulo02()), () -> "La lista no tiene el objeto buscado");
        }, () -> {
            verify(repository, times(1)).findAll();
        });
    }

    @DisplayName("Test: Buscar Capitulo por Id")
    @Test
    void testFindCapituloById_returnCapitulo() {

        // Given
        Long objectId = 2L;
        when(repository.findById(anyLong())).thenReturn(Optional.of(TestData.getCapitulo02()));

        // When
        Optional<Capitulo> expected = service.findById(objectId);

        // Then
        assertAll(() -> {
            assertNotNull(expected.get(), () -> "El Capitulo no puede ser nulo");
        }, () -> {
            assertEquals("EL ASCO", expected.get().getNombre(), () -> "No es el nombre esperado");
        }, () -> {
            assertEquals("18 de julio de 96dc hora prima", expected.get().getDescripcion(), () -> "No es la descripcion esperada");
        }, () -> {
            assertNotNull(expected.get().getLibro(), () -> "El autor no puede estar nulo");
        }, () -> {
            verify(repository, times(1)).findById(anyLong());
        });
    }
}
