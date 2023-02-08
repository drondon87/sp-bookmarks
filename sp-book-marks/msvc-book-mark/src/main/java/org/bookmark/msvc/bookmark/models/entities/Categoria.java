package org.bookmark.msvc.bookmark.models.entities;

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
public class Categoria implements Serializable {

    private static final long serialVersionUID = 9114707090564350846L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 4, max = 50, message = "el tamaño tiene que estar entre 4 y 50 caracteres")
    @Column(nullable = false, unique = true)
    private String nombre;

    private String descripcion;
}
