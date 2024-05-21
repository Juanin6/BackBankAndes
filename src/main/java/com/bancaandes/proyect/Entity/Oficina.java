package com.bancaandes.proyect.Entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Oficinas")
public class Oficina {
    @Id
    private ObjectId _id;
    private String nombre;
    private String direccion;
    private int maxPuntosAtencion;
    private List<PuntoAtencion> puntosAtencion;
    

    public Oficina(ObjectId _id,String nombre, String direccion, int maxPuntosAtencion,List<PuntoAtencion> puntosAtencion) {
        this._id = _id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.maxPuntosAtencion = maxPuntosAtencion;
        this.puntosAtencion = puntosAtencion;
        
    }
    public Oficina(){}

    

    public int getmaxPuntosAtencion() {
        return maxPuntosAtencion;
    }
    public void setmaxPuntosAtencion(int maxPuntosAtencion) {
        this.maxPuntosAtencion = maxPuntosAtencion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<PuntoAtencion> getPuntosAtencion() {
        return puntosAtencion;
    }

    public void setPuntosAtencion(List<PuntoAtencion> puntosAtencion) {
        this.puntosAtencion = puntosAtencion;
    }
    public ObjectId get_id() {
        return _id;
    }
    
    
    
}
