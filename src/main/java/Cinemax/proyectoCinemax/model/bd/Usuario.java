package Cinemax.proyectoCinemax.model.bd;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Integer idUsuario;
	@Column(name = "nombre_usuario")
	private String nombreUsuario;
	@Column(name = "apellido_usuario")
	private String apellidoUsuario;
	@Column(name = "correo_usuario")
    private String correoUsuario;
	@Column(name = "clave_usuario")
    private String claveUsuario;
	@Column(name = "dni")
	private String dni;

	@ManyToOne // Cambiar a ManyToOne ya que muchas películas pueden pertenecer a un género
	@JoinColumn(name = "id_tipo_usuario")
	private TipoUsuario tipoUsuario;

}