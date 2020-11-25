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
public class Laboratorio implements Serializable 
{
    private int idlaboratorio;
    private String nombre;
    private String informacion;
   
    
    public Laboratorio(int idlaboratorio, String nombre, String informacion)
    {
        this.idlaboratorio = idlaboratorio;
        this.nombre = nombre;
        this.informacion = informacion;
    }
    
    public int getIdLaboratorio ()
    {
        return idlaboratorio;
    }
    public void setIdLaboratorio (int idlaboratorio)
    {
        this.idlaboratorio = idlaboratorio;
    }
    
    public String getNombre ()
    {
        return nombre;
    }
    public void setNombre (String nombre)
    {
        this.nombre = nombre;
    }
    
    
    public String getInformacion ()
    {
        return informacion;
    }
    public void setInformacion (String informacion)
    {
        this.informacion = informacion;
    }
    
    @Override
    public String toString () 
    {
        return "Laboratory {idlaboratorio: " + idlaboratorio + ", Nombre: " + nombre + ", Información: " + informacion + "}";
    }
}
