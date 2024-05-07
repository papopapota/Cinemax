package Cinemax.proyectoCinemax.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Entity
@Table(name = "pelicula")
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer idpelicula;

    private String titulo;
    private String descripcion;
    private String imagen;

    @ManyToOne // Cambiar a ManyToOne ya que muchas películas pueden pertenecer a un género
    @JoinColumn(name = "id_genero") // Nombre de la columna que actúa como clave externa en la tabla Peliculas
    private Genero genero; // Cambiar el tipo y el nombre del campo

    private Time duracion;
    private String idioma;
    private Boolean enestreno;
}
