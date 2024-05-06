package Cinemax.proyectoCinemax.model.dto.request;

import Cinemax.proyectoCinemax.model.bd.Usuario;
import lombok.Data;

@Data
public class TarjetaRequest {
    private Integer idtarjeta;
    private Usuario idUsuario;
    private String numerotarjeta;
    private String fechaexpiracion;
    private String cvv;
}
