package Cinemax.proyectoCinemax.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "Peliculas")
public class peliculas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpelicula;

    private String titulo;
    private String descripcion;
    private String imagen;

    @ManyToOne // Cambiar a ManyToOne ya que muchas películas pueden pertenecer a un género
    @JoinColumn(name = "idgenero") // Nombre de la columna que actúa como clave externa en la tabla Peliculas
    private genero genero; // Cambiar el tipo y el nombre del campo

    private Time duracion;
    private Date estreno;
    private String idioma;
    private String disponible;
}
