package org.bookmark.msvc.bookmark.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Table(name = "capitulos")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Capitulo", description = "Capitulo asociado a un Libro")
public class Capitulo implements Serializable {

    private static final long serialVersionUID = 5948042174630936034L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    @Column(nullable = false)
    private String numero;

    @NotEmpty(message = "no puede estar vacio")
    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    @NotNull(message = "no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Libro libro;
}
