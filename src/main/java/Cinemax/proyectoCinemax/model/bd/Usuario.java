package Cinemax.proyectoCinemax.model.bd;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Long idUsuario;
	@Column(name = "nombreUsuario")
	private String nombreUsuario;
	@Column(name = "apellidoUsuario")
	private String apellidoUsuario;
	@Column(name = "correoUsuario")
    private String correoUsuario;
	@Column(name = "claveUsuario")
    private String claveUsuario;
	@Column(name = "dni")
	private String dni;

	@ManyToOne // Cambiar a ManyToOne ya que muchas películas pueden pertenecer a un género
	@JoinColumn(name = "id_tipo_usuario")
	private TipoUsuario tipoUsuario;

}