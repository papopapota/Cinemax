package Cinemax.proyectoCinemax.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

@Data
@Entity
@Table(name = "Funcion")
public class Funcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_funcion")
    private int idFuncion;
    @ManyToOne // Cambiar a ManyToOne ya que muchas películas pueden pertenecer a un género
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;
    @ManyToOne // Cambiar a ManyToOne ya que muchas películas pueden pertenecer a un género
    @JoinColumn(name = "id_sala")
    private Sala sala;
    private Date fechaFuncion ;
    private Time horaInicio ;
    private Time horaFin ;

    public String getFechaFuncionFormateada() {
        // Define el formato que deseas para la fecha
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy ");

        // Formatea la fecha en el formato deseado
        return sdf.format(fechaFuncion);
    }
}
