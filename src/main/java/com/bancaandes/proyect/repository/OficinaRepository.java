package com.bancaandes.proyect.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.bancaandes.proyect.Entity.Oficina;

public interface OficinaRepository extends MongoRepository<Oficina,ObjectId> {
    
    
    @Query("{_id}:?0 ")
    @Update("{$push :{'puntosAtencion':{ 'ubicacion':?1, 'tipoPuntoAtencion':?2 }}}")
    public void insertPuntoAtencion(ObjectId oficinaId,String ubicacion,String tipoPuntoAtencion);
    
    @Query("{ 'puntosAtencion._id' : ?0 }")
    public Optional<Oficina> buscarPuntoAtencionId(String id); 
}
