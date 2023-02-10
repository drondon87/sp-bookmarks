package org.bookmark.msvc.bookmark.models.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Table(name = "autores")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Autor", description = "Autor del libro guardado")
public class Autor implements Serializable {

    private static final long serialVersionUID = 2688775364335099243L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 3, max = 50, message = "el tamaño tiene que estar entre 4 y 50 caracteres")
    @Column(nullable = false)
    @Schema(name = "nombre", required = true, minLength = 3, maxLength = 50, example = "Stanly", description = "Nombre del autor del libro")
    private String nombre;

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 3, max = 50, message = "el tamaño tiene que estar entre 4 y 50 caracteres")
    @Column(nullable = false)
    @Schema(name = "apellido", required = true, minLength = 3, maxLength = 50, example = "Payne", description = "Apellido del autor del libro")
    private String apellido;
}
