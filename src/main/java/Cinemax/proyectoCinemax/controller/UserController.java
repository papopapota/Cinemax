package Cinemax.proyectoCinemax.controller;

import Cinemax.proyectoCinemax.model.bd.Usuario;
import Cinemax.proyectoCinemax.repository.TipoUsuarioRepository;
import Cinemax.proyectoCinemax.repository.UsuarioRepository;
import Cinemax.proyectoCinemax.service.IUsuarioService;
import Cinemax.proyectoCinemax.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {
    private IUsuarioService iUsuario;

    @Autowired
    private UsuarioRepository repoUsuario;

    @Autowired
    private TipoUsuarioRepository repoTipoUsuario;

    @PostMapping
    public String ActualizarUsuario(@RequestBody Usuario usuario){
        String Result =  iUsuario.updateUser(usuario);
        return Result;
    }

    @GetMapping("/cargar")
    public String cargarListaUsuarios(Model model){
        model.addAttribute("lstUsuarios", repoUsuario.findAll());
        model.addAttribute("lstTipoUsuario", repoTipoUsuario.findAll());
        return "listaUsuarios";
    }

    @GetMapping("/eliminar/{idUsuario}")
    public String eliminar(@PathVariable Long idUsuario, Model model) {
        repoUsuario.deleteById(idUsuario);

        model.addAttribute("usuario", new Usuario());
        model.addAttribute("lstUsuarios", repoUsuario.findAll());
        model.addAttribute("lstTipoUsuario", repoTipoUsuario.findAll());

        return "listaUsuarios";
    }


}
