package org.bookmark.msvc.bookmark.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
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
public class AutorControllerTestCases {

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
            assertEquals("ARTURO".toUpperCase(), commonsResponse.getData().getNombre(), () -> "Nombre no iguales");
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

    @DisplayName("Test: Listar Autores")
    @Test
    @Order(3)
    void testListarAutores_returnAutores() {
        ResponseEntity<Object> response = client.getForEntity(crearUri(""), Object.class);
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
            assertEquals(8L, commonsResponse.getData().getId(), () -> "ID no son iguales");
        }, () -> {
            assertEquals("Thays".toUpperCase(), commonsResponse.getData().getNombre(), () -> "Nombre no iguales");
        }, () -> {
            assertEquals("Peñalver".toUpperCase(), commonsResponse.getData().getApellido(), () -> "Apellido no iguales");
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
