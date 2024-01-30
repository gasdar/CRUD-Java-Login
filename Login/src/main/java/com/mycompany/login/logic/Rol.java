package com.mycompany.login.logic;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Entity;
/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;*/
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rol implements Serializable {
    
    @Id
    // @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    
    @Basic
    private String nombre;
    private String descripcion;
    
    @OneToMany (mappedBy="rolUsuario")
    private ArrayList<Usuario> listaUsuarios;
    
    public Rol() {
    }

    public Rol(int id, String nombre, String descripcion, ArrayList<Usuario> listaUsuarios) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaUsuarios = listaUsuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", listaUsuarios=" + listaUsuarios + '}';
    }
    
}
