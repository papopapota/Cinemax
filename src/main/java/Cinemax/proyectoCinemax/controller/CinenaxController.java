package Cinemax.proyectoCinemax.controller  ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Cinemax.proyectoCinemax.repository.IPeliculasRepository;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Cinemax.proyectoCinemax.model.bd.Genero;
import Cinemax.proyectoCinemax.model.bd.Peliculas;
import Cinemax.proyectoCinemax.repository.IPeliculasRepository;

 * 
 */

@Controller
@RequestMapping("/detalles")
public class CinenaxController {

	
	
	
    @GetMapping("/detalle1")
    public String cargarDetalleBatman() {
        return "detalle_batman";
    }

    @GetMapping("/detalle2")
    public String cargarDetalleWakanda() {
        return "detalle_wakanda";
    }

    @GetMapping("/detalle3")
    public String cargarDetalleChabuca() {
        return "detalle_chabuca";
    }

    @GetMapping("/detalle4")
    public String cargarDetallefyf() {
        return "detalle_fast_furious";
    }

    @GetMapping("/detalle5")
    public String cargarDetalleGarfield() {
        return "detalle_spiderman";
    }

    @GetMapping("/detalle6")
    public String cargarDetalleKun() {
        return "detalle_vaguito";
    }

    @GetMapping("/detalle7")
    public String cargarDetalleSpiderman() {
        return "detalle_vivo";
    }

    @GetMapping("/detalle8")
    public String cargarDetalleVaguito() {
        return "detalle_kung";
    }

    @GetMapping("/detalle9")
    public String cargarDetalleVivo() {
        return "detalle_garfield";
    }


    @Autowired
    private IPeliculasRepository peliculasRepository;




    
}
