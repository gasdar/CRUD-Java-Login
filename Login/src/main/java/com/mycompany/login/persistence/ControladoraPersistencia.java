package com.mycompany.login.persistence;

import com.mycompany.login.logic.Rol;
import com.mycompany.login.logic.Usuario;
import com.mycompany.login.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void eliminarUsuario(int idUsuario) {
        try {
            usuarioJpa.destroy(idUsuario);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void editarUsuario(Usuario uEditar) {
        try {
            usuarioJpa.edit(uEditar);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Usuario traerUsuario(int idUsuario) {
        return usuarioJpa.findUsuario(idUsuario);
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
