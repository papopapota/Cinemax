package Cinemax.proyectoCinemax.controller;

import Cinemax.proyectoCinemax.model.bd.*;
import Cinemax.proyectoCinemax.repository.DetalleBoletoRepository;
import Cinemax.proyectoCinemax.service.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    private final UsuarioService UsuarioService;
    private  final DetalleBoletoRepository DetalleBoletorepo;
    private Cinemax.proyectoCinemax.model.bd.Asiento Asiento;


    /*    @Override
    List<Boletos> findByIdPelicula(int id ){

    }*/

    public TikectController(TikectService tikectService, PeliculaService peliculaService, AsientoService asientoService, FuncionService funcionService, SalaService salaService, Cinemax.proyectoCinemax.service.UsuarioService usuarioService, DetalleBoletoRepository detalleBoletorepo) {
        this.tikectService = tikectService;
        this.peliculaService = peliculaService;
        this.asientoService = asientoService;
        this.funcionService = funcionService;
        this.salaService = salaService;
        UsuarioService = usuarioService;

        DetalleBoletorepo = detalleBoletorepo;
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

    @PostMapping("/comprarAction")
    public String comprarAction(@RequestParam Integer cantidadTextField , @RequestParam String totalTextField , @RequestParam("idFuncion") int idFuncion , @RequestParam String butacasCodigo , RedirectAttributes redirectAttributes) {

        Boletos boleto = new Boletos();
        Usuario usuario = UsuarioService.EncontrarUserById(1);
        Funcion funcion = funcionService.findById(idFuncion);

        //boleto.setIdBoleto(null);
        boleto.setUsuario(usuario);
        boleto.setFuncion(funcion);
        boleto.setCantidad(  cantidadTextField);
        boleto.setTotal(Double.parseDouble(totalTextField));
        try {
            tikectService.save(boleto);
        }catch (Exception e){
            String mensaje = "Error guardando Boleto " + e.getMessage();
            redirectAttributes.addFlashAttribute("failMessage",mensaje);
            return "redirect:compraTikects";
        }
        if (butacasCodigo == ""){

            String mensaje = "Selecione una butaca";
            redirectAttributes.addFlashAttribute("failMessage",mensaje);
            return "redirect:compraTikects";
        }
        String[] boletos = butacasCodigo.split(",");




        List<Asiento> asientos = asientoService.listaAsientoByFuncion(idFuncion);


        for (int i = 0; i < boletos.length; i++) {
            String codigoBoleto = boletos[i];
            Asiento asiento = logicaAsiento(asientos , codigoBoleto);

            Boletos savedBoleto = tikectService.findById(boleto.getIdBoleto());
            DetalleBoleto detalleBoleto = new DetalleBoleto();
            detalleBoleto.setBoleto(savedBoleto);
            detalleBoleto.setAsiento(asiento);

            if (asiento == null){
                String mensaje = "Asiento Nulll ";
                redirectAttributes.addFlashAttribute("failMessage",mensaje);
                return "redirect:compraTikects";
            }
            try {
                DetalleBoletorepo.save(detalleBoleto);
            }catch (Exception e){
                String mensaje = "error detalle boleto : " + e.getMessage();
                redirectAttributes.addFlashAttribute("failMessage",mensaje);
                return "redirect:compraTikects";
            }
        }



        String mensaje = "Se registro correctamente la compra" ;
        redirectAttributes.addFlashAttribute("successMessage",mensaje);
        return "redirect:Index";
    }

    public Asiento logicaAsiento(List<Asiento> asientos , String codigoBoleto){

        //DetalleBoleto detalleBoleto = new DetalleBoleto();
        for (int j = 0; j < asientos.size(); j++) {
            Asiento asiento = asientos.get(j);
            String codigo = asiento.getCodigo();
            if ( codigoBoleto.equals( codigo)){

                return asiento ;

            }

        }

        return null;
    }
}


