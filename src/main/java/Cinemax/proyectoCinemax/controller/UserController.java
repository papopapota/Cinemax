package Cinemax.proyectoCinemax.controller;

import Cinemax.proyectoCinemax.model.bd.Usuario;
import Cinemax.proyectoCinemax.service.IUsuario;
import Cinemax.proyectoCinemax.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class UserController {
    private IUsuario iUsuario;

    @PostMapping
    public String ActualizarUsuario(@RequestBody Usuario usuario){
        String Result =  iUsuario.updateUser(usuario);
        return Result;
    }


}
