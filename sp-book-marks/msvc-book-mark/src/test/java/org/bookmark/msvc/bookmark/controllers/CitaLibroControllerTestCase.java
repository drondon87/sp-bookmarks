package org.bookmark.msvc.bookmark.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.TestData;
import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
import org.bookmark.msvc.bookmark.models.entities.CitaLibro;
import org.bookmark.msvc.bookmark.models.entities.Libro;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springcloud.msvc.commons.utils.TestUtils.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CitaLibroControllerTestCase {

    @Autowired
    private TestRestTemplate client;

    private ObjectMapper objectMapper;

    @LocalServerPort
    private int puerto;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    private String requestMapping = "/api/citalibro/";

    private String crearUri(String uri) {
        return "http://localhost:" + puerto + requestMapping + uri;
    }

    @DisplayName("Test: Detalle Cita Libro")
    @Test
    @Order(1)
    void testDetalleCitaLibro_returnCitaLibro() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("1"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<CitaLibro> commonsResponse = getResponse(objectResponse);

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
            assertNotNull(commonsResponse.getData().getLibro(), () -> ErrorMessageTestCases.LIBRO_MUST_EXIST);
        });
    }

    @DisplayName("Test: Detalle Cita Libro no Existente")
    @Test
    @Order(2)
    void testDetalleCitaLibro_returnLibroNoExistente() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("7"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<CitaLibro> commonsResponse = getResponse(objectResponse);

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

    @DisplayName("Test: Listar Cita Libro")
    @Test
    @Order(3)
    void testListarCitaLibros_returnCitasLibros() {
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

    @DisplayName("Test: Guardar Cita Libro")
    @Test
    @Order(4)
    void testGuardarCitaLibro() {

        CitaLibro objectToSave = getLibroToSave();

        ResponseEntity<Object> response = client.postForEntity(crearUri(""), objectToSave, Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<CitaLibro> commonsResponse = getResponse(objectResponse);

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
            assertEquals(2L, commonsResponse.getData().getId(), () -> ErrorMessageTestCases.GENERIC_DIFERENT_ID);
        }, () -> {
            assertNotNull(commonsResponse.getData().getLibro(), () -> ErrorMessageTestCases.LIBRO_MUST_EXIST);
        });
    }

    @DisplayName("Test: Listar Libros por Categoria")
    @Test
    @Order(5)
    void testListarCitaLibrosByLibro_returnCitasLibros() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("libro/6"), Object.class);
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

    private CommonsResponse<CitaLibro> getResponse(Map<String, Object> objectResponse) {
        CitaLibro citaLibro = null;
        if (objectResponse.get("data") != null) {
            citaLibro = new CitaLibro();
            String[] data = objectResponse.get("data").toString().split("=");

            citaLibro.setId(Long.parseLong(transformDataObject(data[1])));
            citaLibro.setDescripcion(transformDataObject(data[2]));
            String sDateCita = transformDataObject(data[3]);
            Date createDateCita = null;
            try {
                createDateCita = new SimpleDateFormat("yyyy-MM-dd").parse(sDateCita);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            citaLibro.setCreateAt(createDateCita);
            citaLibro.setPagina(transformDataObject(data[4]));

            Libro libro = new Libro();
            libro.setId(Long.parseLong(transformDataObject(data[6])));
            libro.setNombre(transformDataObject(data[7]));
            libro.setDescripcion(transformDataObject(data[8]));
            libro.setPortada(transformDataObject(data[9]));
            String sDate = transformDataObject(data[10]);
            Date createDate = null;
            try {
                createDate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            libro.setCreateAt(createDate);

            Categoria categoria = new Categoria();
            categoria.setId(Long.parseLong(transformDataObject(data[12])));
            categoria.setNombre(transformDataObject(data[13]));
            categoria.setDescripcion(transformDataObject(data[14]));
            libro.setCategoria(categoria);

            Autor autor = new Autor();
            autor.setId(Long.parseLong(transformDataObject(data[16])));
            autor.setNombre(transformDataObject(data[17]));
            autor.setApellido(transformDataObject(data[18]));
            libro.setAutor(autor);

            citaLibro.setLibro(libro);
        }
        return new CommonsResponse<CitaLibro>(
                objectResponse.get("status").toString(),
                objectResponse.get("code").toString(),
                objectResponse.get("message").toString(),
                citaLibro);
    }

    private CitaLibro getLibroToSave() {
        CitaLibro citaLibro = new CitaLibro();
        citaLibro.setCreateAt(new Date());
        citaLibro.setDescripcion("Nueva Cita de Jung");
        citaLibro.setPagina("67");
        citaLibro.setLibro(TestData.getLibro01());
        return citaLibro;
    }
}
