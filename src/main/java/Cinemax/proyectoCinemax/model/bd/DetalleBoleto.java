package Cinemax.proyectoCinemax.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DetalleBoleto")
public class DetalleBoleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detalle")
    private int idDetalle;
    @ManyToOne
    @JoinColumn(name = "id_boleto")
    private Boletos boleto  ;
    @ManyToOne
    @JoinColumn(name = "id_asiento")
    private Asiento asiento ;
}
