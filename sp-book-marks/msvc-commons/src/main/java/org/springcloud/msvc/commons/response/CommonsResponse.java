package org.springcloud.msvc.commons.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@Schema(name = "CommonsResponse", description = "Respuesta común de los controladores")
public class CommonsResponse<T> implements Serializable {

    private static final long serialVersionUID = 6419894644804410433L;

    @Schema(name = "status", required = true, example = "Success", description = "Status respuesta")
    private String status;

    @Schema(name = "code", required = true, example = "200 OK", description = "Codigo respuesta")
    private String code;

    @Schema(name = "message", required = true, example = "Objeto creado exitosamente", description = "Mensaje de la respuesta")
    private String message;

    @Schema(name = "data", example = "{id=1, nombre=prueba}", description = "Objeto o mapa de respuesta")
    private T data;

    @Schema(name = "errors", example = "Errores producidos en la petición", description = "Errores lanzados desde el valid")
    private Map<String, Object> errors;

    public CommonsResponse(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }

    public CommonsResponse(String status, String code, String message, T data) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonsResponse(String status, String code, String message, Map<String, Object> errors) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.errors = errors;
    }
}
