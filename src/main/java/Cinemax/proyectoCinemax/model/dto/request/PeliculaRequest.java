package Cinemax.proyectoCinemax.model.dto.request;

import Cinemax.proyectoCinemax.model.bd.Genero;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class PeliculaRequest {
    private Integer idPelicula;
    private String titulo;
    private String descripcion;
    private String imagen;
    private Integer genero;
    private Time duracion;
    private String idioma;
    private Boolean enestreno;
}
