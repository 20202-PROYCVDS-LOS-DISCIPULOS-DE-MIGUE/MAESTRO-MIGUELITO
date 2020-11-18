package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Laboratorio;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface LaboratorioServicios {
    public void registrarLaboratorio(String nombre,String horario,String descripcion)throws PersistenceException;
    public Laboratorio getLaboratorio(int id)throws PersistenceException;
    public ArrayList<Laboratorio> getLaboratorios()throws PersistenceException;


	
}