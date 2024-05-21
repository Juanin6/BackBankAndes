package com.bancaandes.proyect.repository;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.bancaandes.proyect.Entity.OperacionCuenta;

public interface OperacionCuentaRepository extends MongoRepository<OperacionCuenta,ObjectId> {
    
     @Query("{$or:[{cuentaOrigen: ?0}, {cuentaDestino: ?0}], mes: ?1}, sort: {fecha: 1}")
     public Iterable<OperacionCuenta> buscarPorCuentasYMesOrdenadoPorFecha(ObjectId idCuenta,int mes);
}
