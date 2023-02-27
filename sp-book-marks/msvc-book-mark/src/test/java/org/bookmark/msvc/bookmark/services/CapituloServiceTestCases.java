package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.TestData;
import org.bookmark.msvc.bookmark.models.entities.Capitulo;
import org.bookmark.msvc.bookmark.models.entities.Libro;
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
            assertEquals(3, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertTrue(expectedList.contains(TestData.getCapitulo02()), () -> ErrorMessageTestCases.GENERIC_NOT_FOUND_OBJECT_IN_LIST);
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
            assertNotNull(expected.get(), () -> ErrorMessageTestCases.CAPITULO_MUST_EXIST);
        }, () -> {
            assertEquals("EL ASCO", expected.get().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals("18 de julio de 96dc hora prima", expected.get().getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        }, () -> {
            assertNotNull(expected.get().getLibro(), () -> ErrorMessageTestCases.AUTOR_MUST_EXIST);
        }, () -> {
            verify(repository, times(1)).findById(anyLong());
        });
    }

    @DisplayName("Test: Guardar Capitulo")
    @Test
    void testSaveCapitulo_returnCapitulo() {

        // Given
        Capitulo objectToSave = new Capitulo();
        objectToSave.setNombre("El gran inicio");
        objectToSave.setDescripcion("Inicio de las batallas de trajano");
        objectToSave.setLibro(TestData.getLibro01());
        objectToSave.setNumero("7");

        when(repository.save(any())).then(invocation -> {
            Capitulo c = invocation.getArgument(0);
            c.setId(11l);
            return c;
        });

        // When
        Capitulo expected = service.save(objectToSave);

        // Then
        assertAll(() -> {
            assertEquals("El gran inicio".toUpperCase(), expected.getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals(11, expected.getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            assertNotNull(expected.getLibro(), () -> ErrorMessageTestCases.LIBRO_MUST_EXIST);
        }, () -> {
            verify(repository, times(1)).save(any());
        });
    }

    @DisplayName("Test: Eliminar Capitulo")
    @Test
    void testDeleteCapitulo() {

        // Given
        doNothing().when(repository).deleteById(anyLong());

        // When
        service.deleteById(3L);

        // Then
        verify(repository, times(1)).deleteById(anyLong());
    }

    @DisplayName("Test: Buscar Capitulos por Libros")
    @Test
    void testFindCapitulosByLibros_returnCapitulos() {

        // Given
        Long libroId = 1l;
        List<Capitulo> listMockBD = Arrays.asList(TestData.getCapitulo01(), TestData.getCapitulo02(), TestData.getCapitulo03());
        when(repository.findAllByLibro(libroId)).thenReturn(listMockBD);

        // When
        List<Capitulo> expectedList = service.listarCapitulosByLibro(libroId);

        // Then
        assertAll(() -> {
            assertEquals(3, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertTrue(expectedList.contains(TestData.getCapitulo03()), () -> ErrorMessageTestCases.GENERIC_NOT_FOUND_OBJECT_IN_LIST);
        }, () -> {
            verify(repository, times(1)).findAllByLibro(anyLong());
        });
    }
}
