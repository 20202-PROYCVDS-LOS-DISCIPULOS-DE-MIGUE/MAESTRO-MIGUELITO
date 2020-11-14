/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

import java.io.Serializable;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class Usuario implements Serializable 
{
    private int documento;
    private String nombre;
    private String apellido;
    private String correo;
    private int telefono;
    private int rol;
    private String estado;
    private String contraseña;
    private int labAsignado;
    
    public Usuario()
    {
        
    }
    
    /**
     *Constructor para la clase usuario
     * @param documento: Documento de indentificación de usuario.
     * @param nombre: Nombre de usuario.
     * @param apellido: Apellido de usuario.
     * @param correo: Correo de comunicación con el usuario.
     * @param telefono: Telefono de comunicación con el usuario.
     * @param rol: Rol de indentificación de usuario.
     * @param estado: Estado de usuario.
     * @param contraseña: Contraseña de usuario.
     * @param labAsignado: Laboratorio asignado al usuario.
     */
    public Usuario(int documento, String nombre, String apellido, String correo, int telefono, int rol, String estado, String contraseña, int labAsignado)
    {
        this.documento = documento;
        this.nombre= nombre;
    	this.apellido = apellido;
    	this.correo = correo;
    	this.telefono = telefono;
        this.rol = rol;
        this.contraseña = contraseña;
        this.labAsignado = labAsignado;
    }
    
    public int getDocumento ()
    {
        return documento;
    }
    public void setDocumento (int documento)
    {
        this.documento = documento;
    }
    
    public String getNombre ()
    {
        return nombre;
    }
    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getApellido ()
    {
        return apellido;
    }
    public void setApellido (String apellido)
    {
        this.apellido = apellido;
    }
    
    public String getCorreo ()
    {
        return correo;
    }
    public void setCorreo (String correo)
    {
        this.correo = correo;
    }
    
    public int getTelefono ()
    {
        return telefono;
    }
    public void setTelefono (int telefono)
    {
        this.telefono = telefono;
    }
    
    public int getRol ()
    {
        return rol;
    }
    public void setRol (int rol)
    {
        this.rol = rol;
    }
    
    public String getEstado()
    {
        return estado;
    }
    public void setEstado (String estado)
    {
        this.estado = estado;
    }
    
    public String getContraseña ()
    {
        return contraseña;
    }
    public void setContraseña (String contraseña)
    {
        this.contraseña = contraseña;
    }
    
    public int getLabAsignado ()
    {
        return labAsignado;
    }
    public void setLabAsignado (int labAsignado)
    {
        this.labAsignado = labAsignado;
    }
    
    @Override
    public String toString () 
    {
        return "Usuario {Documento: " + documento + ", Nombre: " + nombre + ", Apellido: " + apellido + ", Correo: " + correo + ", Telefono : " + telefono + ", Rol: " + rol + ", Estado: " + estado + ", Contraseña: " + contraseña + ", Laboratirio Asignado: " + labAsignado + "}";
    }
}
