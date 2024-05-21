package com.bancaandes.proyect.controller;




import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bancaandes.proyect.Entity.Cuenta;
import com.bancaandes.proyect.Service.CuentaServices;


@RestController
@CrossOrigin(origins = "*",allowedHeaders="*",methods = {RequestMethod.DELETE,RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})

public class CuentaController {

    @Autowired
    private CuentaServices service;
    
    @PostMapping(value = "/cuenta")
    public String createCuenta(@RequestBody Cuenta cuenta){
        service.saveCuenta(cuenta);
        return cuenta.get_id().toString();
    }
    @GetMapping(value = "/cuentas")
    public Iterable<Cuenta> getCuentas(){
        System.out.println("CUENTAASSDASDAS");
        return service.getAll();
    }
    @DeleteMapping(value = "/cuenta/cerrar/{id}")
    private void cerrarCuenta(@PathVariable(name = "id") String id){
        ObjectId idCuenta = new ObjectId(id);
        service.cerrarCuenta(idCuenta);
    }
    @DeleteMapping(value = "/cuenta/desactivar/{id}")
    private void desactivarCuenta(@PathVariable(name = "id")String id)
    {   
        
        ObjectId idCuenta = new ObjectId(id);
        service.desactivarCuenta(idCuenta); 
    }
    @GetMapping("/buscarFiltro")
    public Iterable<Cuenta> buscarCuentas(
            @RequestParam(required = false) String tipoCuenta,
            @RequestParam(required = false) int saldoMin,
            @RequestParam(required = false) int saldoMax,
            @RequestParam(required = false) String cliente) {
            ObjectId clienteID = new ObjectId(cliente);

        return service.darCuentasConsulta(tipoCuenta, saldoMin, saldoMax, clienteID);
    }

    @GetMapping("/TEST/{saldo}")
    public Iterable<Cuenta> TEST(@PathVariable(name = "saldo")int saldo){
        ObjectId aId = new ObjectId("663c141d6d5eeae2af706470");
        return service.darCuentasConsulta("Activa", saldo,50 ,aId );
    }
    
}
