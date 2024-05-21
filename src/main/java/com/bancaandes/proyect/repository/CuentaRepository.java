package com.bancaandes.proyect.repository;  
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.repository.query.Param;

import com.bancaandes.proyect.Entity.Cuenta;
public interface CuentaRepository extends MongoRepository<Cuenta,ObjectId> 
{   
    @Query("{_id:?0,estadoCuenta:'Activa',saldo:0}")
    @Update("{$set:{estadoCuenta:'Cerrada'}}")
    void cerrarCuenta(ObjectId cuentaId);

    @Query("{_id:?0,estadoCuenta:'Activa'}")
    @Update("{$set:{estadoCuenta:'Desactivada'}}")
    public void desactivarCuenta(ObjectId cuentaId);


    @Query("{_id:?0,estadoCuenta:'Activa'}")
    @Update("{$inc:{saldo: ?1}}")
    public void sumarSaldoCuenta(ObjectId idCuenta ,int valor);

    @Query(value = "{ _id: :idCuenta }", fields = "{ saldo : 1, _id : 0 }")
    public int darSaldoPorId(@Param("idCuenta") ObjectId idCuenta);
    
    @Query("{'$and': [ ?#{ [0] ? {'tipoCuenta': [0]} : {} },?#{ [1] ? {'saldo': {'$gte': [1]}} : {} }, ?#{ [2] ? {'saldo': {'$lte': [2]}} : {} }, ?#{ [3] ? {'cliente': [3]} : {} } ]}")
    public Iterable<Cuenta> buscarCuentasConsulta(String tipoCuenta, int saldoMin, int saldoMax, ObjectId clienteID);

    @Query("{"
    + "'$and': ["
    + "{'$cond': { 'if': {'$ne': [?0, null]}, 'then': {'tipoCuenta': ?0}, 'else': {}}},"
    + "{'$cond': { 'if': {'$and': [{ '$ne': [?1, null]}, { '$ne': [?2, null]}]}, "
    + "'then': {'saldo': { '$gte': ?1, '$lte': ?2}}, 'else': {}}},"
    + "{'$cond': { 'if': {'$ne': [?3, null]}, 'then': {'cliente': ?3}, 'else': {}}"
    + "]"
    + "}")
    public Iterable<Cuenta> buscarCuentasConsulta(String tipoCuenta, Integer saldoMin, Integer saldoMax, ObjectId clienteID);
}
