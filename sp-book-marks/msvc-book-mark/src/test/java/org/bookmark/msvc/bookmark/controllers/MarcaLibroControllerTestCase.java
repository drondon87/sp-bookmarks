package org.bookmark.msvc.bookmark.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bookmark.msvc.bookmark.ErrorMessageTestCases;
import org.bookmark.msvc.bookmark.TestData;
import org.bookmark.msvc.bookmark.models.entities.*;
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
import static org.springcloud.msvc.commons.utils.TestUtils.transformDataObject;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MarcaLibroControllerTestCase {

    @Autowired
    private TestRestTemplate client;

    private ObjectMapper objectMapper;

    @LocalServerPort
    private int puerto;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    private String requestMapping = "/api/marcalibro/";

    private String crearUri(String uri) {
        return "http://localhost:" + puerto + requestMapping + uri;
    }

    @DisplayName("Test: Detalle Marca Libro")
    @Test
    @Order(1)
    void testDetalleMarcaLibro_returnMarcaLibro() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("1"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<MarcaLibro> commonsResponse = getResponse(objectResponse);

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
            assertNotNull(commonsResponse.getData().getCapitulo(), () -> ErrorMessageTestCases.CAPITULO_MUST_EXIST);
        });
    }

    @DisplayName("Test: Detalle Cita Libro no Existente")
    @Test
    @Order(2)
    void testDetalleMarcaLibro_returnMarcaNoExistente() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("15"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<MarcaLibro> commonsResponse = getResponse(objectResponse);

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

    @DisplayName("Test: Listar Marca Libro")
    @Test
    @Order(3)
    void testListarMarcaLibros_returnMarcasLibros() {
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

    @DisplayName("Test: Guardar Marca Libro")
    @Test
    @Order(4)
    void testGuardarMarcaLibro() {

        MarcaLibro objectToSave = getMarcaLibroToSave();

        ResponseEntity<Object> response = client.postForEntity(crearUri(""), objectToSave, Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<MarcaLibro> commonsResponse = getResponse(objectResponse);

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
            assertNotNull(commonsResponse.getData().getCapitulo(), () -> ErrorMessageTestCases.CAPITULO_MUST_EXIST);
        });
    }

    @DisplayName("Test: Listar Marcas Libros por Libro")
    @Test
    @Order(5)
    void testListarMarcasLibrosByLibro_returnMarcasLibros() {
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

    @DisplayName("Test: Listar Marcas Libros por Capitulo")
    @Test
    @Order(6)
    void testListarMarcasLibrosByCapitulo_returnMarcasLibros() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("capitulo/7"), Object.class);
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

    private CommonsResponse<MarcaLibro> getResponse(Map<String, Object> objectResponse) {
        MarcaLibro marcaLibro = null;
        if (objectResponse.get("data") != null) {
            marcaLibro = new MarcaLibro();
            String[] data = objectResponse.get("data").toString().split("=");

            marcaLibro.setId(Long.parseLong(transformDataObject(data[1])));
            marcaLibro.setDescripcion(transformDataObject(data[2]));
            marcaLibro.setPaginas(transformDataObject(data[3]));
            marcaLibro.setResumen(transformDataObject(data[4]));

            Capitulo capitulo = new Capitulo();
            capitulo.setId(Long.parseLong(transformDataObject(data[6])));
            capitulo.setNumero(transformDataObject(data[7]));
            capitulo.setNombre(transformDataObject(data[8]));
            capitulo.setDescripcion(transformDataObject(data[9]));

            Libro libro = new Libro();
            libro.setId(Long.parseLong(transformDataObject(data[11])));
            libro.setNombre(transformDataObject(data[12]));
            libro.setDescripcion(transformDataObject(data[13]));
            libro.setPortada(transformDataObject(data[14]));
            String sDate = transformDataObject(data[15]);
            Date createDate = null;
            try {
                createDate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            libro.setCreateAt(createDate);

            Categoria categoria = new Categoria();
            categoria.setId(Long.parseLong(transformDataObject(data[17])));
            categoria.setNombre(transformDataObject(data[18]));
            categoria.setDescripcion(transformDataObject(data[19]));
            libro.setCategoria(categoria);

            Autor autor = new Autor();
            autor.setId(Long.parseLong(transformDataObject(data[21])));
            autor.setNombre(transformDataObject(data[22]));
            autor.setApellido(transformDataObject(data[23]));
            libro.setAutor(autor);
            capitulo.setLibro(libro);
            marcaLibro.setCapitulo(capitulo);
        }
        return new CommonsResponse<MarcaLibro>(
                objectResponse.get("status").toString(),
                objectResponse.get("code").toString(),
                objectResponse.get("message").toString(),
                marcaLibro);
    }

    private MarcaLibro getMarcaLibroToSave() {
        MarcaLibro marcaLibro = new MarcaLibro();
        marcaLibro.setCapitulo(TestData.getCapitulo01());
        marcaLibro.setDescripcion("Nueva Marca de Jung");
        marcaLibro.setPaginas("67");
        marcaLibro.setDescripcion("Varias Marcas");
        return marcaLibro;
    }
}
