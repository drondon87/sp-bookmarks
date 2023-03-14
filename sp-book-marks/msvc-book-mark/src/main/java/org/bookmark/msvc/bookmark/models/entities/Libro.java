package org.bookmark.msvc.bookmark.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Table(name = "libros")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Libro", description = "Libros guardados en la BD")
public class Libro implements Serializable {

    private static final long serialVersionUID = 2689775364335099243L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    @Size(min = 4, max = 200, message = "el tamaño tiene que estar entre 4 y 200 caracteres")
    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(name = "portada")
    private String portada;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @NotNull(message = "no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Categoria categoria;

    @NotNull(message = "no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Autor autor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id) && Objects.equals(nombre, libro.nombre) && Objects.equals(descripcion, libro.descripcion);
    }

}
