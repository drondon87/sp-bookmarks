package org.bookmark.msvc.bookmark.models.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Table(name = "categorias")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Categoria", description = "Categorías a la cual pertenecen los libros")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 9114707090564350846L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 4, max = 50, message = "el tamaño tiene que estar entre 4 y 50 caracteres")
    @Column(nullable = false, unique = true)
    @Schema(name = "nombre", required = true, minLength = 4, maxLength = 50, example = "Geografía", description = "Nombre de la categoría del libro")
    private String nombre;

    @Size(min = 5, max = 100, message = "el tamaño tiene que estar entre 5 y 100 caracteres")
    @NotEmpty(message = "no puede estar vacio")
    @Schema(name = "descripcion", required = true, example = "Libros de geografía", description = "Descripción de la categoría del libro")
    private String descripcion;
}
