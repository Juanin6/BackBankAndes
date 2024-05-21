package com.bancaandes.proyect.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancaandes.proyect.Entity.Oficina;
import com.bancaandes.proyect.repository.OficinaRepository;

@Service
public class OficinaService {

    @Autowired
    private OficinaRepository repo;

    

    
    
    public void saveOficina(Oficina oficina){
        repo.save(oficina);
    }

    public Iterable<Oficina> getAll(){
        return repo.findAll();
    }

    public Optional<Oficina> buscarPuntoAtencion(String id){
        return repo.buscarPuntoAtencionId(id);
    }
}
