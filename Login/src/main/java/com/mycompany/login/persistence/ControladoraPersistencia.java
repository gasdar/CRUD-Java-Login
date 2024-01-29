package com.mycompany.login.persistence;

import com.mycompany.login.logic.Usuario;
import java.util.List;

public class ControladoraPersistencia {
    
    // Controladora que tiene una instancia de todos los controladores JPA
    private UsuarioJpaController usuarioJpa = new UsuarioJpaController();
    private RolJpaController rolJpa = new RolJpaController();
    
    //Constructor Vacio
    public ControladoraPersistencia() {}
    
    // ---------- MÉTODOS CRUD: USUARIO ---------

    public List<Usuario> traerUsuarios() {
        return usuarioJpa.findUsuarioEntities();
    }
    
    
}
