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
public class Elemento implements Serializable
{
    private int idElemento;
    private String tipo;
    private String marca;
    private boolean activo;
	private boolean disponible;
    private int equipo;
   
    
    public Elemento()
	{
    }
    
    public int getIdElemento ()
    {
        return idElemento;
    }
    public void setIdElemento (int idElemento)
    {
        this.idElemento = idElemento;
    }
    
    public String getTipo ()
    {
        return tipo;
    }
    public void setTipo (String tipo)
    {
        this.tipo = tipo;
    }
    
    public String getMarca()
    {
        return marca;
    }
    public void setMarca(String marca)
    {
        this.marca = marca;
    }
	
	public boolean getActivo()
    {
        return activo;
    }
    public void setActivo(boolean activo)
    {
        this.activo = activo;
    }
	
	public boolean getDisponible()
    {
        return disponible;
    }
    public void setDisponible(boolean disponible)
    {
        this.disponible = disponible;
    }
    
    public int getEquipo ()
    {
        return equipo;
    }
    public void setEquipo (int equipo)
    {
        this.equipo = equipo;
    }
    
    @Override
    public String toString () 
    {
        return "Elementos {idElemento: " + idElemento + ", Tipo: " + tipo + ", marca: " + marca +  ",activo:"+activo+",disponible:"+disponible+", Equipo: " + equipo + "}";
    }
}
