package Cinemax.proyectoCinemax.model.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TarjetaResponse {
    private Boolean respuesta;
    private String mensaje;
}
