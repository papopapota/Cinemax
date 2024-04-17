package Cinemax.proyectoCinemax.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Peliculas")
public class genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgenero; // Cambiar el nombre del campo

    private String nom_genero;
}
