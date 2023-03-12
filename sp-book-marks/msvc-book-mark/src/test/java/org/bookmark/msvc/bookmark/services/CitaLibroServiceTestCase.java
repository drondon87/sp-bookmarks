package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.TestData;
import org.bookmark.msvc.bookmark.models.entities.CitaLibro;
import org.bookmark.msvc.bookmark.repositories.CitaLibroRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CitaLibroServiceTestCase {

    @MockBean
    CitaLibroRepository repository;

    @Autowired
    CitaLibroService service;

    @DisplayName("Test: Listar Citas Libros")
    @Test
    void testFindCitasLibros_returnCitasLibros() {

        // Given
        Iterable<CitaLibro> listMockBD = Arrays.asList(TestData.getCitaLibro01());
        when(repository.findAll()).thenReturn(listMockBD);

        // When
        List<CitaLibro> expectedList = (List<CitaLibro>) service.findAll();

        assertAll(() -> {
            assertEquals(1, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            verify(repository, times(1)).findAll();
        });
    }

    @DisplayName("Test: Buscar Cita Libro por Id")
    @Test
    void testFindCitaLibroById_returnCitaLibro() {

        // Given
        Long objectId = 1L;
        when(repository.findById(anyLong())).thenReturn(Optional.of(TestData.getCitaLibro01()));

        // When
        Optional<CitaLibro> expected = service.findById(objectId);

        // Then
        assertAll(() -> {
            assertNotNull(expected.get(), () -> ErrorMessageTestCases.CITA_LIBRO_MUST_EXIST);
        }, () -> {
            assertEquals(TestData.getCitaLibro01().getPagina(), expected.get().getPagina(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_PAGES);
        }, () -> {
            assertEquals(TestData.getCitaLibro01().getDescripcion(), expected.get().getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        }, () -> {
            assertNotNull(expected.get().getLibro(), () -> ErrorMessageTestCases.LIBRO_MUST_EXIST);
        }, () -> {
            verify(repository, times(1)).findById(anyLong());
        });
    }

    @DisplayName("Test: Guardar Cita Libro")
    @Test
    void testSaveCitaLibro_returnCitaLibro() {

        // Given
        CitaLibro objectToSave = new CitaLibro();
        objectToSave.setLibro(TestData.getLibro01());
        objectToSave.setDescripcion("El Cita de Jung II");
        objectToSave.setPagina("34");

        when(repository.save(any())).then(invocation -> {
            CitaLibro c = invocation.getArgument(0);
            c.setId(2l);
            return c;
        });

        // When
        CitaLibro expected = service.save(objectToSave);

        // Then
        assertAll(() -> {
            assertEquals(objectToSave.getDescripcion(), expected.getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        }, () -> {
            assertEquals(2, expected.getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            assertNotNull(expected.getCreateAt(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_DATE);
        }, () -> {
            assertNotNull(expected.getLibro(), () -> ErrorMessageTestCases.LIBRO_MUST_EXIST);
        },  () -> {
            verify(repository, times(1)).save(any());
        });
    }

    @DisplayName("Test: Eliminar Cita Libro")
    @Test
    void testDeleteCitaLibro() {

        // Given
        doNothing().when(repository).deleteById(anyLong());

        // When
        service.deleteById(3L);

        // Then
        verify(repository, times(1)).deleteById(anyLong());
    }

    @DisplayName("Test: Buscar Citas Libros por Libro")
    @Test
    void testFindCitasLibroByLibro_returnCitasLibros() {

        // Given
        Long libroId = 1l;
        List<CitaLibro> listMockBD = Arrays.asList(TestData.getCitaLibro01());
        when(repository.findAllCitasByLibro(libroId)).thenReturn(listMockBD);

        // When
        List<CitaLibro> expectedList = service.listarCitasByLibro(libroId);

        // Then
        assertAll(() -> {
            assertEquals(1, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            verify(repository, times(1)).findAllCitasByLibro(anyLong());
        });
    }
}
