package org.bookmark.msvc.bookmark.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.junit.jupiter.api.*;
import org.springcloud.msvc.commons.constants.MessagesConstants;
import org.springcloud.msvc.commons.constants.ResponseConstants;
import org.springcloud.msvc.commons.response.CommonsResponse;
import org.springcloud.msvc.commons.utils.TestUtils;
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
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS_CODE);
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CONTENT_TYPE);
        }, () -> {
            assertNotNull(objectResponse, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
        }, () -> {
            assertEquals(ResponseConstants.SUCCESS, commonsResponse.getStatus(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS);
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.OK), commonsResponse.getCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CODES);
        }, () -> {
            assertEquals(ResponseConstants.OK, commonsResponse.getMessage(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_MESSAGES);
        }, () -> {
            assertNull(commonsResponse.getErrors(), () -> ErrorMessageTestCases.GENERIC_ERRORS_MUST_BE_NULL);
        }, () -> {
            assertEquals(1L, commonsResponse.getData().getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            assertEquals("Historia".toUpperCase(), commonsResponse.getData().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        });
    }

    @DisplayName("Test: Detalle Categoria no Existente")
    @Test
    @Order(2)
    void testDetalleCategoria_returnCategoriaNoExistente() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("/api/categorias/10"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Categoria> commonsResponse = getResponse(objectResponse);

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS_CODE);
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CONTENT_TYPE);
        }, () -> {
            assertNotNull(objectResponse, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
        }, () -> {
            assertEquals(ResponseConstants.NOT_OK, commonsResponse.getStatus(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS);
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.NOT_FOUND), commonsResponse.getCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CODES);
        }, () -> {
            assertEquals(MessagesConstants.NOT_FOUND_MSG, commonsResponse.getMessage(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_MESSAGES);
        }, () -> {
            assertNull(commonsResponse.getErrors(), () -> ErrorMessageTestCases.GENERIC_ERRORS_MUST_BE_NULL);
        }, () -> {
            assertNull(commonsResponse.getData(), () -> ErrorMessageTestCases.GENERIC_DATA_MUST_BE_NULL);
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
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS_CODE);
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CONTENT_TYPE);
        }, () -> {
            assertNotNull(objectResponse, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
        }, () -> {
            assertEquals(ResponseConstants.SUCCESS, objectResponse.get("status").toString(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS);
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.OK), objectResponse.get("code").toString(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CODES);
        }, () -> {
            assertEquals(ResponseConstants.OK, objectResponse.get("message").toString(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_MESSAGES);
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
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS_CODE);
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CONTENT_TYPE);
        }, () -> {
            assertNotNull(objectResponse, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
        }, () -> {
            assertEquals(ResponseConstants.SUCCESS, commonsResponse.getStatus(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS);
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.CREATED), commonsResponse.getCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CODES);
        }, () -> {
            assertEquals(MessagesConstants.CREATED_MSG, commonsResponse.getMessage(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_MESSAGES);
        }, () -> {
            assertNull(commonsResponse.getErrors(), () -> ErrorMessageTestCases.GENERIC_ERRORS_MUST_BE_NULL);
        }, () -> {
            assertEquals(7L, commonsResponse.getData().getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            assertEquals("Humor".toUpperCase(), commonsResponse.getData().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        });
    }

    @DisplayName("Test: Guardar Catgegoria")
    @Test
    @Order(5)
    void testGuardarCategoriaNombreExistente() {
        Categoria objectToSave = new Categoria(null, "Humor", "Libro de Humor");

        ResponseEntity<Object> response = client.postForEntity(crearUri("/api/categorias"), objectToSave, Object.class);
        Object expected = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) expected;
        CommonsResponse<Categoria> commonsResponse = getResponse(objectResponse);

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS_CODE);
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CONTENT_TYPE);
        }, () -> {
            assertNotNull(objectResponse, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
        }, () -> {
            assertEquals(ResponseConstants.NOT_OK, commonsResponse.getStatus(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS);
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.BAD_REQUEST), commonsResponse.getCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CODES);
        }, () -> {
            assertEquals(MessagesConstants.CATEGORIA_EXISTE_MSG, commonsResponse.getMessage(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_MESSAGES);
        }, () -> {
            assertNull(commonsResponse.getErrors(), () -> ErrorMessageTestCases.GENERIC_ERRORS_MUST_BE_NULL);
        }, () -> {
            assertNull(commonsResponse.getData(), () -> ErrorMessageTestCases.GENERIC_DATA_MUST_BE_NULL);
        });
    }

    @DisplayName("Test: Detalle Categoria Por Nombre")
    @Test
    @Order(6)
    void testDetalleCategoriaByNombre_returnCategoria() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("/api/categorias/nombre/HISTORIA"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Categoria> commonsResponse = getResponse(objectResponse);

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS_CODE);
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CONTENT_TYPE);
        }, () -> {
            assertNotNull(objectResponse, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
        }, () -> {
            assertEquals(ResponseConstants.SUCCESS, commonsResponse.getStatus(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS);
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.OK), commonsResponse.getCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CODES);
        }, () -> {
            assertEquals(ResponseConstants.OK, commonsResponse.getMessage(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_MESSAGES);
        }, () -> {
            assertNull(commonsResponse.getErrors(), () -> ErrorMessageTestCases.GENERIC_ERRORS_MUST_BE_NULL);
        }, () -> {
            assertEquals(1L, commonsResponse.getData().getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            assertEquals("Historia".toUpperCase(), commonsResponse.getData().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        });
    }

    @DisplayName("Test: Detalle Categoria por Nombre no Existente")
    @Test
    @Order(7)
    void testDetalleCategoriaPorNombre_returnCategoriaNoExistente() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("/api/categorias/nombre/historia"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Categoria> commonsResponse = getResponse(objectResponse);

        assertAll(() -> {
            assertEquals(HttpStatus.OK, response.getStatusCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS_CODE);
        }, () -> {
            assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CONTENT_TYPE);
        }, () -> {
            assertNotNull(objectResponse, () -> ErrorMessageTestCases.GENERIC_NOT_NULL_OBJECT_RESPONSE);
        }, () -> {
            assertEquals(ResponseConstants.NOT_OK, commonsResponse.getStatus(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_STATUS);
        }, () -> {
            assertEquals(String.valueOf(HttpStatus.NOT_FOUND), commonsResponse.getCode(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_CODES);
        }, () -> {
            assertEquals(MessagesConstants.NOT_FOUND_MSG, commonsResponse.getMessage(), () -> ErrorMessageTestCases.GENERIC_NOT_EQUAL_MESSAGES);
        }, () -> {
            assertNull(commonsResponse.getErrors(), () -> ErrorMessageTestCases.GENERIC_ERRORS_MUST_BE_NULL);
        }, () -> {
            assertNull(commonsResponse.getData(), () -> ErrorMessageTestCases.GENERIC_DATA_MUST_BE_NULL);
        });
    }

    private String crearUri(String uri) {
        return "http://localhost:" + puerto + uri;
    }

    private CommonsResponse<Categoria> getResponse(Map<String, Object> objectResponse) {
        Categoria categoria = null;
        if (objectResponse.get("data") != null) {
            categoria = new Categoria();
            String[] data = objectResponse.get("data").toString().split("=");
            categoria.setId(Long.parseLong(TestUtils.transformDataObjectSingleObject(data[1])));
            categoria.setNombre(TestUtils.transformDataObjectSingleObject(data[2]));
            categoria.setDescripcion(TestUtils.transformDataObjectSingleObject(data[3]));
        }
        return new CommonsResponse<Categoria>(
                objectResponse.get("status").toString(),
                objectResponse.get("code").toString(),
                objectResponse.get("message").toString(),
                categoria);
    }
}
