package org.bookmark.msvc.bookmark.services;

import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.TestData;
import org.bookmark.msvc.bookmark.models.entities.Libro;
import org.bookmark.msvc.bookmark.repositories.LibroRepository;
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
public class LibroServiceTestCases {

    @MockBean
    LibroRepository repository;

    @Autowired
    LibroService service;

    @DisplayName("Test: Listar Libros")
    @Test
    void testFindLibros_returnLibros() {

        // Given
        Iterable<Libro> listMockBD = Arrays.asList(TestData.getLibro01(), TestData.getLibro02(), TestData.getLibro03());
        when(repository.findAll()).thenReturn(listMockBD);

        // When
        List<Libro> expectedList = (List<Libro>) service.findAll();

        assertAll(() -> {
            assertEquals(3, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertTrue(expectedList.contains(TestData.getLibro02()), () -> ErrorMessageTestCases.GENERIC_NOT_FOUND_OBJECT_IN_LIST);
        }, () -> {
            verify(repository, times(1)).findAll();
        });
    }

    @DisplayName("Test: Buscar Libro por Id")
    @Test
    void testFindLibroById_returnLibro() {

        // Given
        Long objectId = 2L;
        when(repository.findById(anyLong())).thenReturn(Optional.of(TestData.getLibro02()));

        // When
        Optional<Libro> expected = service.findById(objectId);

        // Then
        assertAll(() -> {
            assertNotNull(expected.get(), () -> ErrorMessageTestCases.LIBRO_MUST_EXIST);
        }, () -> {
            assertEquals("CIRCO MAXIMO", expected.get().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals("Trilogia de Trajano Volumen II", expected.get().getDescripcion(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_DESCRIPTION);
        }, () -> {
            assertNotNull(expected.get().getAutor(), () -> ErrorMessageTestCases.AUTOR_MUST_EXIST);
        }, () -> {
            assertNotNull(expected.get().getCategoria(), () -> ErrorMessageTestCases.CATEGORIA_MUST_EXIST);
        }, () -> {
            verify(repository, times(1)).findById(anyLong());
        });
    }

    @DisplayName("Test: Guardar Libro")
    @Test
    void testSaveLibro_returnLibro() {

        // Given
        Libro objectToSave = new Libro();
        objectToSave.setNombre("El capitan alatriste");
        objectToSave.setDescripcion("Las aventuras del capitan alatriste Volumen I");
        objectToSave.setAutor(TestData.getAutor01());
        objectToSave.setCategoria(TestData.getCategoria02());

        when(repository.save(any())).then(invocation -> {
            Libro c = invocation.getArgument(0);
            c.setId(4l);
            return c;
        });

        // When
        Libro expected = service.save(objectToSave);

        // Then
        assertAll(() -> {
            assertEquals("El capitan alatriste".toUpperCase(), expected.getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals(4, expected.getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            assertNotNull(expected.getCreateAt(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_DATE);
        }, () -> {
            assertNotNull(expected.getAutor(), () -> ErrorMessageTestCases.AUTOR_MUST_EXIST);
        }, () -> {
            assertNotNull(expected.getCategoria(), () -> ErrorMessageTestCases.CATEGORIA_MUST_EXIST);
        }, () -> {
            verify(repository, times(1)).save(any());
        });
    }

    @DisplayName("Test: Eliminar Libro")
    @Test
    void testDeleteLibro() {

        // Given
        doNothing().when(repository).deleteById(anyLong());

        // When
        service.deleteById(3L);

        // Then
        verify(repository, times(1)).deleteById(anyLong());
    }

    @DisplayName("Test: Buscar Libro por Nombre")
    @Test
    void testFindLibroByNombre_returnLibro() {

        // Given
        String objectName = "NADIE SE VA A REIR";
        when(repository.findByNombre(objectName)).thenReturn(Optional.of(TestData.getLibro03()));

        // When
        Optional<Libro> expected = service.buscarByNombre(objectName);

        // Then
        assertAll(() -> {
            assertNotNull(expected.get(), () -> ErrorMessageTestCases.LIBRO_MUST_EXIST);
        }, () -> {
            assertEquals(objectName, expected.get().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            verify(repository, times(1)).findByNombre(objectName);
        });
    }

    @DisplayName("Test: Buscar Libros por Categorias")
    @Test
    void testFindLibroByCategorias_returnLibros() {

        // Given
        Long categoriaId = 2l;
        List<Libro> listMockBD = Arrays.asList(TestData.getLibro01(), TestData.getLibro02());
        when(repository.findAllByCategoria(categoriaId)).thenReturn(listMockBD);

        // When
        List<Libro> expectedList = service.findAllByCategoria(categoriaId);

        // Then
        assertAll(() -> {
            assertEquals(2, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertTrue(expectedList.contains(TestData.getLibro02()), () -> ErrorMessageTestCases.GENERIC_NOT_FOUND_OBJECT_IN_LIST);
        }, () -> {
            verify(repository, times(1)).findAllByCategoria(anyLong());
        });
    }

    @DisplayName("Test: Buscar Libros por Autor")
    @Test
    void testFindLibroByAutor_returnLibros() {

        // Given
        Long autorId = 3l;
        List<Libro> listMockBD = Arrays.asList(TestData.getLibro01(), TestData.getLibro02());
        when(repository.findAllByAutor(autorId)).thenReturn(listMockBD);

        // When
        List<Libro> expectedList = service.findAllByAutor(autorId);

        // Then
        assertAll(() -> {
            assertEquals(2, expectedList.size(), () -> ErrorMessageTestCases.GENERIC_NOT_EXPECTED_LIST);
        }, () -> {
            assertFalse(expectedList.isEmpty(), () -> ErrorMessageTestCases.GENERIC_NOT_EMPTY_LIST);
        }, () -> {
            assertTrue(expectedList.contains(TestData.getLibro01()), () -> ErrorMessageTestCases.GENERIC_NOT_FOUND_OBJECT_IN_LIST);
        }, () -> {
            verify(repository, times(1)).findAllByAutor(anyLong());
        });
    }

}
