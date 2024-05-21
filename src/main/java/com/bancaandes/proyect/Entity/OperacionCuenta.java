package com.bancaandes.proyect.Entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="OperacionesCuenta")
public class OperacionCuenta {

    @Id
    private ObjectId _id;
    private ObjectId cuentaOrigen;
    private ObjectId cuentaDestino;

    
    
    


    private String puntoAtencion;
    private int mes;
    private Date fecha;
    private int valor;
    private String tipoOperacion;
    private int saldoCuentaOrigen;
    private int saldoCuentaDestino;

    public OperacionCuenta(ObjectId _id,ObjectId cuentaOrigen, ObjectId cuentaDestino, String puntoAtencion, int mes, Date fecha,int valor, String tipoOperacion, int saldoCuentaOrigen, int saldoCuentaDestino) {
        this._id =_id;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.puntoAtencion = puntoAtencion;
        this.mes = mes;
        this.fecha = fecha;
        this.valor = valor;
        this.tipoOperacion = tipoOperacion;
        this.saldoCuentaOrigen = saldoCuentaOrigen;
        this.saldoCuentaDestino = saldoCuentaDestino;
    }
    /* 
    public OperacionCuenta(String idString,String cuentaOrigenID, String cuentaDestinoID, String puntoAtencion, int mes, Date fecha,int valor, String tipoOperacion, int saldoCuentaOrigen, int saldoCuentaDestino )
    {
        this.idString =idString;
        this.cuentaOrigenID = cuentaOrigenID;
        this.cuentaDestinoID = cuentaDestinoID;
        this.puntoAtencion = puntoAtencion;
        this.mes = mes;
        this.fecha = fecha;
        this.valor = valor;
        this.tipoOperacion = tipoOperacion;
        this.saldoCuentaOrigen = saldoCuentaOrigen;
        this.saldoCuentaDestino = saldoCuentaDestino;
    }
    */

    

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public ObjectId getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(ObjectId cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public ObjectId getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(ObjectId cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public String getPuntoAtencion() {
        return puntoAtencion;
    }

    public void setPuntoAtencion(String puntoAtencion) {
        this.puntoAtencion = puntoAtencion;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getSaldoCuentaOrigen() {
        return saldoCuentaOrigen;
    }

    public void setSaldoCuentaOrigen(int saldoCuentaOrigen) {
        this.saldoCuentaOrigen = saldoCuentaOrigen;
    }

    public int getSaldoCuentaDestino() {
        return saldoCuentaDestino;
    }

    public void setSaldoCuentaDestino(int saldoCuentaDestino) {
        this.saldoCuentaDestino = saldoCuentaDestino;
    }
    public ObjectId get_id() {
        return _id;
    }

    

    

}
