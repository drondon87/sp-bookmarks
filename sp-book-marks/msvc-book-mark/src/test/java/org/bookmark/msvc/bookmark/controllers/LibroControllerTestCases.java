package org.bookmark.msvc.bookmark.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.bookmark.msvc.bookmark.TestData;
import org.bookmark.msvc.bookmark.models.entities.Autor;
import org.bookmark.msvc.bookmark.models.entities.Categoria;
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
import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LibroControllerTestCases {

    @Autowired
    private TestRestTemplate client;

    private ObjectMapper objectMapper;

    @LocalServerPort
    private int puerto;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    private String requestMapping = "/api/libros/";

    private String crearUri(String uri) {
        return "http://localhost:" + puerto + requestMapping + uri;
    }

    @DisplayName("Test: Detalle Libro")
    @Test
    @Order(1)
    void testDetalleLibro_returnLibro() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("1"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Libro> commonsResponse = getResponse(objectResponse);

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
            assertNotNull(commonsResponse.getData().getCategoria(), () -> "Las categorias no pueden estar nulas");
        }, () -> {
            assertNotNull(commonsResponse.getData().getAutor(), () -> "Los autores no pueden estar nulas");
        });
    }

    @DisplayName("Test: Detalle Libro no Existente")
    @Test
    @Order(2)
    void testDetalleLibro_returnLibroNoExistente() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("7"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Libro> commonsResponse = getResponse(objectResponse);

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

    @DisplayName("Test: Listar Libro")
    @Test
    @Order(3)
    void testListarLibros_returnLibros() {
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

    @DisplayName("Test: Guardar Libro")
    @Test
    @Order(4)
    void testGuardarLibro() {

        Libro objectToSave = getLibroToSave();

        ResponseEntity<Object> response = client.postForEntity(crearUri(""), objectToSave, Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Libro> commonsResponse = getResponse(objectResponse);

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
            assertEquals("Las mujeres del narco".toUpperCase(), commonsResponse.getData().getNombre(), () -> "Nombre no iguales");
        }, () -> {
            assertNotNull(commonsResponse.getData().getCategoria(), () -> "Las categorias no pueden estar nulas");
        }, () -> {
            assertNotNull(commonsResponse.getData().getAutor(), () -> "Los autores no pueden estar nulas");
        });
    }

    @DisplayName("Test: Guardar Libro con Nombre Existente")
    @Test
    @Order(5)
    void testGuardarLibroNombreExistente() {
        Libro objectToSave = getLibroToSave();

        ResponseEntity<Object> response = client.postForEntity(crearUri(""), objectToSave, Object.class);
        Object expected = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) expected;
        CommonsResponse<Libro> commonsResponse = getResponse(objectResponse);

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

    @DisplayName("Test: Detalle Libro Por Nombre")
    @Test
    @Order(6)
    void testDetalleLibroByNombre_returnLibro() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("nombre/CIRCO MAXIMO"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Libro> commonsResponse = getResponse(objectResponse);

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
            assertEquals(2L, commonsResponse.getData().getId(), () -> "ID no son iguales");
        }, () -> {
            assertEquals("Circo Maximo".toUpperCase(), commonsResponse.getData().getNombre(), () -> "Nombre no iguales");
        });
    }

    @DisplayName("Test: Detalle Libro por Nombre no Existente")
    @Test
    @Order(7)
    void testDetalleLibroPorNombre_returnLibroNoExistente() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("nombre/historia"), Object.class);
        Object body = response.getBody();
        Map<String, Object> objectResponse = (Map<String, Object>) body;
        CommonsResponse<Libro> commonsResponse = getResponse(objectResponse);

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

    @DisplayName("Test: Listar Libros por Categoria")
    @Test
    @Order(8)
    void testListarLibrosByCategoria_returnLibros() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("categoria/2"), Object.class);
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

    @DisplayName("Test: Listar Libros por Autor")
    @Test
    @Order(9)
    void testListarLibrosByAutor_returnLibros() {
        ResponseEntity<Object> response = client.getForEntity(crearUri("autor/2"), Object.class);
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

    private String transformDataObject(String data) {
        int commaLocation = 0;

        if (data.indexOf("}") < 0) {
            commaLocation = data.indexOf(",");
            return data.substring(0, commaLocation);
        }

        if (data.indexOf("},") < 0) {
            commaLocation = data.indexOf("}}");
            return data.substring(0, commaLocation);
        }

        commaLocation = data.indexOf("},");
        return data.substring(0, commaLocation);
    }

    private CommonsResponse<Libro> getResponse(Map<String, Object> objectResponse) {
        Libro libro = null;
        if (objectResponse.get("data") != null) {
            libro = new Libro();
            String[] data = objectResponse.get("data").toString().split("=");
            libro.setId(Long.parseLong(transformDataObject(data[1])));
            libro.setNombre(transformDataObject(data[2]));
            libro.setDescripcion(transformDataObject(data[3]));
            libro.setPortada(transformDataObject(data[4]));
            String sDate = transformDataObject(data[5]);
            Date createDate = null;
            try {
                createDate = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            libro.setCreateAt(createDate);
            Categoria categoria = new Categoria();
            categoria.setId(Long.parseLong(transformDataObject(data[7])));
            categoria.setNombre(transformDataObject(data[8]));
            categoria.setDescripcion(transformDataObject(data[9]));
            libro.setCategoria(categoria);

            Autor autor = new Autor();
            autor.setId(Long.parseLong(transformDataObject(data[11])));
            autor.setNombre(transformDataObject(data[12]));
            autor.setApellido(transformDataObject(data[13]));
            libro.setAutor(autor);
        }
        return new CommonsResponse<Libro>(
                objectResponse.get("status").toString(),
                objectResponse.get("code").toString(),
                objectResponse.get("message").toString(),
                libro);
    }

    private Libro getLibroToSave() {
        Libro libro = new Libro();
        libro.setId(null);
        libro.setNombre("Las mujeres del narco");
        libro.setDescripcion("Historia de las mujeres de los narcos");
        Autor autor = TestData.getAutor02();
        libro.setAutor(autor);
        Categoria categoria = TestData.getCategoria03();
        libro.setCategoria(categoria);
        return libro;
    }
}
