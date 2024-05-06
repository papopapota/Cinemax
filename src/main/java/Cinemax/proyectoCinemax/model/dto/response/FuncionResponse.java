package Cinemax.proyectoCinemax.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FuncionResponse {
	private Boolean respuesta;
	private String mensaje;
}
