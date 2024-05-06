package Cinemax.proyectoCinemax.model.bd;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Funcion")
public class Funcion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFuncion;
	
	@ManyToOne
	@JoinColumn(name = "idPelicula")
	private Peliculas pelicula;
	
	@ManyToOne
	@JoinColumn(name = "idSala")
	private Sala sala;
	
	@Column(name = "fechaFuncion")
	private Date fechaFuncion;
	
	@Column(name = "horaInicio")
	private Time horaInicio;
	
	@Column(name = "horaFin")
	private Time horaFin;
}