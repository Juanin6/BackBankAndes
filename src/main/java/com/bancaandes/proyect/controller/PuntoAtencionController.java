package com.bancaandes.proyect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bancaandes.proyect.Entity.PuntoAtencion;
import com.bancaandes.proyect.Service.PuntoAtencionService;

@RestController
@CrossOrigin(origins = "*")
public class PuntoAtencionController {
    
    @Autowired
    private PuntoAtencionService service;

    @PostMapping(value = "/puntoAtencion")
    public String createPunto(@RequestBody PuntoAtencion punto){
        
        service.createPuntoAtencion(punto);
        return "Exitoso";
    }
    
}
