package Cinemax.proyectoCinemax.controller;

import Cinemax.proyectoCinemax.model.bd.Asiento;
import Cinemax.proyectoCinemax.model.bd.Funcion;
import Cinemax.proyectoCinemax.model.bd.Sala;
import Cinemax.proyectoCinemax.repository.SalaRepository;
import Cinemax.proyectoCinemax.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class TikectController {
    private final TikectService tikectService;
    private  final  PeliculaService peliculaService;
    private final AsientoService asientoService;
    private final FuncionService funcionService;
    private final SalaService salaService;


    /*    @Override
    List<Boletos> findByIdPelicula(int id ){

    }*/

    public TikectController(TikectService tikectService, PeliculaService peliculaService, AsientoService asientoService, FuncionService funcionService, SalaService salaService) {
        this.tikectService = tikectService;
        this.peliculaService = peliculaService;
        this.asientoService = asientoService;
        this.funcionService = funcionService;
        this.salaService = salaService;
    }

    List<String> ListaIds (){
        List<String> ListIdAsientos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            String firstLetter = "";
            switch (i){
                case 0:
                    firstLetter = "A";
                    break;
                case 1:
                    firstLetter = "B";
                    break;
                case 2:
                    firstLetter = "C";
                    break;
            }
            for (int j = 1; j <= 10; j++) {
                String numeroText = j + "" ;
                String idAsiento = "";
                if (numeroText.length() == 1 ){
                     idAsiento = firstLetter + "0" + j ;
                }else {
                    idAsiento = firstLetter  + j ;
                }

                ListIdAsientos.add(idAsiento);
            }
        }
        return ListIdAsientos;
    }

    @GetMapping("/compraTikects")
    public String compraTikects(Model model) {
        //model.addAttribute("" );

        List<Asiento> listaAsiento = asientoService.listaAsientoByFuncion(1);


        if (listaAsiento.size() == 0){
            List<String> ListIdAsientos = ListaIds();

            //Peliculas pelicula = peliculaService.FindById(1);
            Funcion funcion = funcionService.findById(1);
            Asiento asiento = new Asiento();
            for (int i = 0; i < ListIdAsientos.size(); i++) {
                asiento = new Asiento();
                asiento.setFuncion(funcion);
                asiento.setCodigo(ListIdAsientos.get(i));
                asiento.setEstadoAsiento(false);
                try {
                    asientoService.save(asiento);
                }catch (Exception e){
                    model.addAttribute("failMessage","Error de Regitro: " + e.getMessage());

                }

            }
            listaAsiento = asientoService.listaAsientoByFuncion(1);
        }

        List<Funcion> listaFuncion = funcionService.findByPeliculaIdPelicula(1);

        Sala sala = salaService.findById(1);

        model.addAttribute("listaFuncion",listaFuncion);
        model.addAttribute("listaAsiento",listaAsiento);
        model.addAttribute("precioSala",sala.getPrecio());
        return "Tikect/compraTikects";
    }
}
