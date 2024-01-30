package com.mycompany.login.logic;

import com.mycompany.login.persistence.ControladoraPersistencia;
import java.util.ArrayList;

public class Controladora {
    
    //Controladora de la lógica, esta se comunica constantemente con las capas
    private ControladoraPersistencia controlPersis = null;
    
    // Controlador Vacio
    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }
    
    // ---------- MÉTODOS CRUD: USUARIO ---------
    public void registrarUsuario(String nombreUsuario, String clave, String rol) {
        Usuario usuario = new Usuario();
        Rol rolUsuario = encontrarRolDeUsuario(rol);
        int idUsuario = encontrarIdUsuario() + 1;
        
        usuario.setId(idUsuario);
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setClave(clave);
        if(rolUsuario != null) {
            usuario.setRolUsuario(rolUsuario);
        }
        
        controlPersis.registrarUsuario(usuario);
    }
    public ArrayList<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }
    public ArrayList<Usuario> traerUsuariosComunes() {
        ArrayList<Usuario> usuariosComunes = new ArrayList<> ();
        ArrayList<Usuario> listaUsuarios = traerUsuarios();
        
        for(Usuario user : listaUsuarios) {
            if(user.getRolUsuario().getNombre().equalsIgnoreCase("user")) {
                usuariosComunes.add(user);
            }
        }
        
        return usuariosComunes;
    }
    
    public Usuario validarUsuario(String usuario, String clave) {
        Usuario user = null;
        ArrayList<Usuario> listaUsuarios = traerUsuarios();
        
        if(listaUsuarios != null) {
            for(Usuario usu : listaUsuarios) {
                if(usu.getNombreUsuario().equals(usuario)) {
                    if(usu.getClave().equals(clave)) {
                        user = usu;
                        break;
                    } else {
                        user = null;
                        return user;
                    }
                } else {
                    user = null;
                }
            }
        } else {
            user = null;
        }
        
        return user;
    }
    private int encontrarIdUsuario() {
        ArrayList<Usuario> listaUsuarios = traerUsuarios();
        return listaUsuarios.get(listaUsuarios.size() - 1).getId();
    }
    
    // ---------- MÉTODOS CRUD: ROL ---------
    public ArrayList<Rol> traerRoles() {
        return controlPersis.traerRoles();
    }

    private Rol encontrarRolDeUsuario(String rol) {
        Rol rolUsuario = null;
        ArrayList<Rol> listaRoles = traerRoles();
        
        for(int i=0; i<listaRoles.size(); i++) {
            if(listaRoles.get(i).getNombre().equalsIgnoreCase(rol)) {
                rolUsuario = listaRoles.get(i);
                return rolUsuario;
            }
        }
        
        return rolUsuario;
    }
    
}   // FIN DE CLASE
