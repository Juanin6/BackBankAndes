package com.bancaandes.proyect.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancaandes.proyect.Entity.PuntoAtencion;
import com.bancaandes.proyect.repository.OficinaRepository;

@Service
public class PuntoAtencionService {
    
    @Autowired
    private OficinaRepository repo;

    public void createPuntoAtencion(PuntoAtencion puntoAtencion){
        
        repo.insertPuntoAtencion(puntoAtencion.getOficinaId(),puntoAtencion.getUbicacion(),puntoAtencion.getTipoPuntoAtencion());
        
    }
    
}
