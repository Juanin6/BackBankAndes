package com.bancaandes.proyect.controller;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bancaandes.proyect.Entity.Oficina;
import com.bancaandes.proyect.Service.OficinaService;


@RestController
@CrossOrigin(origins = "*")
public class OficinaController {

    @Autowired
    OficinaService service;

    @PostMapping("/oficina")
    public String createOficina(@RequestBody Oficina oficina){
        service.saveOficina(oficina);
        return oficina.get_id().toString();
    }

    @GetMapping("/oficinas")
    public Iterable<Oficina> getAllOficinas()
    {
        return service.getAll();
    }
    @GetMapping(value ="/buscar/{id}")
    public Optional<Oficina>  buscarPuntoAtencion(@PathVariable (name = "id")String id){
        Optional<Oficina> oficina = service.buscarPuntoAtencion(id);
        if (oficina.isPresent()) {
            System.out.println("Oficina encontrada: " + oficina.get());
            
        } else {
            System.out.println("Oficina no encontrada para id: " + id);
        }
        return oficina;
    }
}
