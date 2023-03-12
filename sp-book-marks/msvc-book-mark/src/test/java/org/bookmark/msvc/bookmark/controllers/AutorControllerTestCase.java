package org.bookmark.msvc.bookmark.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.models.entities.Autor;
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

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AutorControllerTestCase {

    @Autowired
    private TestRestTemplate client;

    private ObjectMapper objectMapper;

    @LocalServerPort
    private int puerto;

    private String requestMapping = "/api/autores/";

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @DisplayName("Test: Detalle Autores")
    @Test
    @Order(1)
    void testDetalleAutor_returnAutor() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("/1"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Autor> commonsResponse = getResponse(objectResponse);

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
            assertEquals(ResponseConstants.OK, commonsResponse.getMessage(), () -> ErrorMessageTestCases.GENERIC_ERRORS_MUST_BE_NULL);
        }, () -> {
            assertNull(commonsResponse.getErrors(), () -> ErrorMessageTestCases.GENERIC_ERRORS_MUST_BE_NULL);
        }, () -> {
            assertEquals(1L, commonsResponse.getData().getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            assertEquals("ARTURO".toUpperCase(), commonsResponse.getData().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        });
    }

    @DisplayName("Test: Detalle Autor no Existente")
    @Test
    @Order(2)
    void testDetalleAutor_returnAutorNoExistente() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("/15"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Autor> commonsResponse = getResponse(objectResponse);

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

    @DisplayName("Test: Listar Autores")
    @Test
    @Order(3)
    void testListarAutores_returnAutores() {
        ResponseEntity<Object> response = client.getForEntity(crearUri(""), Object.class);
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

    @DisplayName("Test: Guardar Autor")
    @Test
    @Order(4)
    void testGuardarAutor() {
        Autor objectToSave = new Autor(null, "Thays".toUpperCase(), "Peñalver".toUpperCase());

        ResponseEntity<Object> response = client.postForEntity(crearUri(""), objectToSave, Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Autor> commonsResponse = getResponse(objectResponse);

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
            assertEquals(8L, commonsResponse.getData().getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            assertEquals("Thays".toUpperCase(), commonsResponse.getData().getNombre(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_NAMES);
        }, () -> {
            assertEquals("Peñalver".toUpperCase(), commonsResponse.getData().getApellido(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_LAST_NAMES);
        });
    }

    private String crearUri(String uri) {
        return "http://localhost:" + puerto + requestMapping + uri;
    }

    private CommonsResponse<Autor> getResponse(Map<String, Object> objectResponse) {
        String data;
        Autor object = null;
        if (objectResponse.get("data") != null) {
            data = objectResponse.get("data").toString().replace(" ", "");
            Gson g = new Gson();
            object = g.fromJson(data, Autor.class);
        }
        return new CommonsResponse<Autor>(
                objectResponse.get("status").toString(),
                objectResponse.get("code").toString(),
                objectResponse.get("message").toString(),
                object);
    }
}
