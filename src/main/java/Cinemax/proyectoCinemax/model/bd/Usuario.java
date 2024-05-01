package Cinemax.proyectoCinemax.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;
	private String nombreUsuario;
	private String apellidoUsuario;
    private String correoUsuario;
    private String claveUsuario;
	private int idTipoUsuario;

}