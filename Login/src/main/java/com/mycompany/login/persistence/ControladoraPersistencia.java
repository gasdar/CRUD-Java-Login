package com.mycompany.login.persistence;

import com.mycompany.login.logic.Rol;
import com.mycompany.login.logic.Usuario;
import java.util.ArrayList;
import java.util.List;

public class ControladoraPersistencia {
    
    // Controladora que tiene una instancia de todos los controladores JPA
    private UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    private RolJpaController rolJpa = new RolJpaController();
    
    //Constructor Vacio
    public ControladoraPersistencia() {}
    
    // ---------- MÉTODOS CRUD: USUARIO ---------
    public void registrarUsuario(Usuario usuario) {
        usuarioJpa.create(usuario);
    }
    public ArrayList<Usuario> traerUsuarios() {
        List<Usuario> allUsuarios = usuarioJpa.findUsuarioEntities();
        ArrayList<Usuario> listaUsuarios = new ArrayList<> (allUsuarios);
        return listaUsuarios;
    }

    // ---------- MÉTODOS CRUD: Rol ---------
    public ArrayList<Rol> traerRoles() {
        List<Rol> allRoles = rolJpa.findRolEntities();
        ArrayList<Rol> listaRoles = new ArrayList<> (allRoles);
        return listaRoles;
    }
    
    
}
