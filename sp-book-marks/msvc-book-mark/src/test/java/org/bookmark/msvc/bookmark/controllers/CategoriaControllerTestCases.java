package org.bookmark.msvc.bookmark.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.junit.jupiter.api.*;
import org.springcloud.msvc.commons.constants.MessagesConstants;
import org.springcloud.msvc.commons.constants.ResponseConstants;
import org.springcloud.msvc.commons.response.CommonsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.*;

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
        ResponseEntity<Object> response = client.getForEntity(crearUri("/api/categorias/1"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Categoria> commonsResponse = getResponse(objectResponse);

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> "El Status de la respuesta no es igual");
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> "El content-type no es igual");
        }, () -> {
            assertNotNull(objectResponse, () -> "El objectResponse no puede estar nulo");
        }, () -> {
            assertEquals(ResponseConstants.SUCCESS, commonsResponse.getStatus(), () -> "Status no iguales");
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.OK), commonsResponse.getCode(), () -> "Codigos no iguales");
        }, () -> {
            assertEquals(ResponseConstants.OK, commonsResponse.getMessage(), () -> "Mensajes no iguales");
        }, () -> {
            assertNull(commonsResponse.getErrors(), () -> "Errores debe estar nulo");
        }, () -> {
            assertEquals(1L, commonsResponse.getData().getId(), () -> "ID no son iguales");
        }, () -> {
            assertEquals("Historia".toUpperCase(), commonsResponse.getData().getNombre(), () -> "Nombre no iguales");
        });
    }

    @DisplayName("Test: Detalle Categoria no Existente")
    @Test
    @Order(2)
    void testDetalleCategoria_returnCategoriaNoExistente() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("/api/categorias/6"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Categoria> commonsResponse = getResponse(objectResponse);

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> "El Status de la respuesta no es igual");
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> "El content-type no es igual");
        }, () -> {
            assertNotNull(objectResponse, () -> "El objectResponse no puede estar nulo");
        }, () -> {
            assertEquals(ResponseConstants.NOT_OK, commonsResponse.getStatus(), () -> "Status no iguales");
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.NOT_FOUND), commonsResponse.getCode(), () -> "Codigos no iguales");
        }, () -> {
            assertEquals(MessagesConstants.NOT_FOUND_MSG, commonsResponse.getMessage(), () -> "Mensajes no iguales");
        }, () -> {
            assertNull(commonsResponse.getErrors(), () -> "Errores debe estar nulo");
        }, () -> {
            assertNull(commonsResponse.getData(), () -> "Data debe estar nulo");
        });
    }

    @DisplayName("Test: Listar Categorias")
    @Test
    @Order(3)
    void testListarCategorias_returnCategorias() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("/api/categorias"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> "El Status de la respuesta no es igual");
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> "El content-type no es igual");
        }, () -> {
            assertNotNull(objectResponse, () -> "El objectResponse no puede estar nulo");
        }, () -> {
            assertEquals(ResponseConstants.SUCCESS, objectResponse.get("status").toString(), () -> "Status no iguales");
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.OK), objectResponse.get("code").toString(), () -> "Codigos no iguales");
        }, () -> {
            assertEquals(ResponseConstants.OK, objectResponse.get("message").toString(), () -> "Mensajes no iguales");
        });
    }

    @DisplayName("Test: Guardar Catgegoria")
    @Test
    @Order(4)
    void testGuardarCategoria() {
        Categoria objectToSave = new Categoria(null, "Humor", "Libro de Humor");

        ResponseEntity<Object> response = client.postForEntity(crearUri("/api/categorias"), objectToSave, Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Categoria> commonsResponse = getResponse(objectResponse);

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> "El Status de la respuesta no es igual");
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> "El content-type no es igual");
        }, () -> {
            assertNotNull(objectResponse, () -> "El objectResponse no puede estar nulo");
        }, () -> {
            assertEquals(ResponseConstants.SUCCESS, commonsResponse.getStatus(), () -> "Status no iguales");
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.CREATED), commonsResponse.getCode(), () -> "Codigos no iguales");
        }, () -> {
            assertEquals(MessagesConstants.CREATED_MSG, commonsResponse.getMessage(), () -> "Mensajes no iguales");
        }, () -> {
            assertNull(commonsResponse.getErrors(), () -> "Errores debe estar nulo");
        }, () -> {
            assertEquals(6L, commonsResponse.getData().getId(), () -> "ID no son iguales");
        }, () -> {
            assertEquals("Humor".toUpperCase(), commonsResponse.getData().getNombre(), () -> "Nombre no iguales");
        });
    }

    @DisplayName("Test: Guardar Catgegoria")
    @Test
    @Order(5)
    void testGuardarCategoriaNombreExistente() {
        Categoria objectToSave = new Categoria(null, "Humor", "Libro de Humor");

        ResponseEntity<Object> response = client.postForEntity(crearUri("/api/categorias"), objectToSave, Object.class);
        System.out.println(response);
        Object expected = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) expected;
        CommonsResponse<Categoria> commonsResponse = getResponse(objectResponse);

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> "El Status de la respuesta no es igual");
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> "El content-type no es igual");
        }, () -> {
            assertNotNull(objectResponse, () -> "El objectResponse no puede estar nulo");
        }, () -> {
            assertEquals(ResponseConstants.NOT_OK, commonsResponse.getStatus(), () -> "Status no iguales");
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.BAD_REQUEST), commonsResponse.getCode(), () -> "Codigos no iguales");
        }, () -> {
            assertEquals(MessagesConstants.CATEGORIA_EXISTE_MSG, commonsResponse.getMessage(), () -> "Mensajes no iguales");
        }, () -> {
            assertNull(commonsResponse.getErrors(), () -> "Errores debe estar nulo");
        }, () -> {
            assertNull(commonsResponse.getData(), () -> "Data debe estar nulo");
        });
    }

    private String crearUri(String uri) {
        return "http://localhost:" + puerto + uri;
    }

    private CommonsResponse<Categoria> getResponse(Map<String, Object> objectResponse) {
        String data;
        Categoria categoria = null;
        if (objectResponse.get("data") != null) {
            data = objectResponse.get("data").toString().replace(" ", "");
            Gson g = new Gson();
            categoria = g.fromJson(data, Categoria.class);
        }
        return new CommonsResponse<Categoria>(
                objectResponse.get("status").toString(),
                objectResponse.get("code").toString(),
                objectResponse.get("message").toString(),
                categoria);
    }
}
