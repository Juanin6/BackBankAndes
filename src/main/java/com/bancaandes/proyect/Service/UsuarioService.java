package com.bancaandes.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancaandes.proyect.Entity.Usuario;
import com.bancaandes.proyect.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public void saveUsuario(Usuario usuario) {
        repo.save(usuario);
    }
    public Iterable<Usuario> getAll(){
        return repo.findAll();
    }
}
