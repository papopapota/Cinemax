package Cinemax.proyectoCinemax.controller;


import Cinemax.proyectoCinemax.model.bd.Genero;
import Cinemax.proyectoCinemax.model.bd.Pelicula;
import Cinemax.proyectoCinemax.model.dto.request.PeliculaRequest;
import Cinemax.proyectoCinemax.model.dto.response.PeliculaResponse;
import Cinemax.proyectoCinemax.service.IPeliculaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/pelicula")
public class PeliculaController {

    private IPeliculaService IPeliculaService;

    @GetMapping("")
    public String listarPeliculas(Model model){
        model.addAttribute("listarpeliculas" ,
                IPeliculaService.listarPeliculas());
        return "backoffice/pelicula/formpelicula";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Pelicula> listPeliculas(){
        return IPeliculaService.listarPeliculas();
    }

    @PostMapping("/registrar")
    @ResponseBody
    public PeliculaResponse registrarPelicula(@RequestBody PeliculaRequest peliculaRequest , Model model){
        String mensaje = "Producto registrado correctamente";
        boolean respuesta = true;
        try {
            Pelicula peliculas = new Pelicula();
            if(peliculaRequest.getIdpelicula() > 0){
                peliculas.setIdpelicula(peliculaRequest.getIdpelicula());
            }
            peliculas.setTitulo(peliculaRequest.getTitulo());
            peliculas.setDescripcion(peliculaRequest.getDescripcion());
            peliculas.setImagen(peliculaRequest.getImagen());
            Genero genero = new Genero();
            genero.setIdGenero(peliculaRequest.getGenero());
            peliculas.setGenero(genero);
            peliculas.setDuracion(peliculaRequest.getDuracion());
            peliculas.setIdioma(peliculaRequest.getIdioma());
            peliculas.setEnestreno(peliculaRequest.getEnestreno());
            IPeliculaService.regitrarPelicula(peliculas);
        }catch (Exception ex){
            mensaje = "Producto no registrado, error en la BD.";
            respuesta = false;
            String mensajeError ="error registro" + ex.getMessage() ;
            model.addAttribute("failMessage",mensajeError);
            //return "";
        }
        return PeliculaResponse.builder().mensaje(mensaje).respuesta(respuesta).build();

    }
    @DeleteMapping("/eliminar/{id}")
    @ResponseBody
    public PeliculaResponse eliminarPelicula(@PathVariable("id") Integer id) {
        String mensaje = "Pelicula eliminada correctamente";
        boolean respuesta = true;
        try {
            IPeliculaService.eliminarPelicula(id);
        } catch (Exception ex) {
            mensaje = "Error al eliminar la película";
            respuesta = false;
        }
        return PeliculaResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

}
