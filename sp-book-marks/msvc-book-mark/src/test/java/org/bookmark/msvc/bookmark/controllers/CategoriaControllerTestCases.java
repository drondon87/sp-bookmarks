package org.bookmark.msvc.bookmark.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoriaControllerTestCases {

    @Autowired
    private TestRestTemplate client;

    private ObjectMapper objectMapper;

    @LocalServerPort
    private int puerto;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @DisplayName("Test: Detalle Categoria")
    @Test
    @Order(1)
    void testDetalleCategoria_returnCategoria() {
        ResponseEntity<Categoria> response = client.getForEntity(crearUri("/api/categorias/1"), Categoria.class);
        Categoria objectResponse = response.getBody();

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> "El Status de la respuesta no es igual");
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> "El content-type no es igual");
        }, () -> {
            assertNotNull(objectResponse);
        }, () -> {
            assertEquals(1L, objectResponse.getId(), () -> "El id no es correcto");
        }, () -> {
            assertEquals("Historia".toUpperCase(), objectResponse.getNombre(), () -> "El nombre de la categoria no es incorrecto");
        }, () -> {
            assertEquals("Libros sobre Historia", objectResponse.getDescripcion(), () -> "La descripcion no son iguales");
        });
    }

    @DisplayName("Test: Detalle Categoria no Existente")
    @Test
    @Order(2)
    void testDetalleCategoria_returnCategoriaNoExistente() {
        ResponseEntity<Categoria> response = client.getForEntity(crearUri("/api/categorias/6"), Categoria.class);
        Categoria objectResponse = response.getBody();

        assertAll(() -> {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode(), () -> "El Status de la respuesta no es igual");
        }, () -> {
            assertNull(response.getHeaders().getContentType(), () -> "El content-type no es igual");
        }, () -> {
            assertNull(objectResponse, () -> "La categoria no debe Existir");
        });
    }

    @DisplayName("Test: Listar Categorias")
    @Test
    @Order(3)
    void testListarCategorias_returnCategorias() {
        ResponseEntity<Categoria[]> response = client.getForEntity(crearUri("/api/categorias"), Categoria[].class);
        List<Categoria> objectList = Arrays.asList(response.getBody());

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> "El Status de la respuesta no es igual");
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> "El content-type no es igual");
        }, () -> {
            assertEquals(1l, objectList.get(0).getId(), () -> "El id no es correcto");
        }, () -> {
            assertEquals("Historia".toUpperCase(), objectList.get(0).getNombre(), () -> "El nombre de categoria es incorrecto");
        }, () -> {
            assertEquals("Libros sobre Historia", objectList.get(0).getDescripcion(), () -> "Las descripciones no son iguales");
        }, () -> {
            assertEquals(5, objectList.size(), () -> "La cantidad de categorias no es igual");
        });
    }

    @DisplayName("Test: Guardar Catgegoria")
    @Test
    @Order(4)
    void testGuardarCategoria() {
        Categoria objectToSave = new Categoria(null, "Humor", "Libro de Humor");

        ResponseEntity<Categoria> response = client.postForEntity(crearUri("/api/categorias"), objectToSave, Categoria.class);
        Categoria expected = response.getBody();

        assertAll(() -> {
            assertEquals(HttpStatus.CREATED, response.getStatusCode(), () -> "El Status de la respuesta no es igual");
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> "El content-type no es igual");
        }, () -> {
            assertNotNull(expected, () -> "La categoria debe existir");
        }, () -> {
            assertEquals(6L, expected.getId(), () -> "El id no es correcto");
        }, () -> {
            assertEquals("Humor".toUpperCase(), expected.getNombre(), () -> "El Nombre es incorrecta");
        }, () -> {
            assertEquals("Libro de Humor", expected.getDescripcion(), () -> "Las descripciones no son iguales");
        });
    }

    @DisplayName("Test: Guardar Catgegoria")
    @Test
    @Order(5)
    void testGuardarCategoriaNombreExistente() {
        Categoria objectToSave = new Categoria(null, "Humor", "Libro de Humor");

        ResponseEntity<Categoria> response = client.postForEntity(crearUri("/api/categorias"), objectToSave, Categoria.class);
        Categoria expected = response.getBody();

        assertAll(() -> {
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode(), () -> "El Status de la respuesta no es igual");
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> "El content-type no es igual");
        }, () -> {
            assertNull(expected.getId(), () -> "La categoria no debe existir");
        });
    }

    private String crearUri(String uri) {
        return "http://localhost:" + puerto + uri;
    }
}
