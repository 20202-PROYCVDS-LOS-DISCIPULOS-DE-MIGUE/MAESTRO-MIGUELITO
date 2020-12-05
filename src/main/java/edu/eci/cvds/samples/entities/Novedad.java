/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class Novedad implements Serializable
{
    private int idNovedad;
    private Date fecha;
    private String titulo;
    private String detalle;
    private String responsable;
    private int equipo;
	private int elemento;
	private int laboratorio;
    
    public Novedad()
    {
    }
    
    public int getIdNovedad ()
    {
        return idNovedad;
    }
    public void setIdNovedad (int idNovedad)
    {
        this.idNovedad = idNovedad;
    }
    
    public Date getFecha ()
    {
        return fecha;
    }
    public void setFecha (Date fecha)
    {
        this.fecha = fecha;
    }
    
    public String getTitulo ()
    {
        return titulo;
    }
    public void setTitulo (String titulo)
    {
        this.titulo = titulo;
    }
    
    public String getDetalle ()
    {
        return detalle;
    }
    public void setDetalle (String detalle)
    {
        this.detalle = detalle;
    }
    
    public String getResponsable ()
    {
        return responsable;
    }
    public void setResponsable (String responsable)
    {
        this.responsable = responsable;
    }
    
    public int getEquipo()
    {
        return equipo;
    }
    public void setEquipo(int equipo)
    {
        this.equipo = equipo;
    }
	public int getElemento()
    {
        return elemento;
    }
    public void setElemento(int elemento)
    {
        this.elemento = elemento;
    }
	public int getLaboratorio()
    {
        return laboratorio;
    }
    public void setLaboratorio(int laboratorio)
    {
        this.laboratorio = laboratorio;
    }
    
    @Override
    public String toString () 
    {
        return "Novedad {idNovedad: " + idNovedad + ", Fecha: " + fecha + ", Titulo: " + titulo + ", Detalle: " + detalle +  ", Responsable: " + responsable+",Equipo"+equipo+",Elemento"+elemento+",Laboratorio"+laboratorio+ "}";
    }
}