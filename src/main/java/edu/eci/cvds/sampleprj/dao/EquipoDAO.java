package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface EquipoDAO{

    public Equipo getEquipo(int id) throws PersistenceException;
	public void registrarEquipo(String nombre, String estado, String enUso, int idLaboratorio) throws PersistenceException;
    public ArrayList<Equipo> getEquipos()throws PersistenceException;
}
