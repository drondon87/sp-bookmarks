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
import java.util.Date;

@Table(name = "citas_libros")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "CitaLibro", description = "Citas de los libros")
public class CitaLibro implements Serializable {

    private static final long serialVersionUID = 8236718124470393975L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "no puede estar vacio")
    @Column(nullable = false)
    private String descripcion;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @Column(name = "pagina")
    private String pagina;

    @NotNull(message = "no puede estar vacio")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "libro_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Libro libro;
}
