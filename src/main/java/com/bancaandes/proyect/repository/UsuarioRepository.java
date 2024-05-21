package com.bancaandes.proyect.repository;



import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.bancaandes.proyect.Entity.Usuario;

public interface UsuarioRepository  extends MongoRepository<Usuario,ObjectId>{
    
    @Query("{_id:?0}")
    @Update("{$push:{cuentas:?1}}")
    public void addCuentaCliente(ObjectId idCliente,ObjectId idCuenta);
}
