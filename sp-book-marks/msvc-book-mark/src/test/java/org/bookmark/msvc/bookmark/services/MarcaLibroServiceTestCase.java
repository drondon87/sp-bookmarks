package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.TestData;
import org.bookmark.msvc.bookmark.models.entities.MarcaLibro;
import org.bookmark.msvc.bookmark.repositories.MarcaLibroRepository;
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
public class MarcaLibroServiceTestCase {

    @MockBean
    MarcaLibroRepository repository;

    @Autowired
    MarcaLibroService service;

    @DisplayName("Test: Listar Marcas Libros")
    @Test
    void testFindMarcasLibros_returnMarcasLibros() {

        // Given
        Iterable<MarcaLibro> listMockBD = Arrays.asList(TestData.getMarcaLibro01());
        when(repository.findAll()).thenReturn(listMockBD);

        // When
        List<MarcaLibro> expectedList = (List<MarcaLibro>) service.findAll();

        assertAll(() -> {
            assertEquals(1, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            verify(repository, times(1)).findAll();
        });
    }

    @DisplayName("Test: Buscar Marca Libro por Id")
    @Test
    void testFindMarcaLibroById_returnMarcaLibro() {

        // Given
        Long objectId = 1L;
        when(repository.findById(anyLong())).thenReturn(Optional.of(TestData.getMarcaLibro01()));

        // When
        Optional<MarcaLibro> expected = service.findById(objectId);

        // Then
        assertAll(() -> {
            assertNotNull(expected.get(), () -> ErrorMessageTestCases.CITA_LIBRO_MUST_EXIST);
        }, () -> {
            assertEquals(TestData.getMarcaLibro01().getPaginas(), expected.get().getPaginas(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_PAGES);
        }, () -> {
            assertEquals(TestData.getMarcaLibro01().getDescripcion(), expected.get().getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        }, () -> {
            assertNotNull(expected.get().getCapitulo(), () -> ErrorMessageTestCases.CAPITULO_MUST_EXIST);
        }, () -> {
            verify(repository, times(1)).findById(anyLong());
        });
    }

    @DisplayName("Test: Guardar Marca Libro")
    @Test
    void testSaveMarcaLibro_returnMarcaLibro() {

        // Given
        MarcaLibro objectToSave = new MarcaLibro();
        objectToSave.setCapitulo(TestData.getCapitulo01());
        objectToSave.setDescripcion("Nueva Marca Hora");
        objectToSave.setPaginas("34");
        objectToSave.setResumen("Prueba de nuevas marcas");

        when(repository.save(any())).then(invocation -> {
            MarcaLibro c = invocation.getArgument(0);
            c.setId(2l);
            return c;
        });

        // When
        MarcaLibro expected = service.save(objectToSave);

        // Then
        assertAll(() -> {
            assertEquals(objectToSave.getDescripcion(), expected.getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        }, () -> {
            assertEquals(2, expected.getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            assertNotNull(expected.getCapitulo(), () -> ErrorMessageTestCases.CAPITULO_MUST_EXIST);
        },  () -> {
            verify(repository, times(1)).save(any());
        });
    }

    @DisplayName("Test: Eliminar Marca Libro")
    @Test
    void testDeleteMarcaLibro() {

        // Given
        doNothing().when(repository).deleteById(anyLong());

        // When
        service.deleteById(1L);

        // Then
        verify(repository, times(1)).deleteById(anyLong());
    }

    @DisplayName("Test: Buscar Marcas Libros por Libro")
    @Test
    void testFindMarcasLibroByLibro_returnMarcasLibros() {

        // Given
        Long libroId = 1l;
        List<MarcaLibro> listMockBD = Arrays.asList(TestData.getMarcaLibro01());
        when(repository.findAllMarcasByLibro(libroId)).thenReturn(listMockBD);

        // When
        List<MarcaLibro> expectedList = service.listarMarcasByLibro(libroId);

        // Then
        assertAll(() -> {
            assertEquals(1, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            verify(repository, times(1)).findAllMarcasByLibro(anyLong());
        });
    }

    @DisplayName("Test: Buscar Marcas Libros por Capitulo")
    @Test
    void testFindMarcasLibroByCapitulo_returnMarcasLibros() {

        // Given
        Long capituloId = 1l;
        List<MarcaLibro> listMockBD = Arrays.asList(TestData.getMarcaLibro01());
        when(repository.findAllMarcasByCapitulo(capituloId)).thenReturn(listMockBD);

        // When
        List<MarcaLibro> expectedList = service.listarMarcasByCapitulo(capituloId);

        // Then
        assertAll(() -> {
            assertEquals(1, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            verify(repository, times(1)).findAllMarcasByCapitulo(anyLong());
        });
    }
}
