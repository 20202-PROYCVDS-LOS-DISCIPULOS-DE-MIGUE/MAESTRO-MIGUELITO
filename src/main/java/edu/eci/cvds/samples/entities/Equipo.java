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
public class Equipo implements Serializable
{
    private int idequipo;
    private String ip;
    private String informacion;
    private boolean activo;
    private int laboratorio;
    
    public Equipo() 
    {
        
    }

    
    public int getIdEquipo ()
    {
        return idequipo;
    }
    public void setIdEquipo (int idequipo)
    {
        this.idequipo = idequipo;
    }
    
    public String getIp ()
    {
        return ip;
    }
    public void setIp (String ip)
    {
        this.ip = ip;
    }
    
    public String getInformacion ()
    {
        return informacion;
    }
    public void setInformacion (String informacion)
    {
        this.informacion = informacion;
    }
	
    public boolean getActivo()
    {
        return activo;
    }
    public void setActivo(boolean activo)
    {
        this.activo = activo;
    }
    
    public int getLaboratorio ()
    {
        return laboratorio;
    }
    public void setLaboratorio (int laboratorio)
    {
        this.laboratorio = laboratorio;
    }
    
    @Override
    public String toString () 
    {
        return "Equipos {idequipo: " + idequipo + ", ip: " + ip + ", Información: " + informacion + ",activo:"+activo+", Laboratorio: " + laboratorio + "}";
    }
}
