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
    private int responsable;
    private int registro;
    
    public Novedad() 
    {
        
    }
    
    public Novedad(int idNovedad, Date fecha, String titulo, String detalle, int responsable, int registro)
    {
        this.idNovedad = idNovedad;
        this.fecha = fecha;
        this.titulo = titulo;
        this.detalle = detalle;
        this.responsable = responsable;
        this.registro = registro;
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
    
    public int getResponsable ()
    {
        return responsable;
    }
    public void setResponsable (int responsable)
    {
        this.responsable = responsable;
    }
    
    public int getRegistro ()
    {
        return registro;
    }
    public void setRegistro (int registro)
    {
        this.registro = registro;
    }
    
    @Override
    public String toString () 
    {
        return "Novedad {idNovedad: " + idNovedad + ", Fecha: " + fecha + ", Titulo: " + titulo + ", Detalle: " + detalle +  ", Responsable: " + responsable + ", Registro: " + registro + "}";
    }
}
