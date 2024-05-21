package com.bancaandes.proyect.Entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Cuentas")
public class Cuenta {

    @Id
    private ObjectId _id;
    private String idString;
    private ObjectId cliente;
    private String tipoCuenta;
    private int saldo;
    private String estadoCuenta;

    

    public Cuenta() {
    }
    

    public Cuenta(ObjectId _id, ObjectId cliente, String tipoCuenta, int saldo, String estadoCuenta) {
        this._id = _id;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.estadoCuenta = estadoCuenta;
    }

    public Cuenta(String _id, ObjectId cliente, String tipoCuenta, int saldo, String estadoCuenta) {
        this.idString = _id;
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.estadoCuenta = estadoCuenta;
    }
    

    public ObjectId getCliente() {
        return cliente;
    }

    

    public String getIdString() {
        return idString;
    }


    public void setIdString(String idString) {
        this.idString = idString;
    }


    public void setCliente(ObjectId cliente) {
        this.cliente = cliente;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }


    public ObjectId get_id() {
        return _id;
    }

    
    

    

}
