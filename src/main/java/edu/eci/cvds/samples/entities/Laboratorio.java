/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;
import java.io.Serializable;
import java.time.LocalDate;
/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class Laboratorio implements Serializable 
{
    private int idlaboratorio;
    private String nombre;
    private boolean activo;
	private int equiposAsociados;
	private LocalDate fechaRegistro;
    private LocalDate fechaCierre;
    
    public Laboratorio()
    {
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
    
    
    public boolean getActivo()
    {
        return activo;
    }
    public void setActivo(boolean activo)
    {
        this.activo = activo;
    }
	
	public int getEquiposAsociados ()
    {
        return equiposAsociados;
    }
    public void setEquiposAsociados (int equiposAsociados)
    {
        this.equiposAsociados = equiposAsociados;
    }
	
	public LocalDate getFechaRegistro ()
    {
        return fechaRegistro;
    }
    public void setFechaRegistro (LocalDate fechaRegistro)
    {
        this.fechaRegistro = fechaRegistro;
    }
	
	public LocalDate getFechaCierre ()
    {
        return fechaCierre;
    }
    public void setFechaCierre (LocalDate fechaCierre)
    {
        this.fechaCierre = fechaCierre;
    }
    
    @Override
    public String toString () 
    {
        return "Laboratory {idlaboratorio: " + idlaboratorio + ", Nombre: " + nombre + ", activo: " + activo +", equiposAsociados: " + equiposAsociados +", fechaRegistro: " + fechaRegistro +", fechaCierre: " + fechaCierre + "}";
    }
}
