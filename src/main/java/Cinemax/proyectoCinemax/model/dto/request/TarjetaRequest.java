package Cinemax.proyectoCinemax.model.dto.request;

import Cinemax.proyectoCinemax.model.bd.Usuario;
import lombok.Data;

@Data
public class TarjetaRequest {
    private Integer idtarjeta;
    private Integer id_usuario;
    private String numerotarjeta;
    private String fechaexpiracion;
    private String cvv;
}
