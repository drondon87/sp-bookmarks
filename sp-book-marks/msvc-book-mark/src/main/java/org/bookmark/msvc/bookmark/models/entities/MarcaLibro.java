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

@Table(name = "marcas_libros")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "MarcaLibro", description = "Marcas de los libros")
public class MarcaLibro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    @Column(nullable = false)
    private String descripcion;

    @NotEmpty(message = "no puede estar vacio")
    @Column(nullable = false)
    private String paginas;

    @Column(name = "resumen")
    private String resumen;

    @NotNull(message = "no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capitulo_id")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    private Capitulo capitulo;
}
