package org.springcloud.msvc.commons.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class CommonsResponse<T> implements Serializable {

    private static final long serialVersionUID = 6419894644804410433L;

    private String status;

    private String code;

    private String message;

    private T data;

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
