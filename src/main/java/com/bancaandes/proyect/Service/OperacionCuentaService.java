package com.bancaandes.proyect.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancaandes.proyect.Entity.Cuenta;
import com.bancaandes.proyect.Entity.Oficina;
import com.bancaandes.proyect.Entity.OperacionCuenta;
import com.bancaandes.proyect.Entity.OperacionString;
import com.bancaandes.proyect.repository.CuentaRepository;
import com.bancaandes.proyect.repository.OficinaRepository;
import com.bancaandes.proyect.repository.OperacionCuentaRepository;

@Service
public class OperacionCuentaService {

    @Autowired
    private OperacionCuentaRepository repo;

    @Autowired
    private CuentaRepository cuentaRepo;

    @Autowired
    private OficinaRepository oficinaRepository;
    
    

    private Boolean cuentaExist(ObjectId cuentaID){
        Optional<Cuenta> cuenta =cuentaRepo.findById(cuentaID);
        if(cuenta.isPresent()){
            return true;
        }
        else{
            return false;
        }
    }

    private Boolean oficinaExist(String oficinaID){
        Optional<Oficina> oficina =oficinaRepository.buscarPuntoAtencionId(oficinaID);
        if(oficina.isPresent()){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void saveOperacionCuenta(OperacionCuenta operacionCuenta){
        
        repo.save(operacionCuenta);
    }
    public void retiro(OperacionCuenta operacionCuenta){
        boolean cuentaExist = cuentaExist(operacionCuenta.getCuentaOrigen());
        boolean oficinaExist = oficinaExist(operacionCuenta.getPuntoAtencion());
        if(cuentaExist && oficinaExist ){
            cuentaRepo.sumarSaldoCuenta(operacionCuenta.getCuentaOrigen(), -operacionCuenta.getValor());
            repo.save(operacionCuenta);
        }

        
    }

    public void consignar(OperacionCuenta operacionCuenta){
        boolean cuentaExist = cuentaExist(operacionCuenta.getCuentaOrigen());
        boolean oficinaExist = oficinaExist(operacionCuenta.getPuntoAtencion());
        if(cuentaExist && oficinaExist){
            cuentaRepo.sumarSaldoCuenta(operacionCuenta.getCuentaOrigen(), operacionCuenta.getValor());
            repo.save(operacionCuenta);
        }
    }

    public void transferencia(OperacionCuenta operacionCuenta){
        boolean cuentaDestinoExist = cuentaExist(operacionCuenta.getCuentaDestino());
        boolean cuentaExist = cuentaExist(operacionCuenta.getCuentaOrigen());
        boolean oficinaExist = oficinaExist(operacionCuenta.getPuntoAtencion());
        if(cuentaExist && oficinaExist && cuentaDestinoExist){
            if(operacionCuenta.getCuentaOrigen()!=operacionCuenta.getCuentaDestino()){
                cuentaRepo.sumarSaldoCuenta(operacionCuenta.getCuentaOrigen(), -operacionCuenta.getValor());
                cuentaRepo.sumarSaldoCuenta(operacionCuenta.getCuentaDestino(), operacionCuenta.getValor());
                repo.save(operacionCuenta);
            }
        }
    }
    public int darSaldoPorId(ObjectId id){
        
        return cuentaRepo.findById(id).get().getSaldo() ;

    }
    public Iterable<OperacionString> darCuentasPorMes(ObjectId idCuenta,int mes){
        List<OperacionString> operaciones = new ArrayList<OperacionString>();
        for (OperacionCuenta operacion : repo.buscarPorCuentasYMesOrdenadoPorFecha(idCuenta, mes)) {
            OperacionString operacion2 = new OperacionString(operacion.get_id().toString(),operacion.getCuentaOrigen().toString(), operacion.getCuentaDestino().toString(), operacion.getPuntoAtencion(), operacion.getMes(), operacion.getFecha(), operacion.getValor(), operacion.getTipoOperacion(), operacion.getSaldoCuentaOrigen(), operacion.getSaldoCuentaDestino());
            operaciones.add(operacion2);
        }
        return operaciones;
    }

    public Iterable<OperacionString> darOperaciones() {
        List<OperacionString> operaciones = new ArrayList<OperacionString>();
        for (OperacionCuenta operacion : repo.findAll()) {
            OperacionString operacion2 = new OperacionString(operacion.get_id().toString(),operacion.getCuentaOrigen().toString(), operacion.getCuentaDestino().toString(), operacion.getPuntoAtencion(), operacion.getMes(), operacion.getFecha(), operacion.getValor(), operacion.getTipoOperacion(), operacion.getSaldoCuentaOrigen(), operacion.getSaldoCuentaDestino());
            operaciones.add(operacion2);
        }
        return operaciones;
    }
    

}
