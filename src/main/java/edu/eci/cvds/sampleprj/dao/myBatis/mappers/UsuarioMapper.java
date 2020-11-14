/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Usuario;

import java.util.List;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface UsuarioMapper 
{
    public boolean guardarUsuario(@Param("documento") int documento,@Param("contraseña") String contraseña);
    
    public Usuario cargarUsuario(@Param("documento") int documento, @Param("contraseña") String contraseña);
    
    public List<Usuario> consultarUsuarios();
}
