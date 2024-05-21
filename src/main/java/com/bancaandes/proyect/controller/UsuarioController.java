package com.bancaandes.proyect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bancaandes.proyect.Entity.Usuario;
import com.bancaandes.proyect.Service.UsuarioService;


@RestController
@CrossOrigin(origins="*")
public class UsuarioController {
    
    @Autowired
    private UsuarioService service;

    @PostMapping(value = "/usuario")
    private String createUsuario(@RequestBody Usuario usuario){
        service.saveUsuario(usuario);
        return usuario.get_id().toString();
    }
    @GetMapping(value = "/usuarios")
    private Iterable<Usuario> getUsuarios(){
        return service.getAll();
    }
}
