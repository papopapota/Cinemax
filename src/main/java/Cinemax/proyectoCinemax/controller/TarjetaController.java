package Cinemax.proyectoCinemax.controller;

import Cinemax.proyectoCinemax.model.bd.Genero;
import Cinemax.proyectoCinemax.model.bd.Tarjeta;
import Cinemax.proyectoCinemax.model.bd.Usuario;
import Cinemax.proyectoCinemax.model.dto.request.TarjetaRequest;
import Cinemax.proyectoCinemax.model.dto.response.PeliculaResponse;
import Cinemax.proyectoCinemax.model.dto.response.TarjetaResponse;
import Cinemax.proyectoCinemax.service.ITarjetaService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/tarjeta")
public class TarjetaController {

    private ITarjetaService ITarjetaService;

    @GetMapping("")
    public String listarTarjetas(Model model, HttpSession session){
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if(usuario != null) {
            model.addAttribute("usuario", usuario);
            model.addAttribute("listarTarjetas", ITarjetaService.listarTarjetaPorUsuario(usuario.getIdUsuario()));
            return "guardartarjeta";
        } else {
            // Si no hay un usuario en la sesión, redirige a donde sea apropiado
            return "redirect:/login"; // Por ejemplo, a la página de inicio de sesión
        }
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Tarjeta> listTarjetas(){
        return ITarjetaService.listarTarjeta();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public TarjetaResponse registrarTarjeta(@RequestBody TarjetaRequest tarjetaRequest, HttpSession session){
        String mensaje = "Tarjeta registrada correctamente";
        boolean respuesta = true;
        try {
            // Obtener el usuario de la sesión
            Usuario usuario = (Usuario) session.getAttribute("usuario");

            Tarjeta tarjeta = new Tarjeta();
            tarjeta.setId_usuario(usuario);
            tarjeta.setIdtarjeta(tarjetaRequest.getIdtarjeta());
            tarjeta.setNumerotarjeta(tarjetaRequest.getNumerotarjeta());
            tarjeta.setFechaexpiracion(tarjetaRequest.getFechaexpiracion());
            tarjeta.setCvv(tarjetaRequest.getCvv());

            // Registrar la tarjeta
            ITarjetaService.registrarTarjeta(tarjeta);
        } catch (Exception ex){
            mensaje = "Tarjeta no registrada, error en la BD.";
            respuesta = false;
        }
        return TarjetaResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public TarjetaResponse eliminarTarjeta(@PathVariable("id") Integer id) {
        String mensaje = "Tarjeta eliminada correctamente";
        boolean respuesta = true;
        try {
            ITarjetaService.eliminarTarjeta(id);
        } catch (Exception ex) {
            mensaje = "Error al eliminar la tarjeta";
            respuesta = false;
        }
        return TarjetaResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
