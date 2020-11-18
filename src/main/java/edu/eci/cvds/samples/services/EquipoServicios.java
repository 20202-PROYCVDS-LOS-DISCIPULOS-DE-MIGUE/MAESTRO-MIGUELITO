package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface EquipoServicios {
    public void registrarEquipo(String nombre ,String estado,String enUso,int idLaboratorio)throws PersistenceException;
    public Equipo getEquipo(int id)throws PersistenceException;
    public void imprimir() throws PersistenceException;
    public ArrayList<Equipo> getEquipos()throws PersistenceException;
}