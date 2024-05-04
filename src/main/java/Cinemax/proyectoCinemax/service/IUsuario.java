package Cinemax.proyectoCinemax.service;

import Cinemax.proyectoCinemax.model.bd.Usuario;

public interface IUsuario {
    Usuario authenticate(String username, String password );
    String updateUser(Usuario usuario);
    public Usuario EncontrarUserById(long id);
    public void guardar(Usuario usuario);

}
