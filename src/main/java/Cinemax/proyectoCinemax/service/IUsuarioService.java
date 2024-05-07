package Cinemax.proyectoCinemax.service;

import java.util.List;

import Cinemax.proyectoCinemax.model.bd.Usuario;

public interface IUsuarioService {
    Usuario authenticate(String username, String password );
    String updateUser(Usuario usuario);
    public Usuario EncontrarUserById(Integer id);
    public void guardar(Usuario usuario);
    
    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario usuario);
    void deleteById(Long id);
}
