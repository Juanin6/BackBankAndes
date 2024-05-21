package com.bancaandes.proyect.Entity;

import java.util.Date;

public class OperacionString {
    private String idString;
    private String cuentaOrigenID;
    private String cuentaDestinoID;
    private String puntoAtencion;
    private int mes;
    private Date fecha;
    private int valor;
    private String tipoOperacion;
    private int saldoCuentaOrigen;
    private int saldoCuentaDestino;
    public OperacionString(String idString,String cuentaOrigenID, String cuentaDestinoID, String puntoAtencion, int mes, Date fecha,int valor, String tipoOperacion, int saldoCuentaOrigen, int saldoCuentaDestino )
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
    public String getIdString() {
        return idString;
    }
    public void setIdString(String idString) {
        this.idString = idString;
    }
    public String getCuentaOrigenID() {
        return cuentaOrigenID;
    }
    public void setCuentaOrigenID(String cuentaOrigenID) {
        this.cuentaOrigenID = cuentaOrigenID;
    }
    public String getCuentaDestinoID() {
        return cuentaDestinoID;
    }
    public void setCuentaDestinoID(String cuentaDestinoID) {
        this.cuentaDestinoID = cuentaDestinoID;
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
    
}
