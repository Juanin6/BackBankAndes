package com.bancaandes.proyect.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancaandes.proyect.Entity.Cuenta;
import com.bancaandes.proyect.Entity.Usuario;
import com.bancaandes.proyect.repository.CuentaRepository;
import com.bancaandes.proyect.repository.UsuarioRepository;

@Service
public class CuentaServices {
    
    @Autowired
    private CuentaRepository repo;

    @Autowired
    private UsuarioRepository repoUser;

    public void saveCuenta(Cuenta cuenta){
        ObjectId idCliente = cuenta.getCliente();
        Optional<Usuario> cliente = repoUser.findById(idCliente);
        if(cliente.isPresent()){
            repo.save(cuenta);
            repoUser.addCuentaCliente(idCliente, cuenta.get_id());
        } 
    }
    public List<Cuenta> getAll(){
        List<Cuenta> cuentas= new ArrayList<Cuenta>();
        for (Cuenta cuenta : repo.findAll()) {
            Cuenta cuenta2 = new Cuenta(cuenta.get_id().toString(), cuenta.getCliente(), cuenta.getTipoCuenta(), cuenta.getSaldo(), cuenta.getEstadoCuenta());
            cuentas.add(cuenta2);
        }
        return cuentas;
        
    }
    public Iterable<Cuenta> darCuentasConsulta(String tipoCuenta,Integer saldomin,Integer saldoMax,ObjectId clienteId){
        return repo.buscarCuentasConsulta(tipoCuenta, saldomin, saldoMax, clienteId);
    }

    public void cerrarCuenta(ObjectId cuentaID){
        repo.cerrarCuenta(cuentaID);
        
    }
    public void desactivarCuenta(ObjectId cuentaID){
        repo.desactivarCuenta(cuentaID);
    }
}
