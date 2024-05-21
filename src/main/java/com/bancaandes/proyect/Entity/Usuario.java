package com.bancaandes.proyect.Entity;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Usuarios")
public class Usuario {
    @Id
    private ObjectId _id;
    private String login;
    private String password;
    private String nombre;
    private String correo ;
    private int telefono;
    private String tipoUsuario;
    @Field("cuentas")
    private List<ObjectId> cuentas;

    public Usuario(ObjectId _id,String login, String password, String nombre, String correo, int telefono, String tipoUsuario,
            List<ObjectId> cuentas) {
        this._id =_id;
        this.login = login;
        this.password = password;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
        this.cuentas = cuentas;
    }
    

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public List<ObjectId> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<ObjectId> cuentas) {
        this.cuentas = cuentas;
    }
    public ObjectId get_id() {
        return _id;
    }


    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    
}
