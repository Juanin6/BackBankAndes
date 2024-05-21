package com.bancaandes.proyect.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bancaandes.proyect.Entity.OperacionCuenta;
import com.bancaandes.proyect.Entity.OperacionString;
import com.bancaandes.proyect.Service.OperacionCuentaService;

@RestController
@CrossOrigin(origins = "*")
public class OperacionCuentaController {
    
    @Autowired
    OperacionCuentaService service;

    @PostMapping("/operacionCuenta")
    public String createOperacionCuenta(@RequestBody OperacionCuenta operacionCuenta){
        
        if(operacionCuenta.getTipoOperacion().equals("Transferencia")){
            service.transferencia(operacionCuenta);
        }
        else if(operacionCuenta.getTipoOperacion().equals("Retirar")){
            service.retiro(operacionCuenta);
        }
        else if(operacionCuenta.getTipoOperacion().equals("Consignar")){
            service.consignar(operacionCuenta);
        }
        return operacionCuenta.get_id().toString();
    }
    @GetMapping("/operaciones")
    public Iterable<OperacionString> darOperaciones(){
        return service.darOperaciones();
    }
    

    @GetMapping("cuenta/saldo/{id}")
    public int darSaldoPorId(@PathVariable(name = "id")String id){
        
        ObjectId  idCuenta= new ObjectId(id);
        return service.darSaldoPorId(idCuenta);
    }
    @GetMapping("/cuenta/{id}/{mes}")
    public Iterable<OperacionString> darOperacionesPorMes(@PathVariable(name = "id") String id,@PathVariable(name = "mes") int mes){
        ObjectId cuentaID = new ObjectId(id);
        return service.darCuentasPorMes(cuentaID, mes);
    }
    
}
