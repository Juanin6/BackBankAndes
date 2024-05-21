package com.bancaandes.proyect.Entity;


import org.bson.types.ObjectId;


public class PuntoAtencion {
    
    
    private String ubicacion;
    private String tipoPuntoAtencion;
    private ObjectId oficinaId;

    public PuntoAtencion(String ubicacion, String tipoPuntoAtencion,ObjectId oficinaId ){
        
        this.ubicacion = ubicacion;
        this.tipoPuntoAtencion = tipoPuntoAtencion;
        this.oficinaId = oficinaId;
    }

    

    public ObjectId getOficinaId() {
        return oficinaId;
    }



    public void setOficinaId(ObjectId oficinaId) {
        this.oficinaId = oficinaId;
    }



    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    
    
    public String getTipoPuntoAtencion() {
        return tipoPuntoAtencion;
    }



    public void setTipoPuntoAtencion(String tipoPuntoAtencion) {
        this.tipoPuntoAtencion = tipoPuntoAtencion;
    }



    

    
}
