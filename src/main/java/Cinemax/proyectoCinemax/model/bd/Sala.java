package Cinemax.proyectoCinemax.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sala ;
    private String descripcion_sala ;
    private double precio ;
}

