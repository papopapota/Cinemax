package Cinemax.proyectoCinemax.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Boleto")
public class Boletos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idBoleto ;
    @ManyToOne // Cambiar a ManyToOne ya que muchas películas pueden pertenecer a un género
    @JoinColumn(name = "id_funcion")
    private  Funcion funcion ;
    @ManyToOne // Cambiar a ManyToOne ya que muchas películas pueden pertenecer a un género
    @JoinColumn(name = "id_usuario")
    private  Usuario usuario ;
    private  int cantidad ;
    private  double Total ;
}
