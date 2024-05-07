package Cinemax.proyectoCinemax.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tarjeta")
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtarjeta")
    private Integer idtarjeta;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario id_usuario;

    @Column(name = "numerotarjeta")
    private String numerotarjeta;

    @Column(name = "fechaexpiracion")
    private String fechaexpiracion;

    @Column(name = "cvv")
    private String cvv;

}