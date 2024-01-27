package com.mycompany.login.logic;

import com.mycompany.login.persistence.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    //Controladora de la lógica, esta se comunica constantemente con las capas
    private ControladoraPersistencia controlPersis = null;
    
    // Controlador Vacio
    public Controladora() {
        controlPersis = new ControladoraPersistencia();
    }
    
    // ---------- MÉTODOS CRUD: USUARIO ---------

    private List<Usuario> traerUsuarios() {
        return controlPersis.traerUsuarios();
    }
    
    public String validarUsuario(String usuario, String clave) {
        
        String mensaje = "";
        List<Usuario> listaUsuarios = traerUsuarios();
        
        if(listaUsuarios != null) {
            
            for(Usuario usu : listaUsuarios) {
                
                if(usu.getNombreUsuario().equals(usuario)) {
                    if(usu.getClave().equals(clave)) {
                        mensaje = "Bienvenid@ " + usu.getNombreUsuario() + "!!";
                        break;
                    } else {
                        mensaje = "Contraseña incorrecta.";
                        return mensaje;
                    }
                } else {
                    mensaje = "Usuario no encontrado";
                }
                
            }
            
        } else {
            mensaje = "No hay usuarios registrados";
        }
        
        return mensaje;
    }
    
    
}
