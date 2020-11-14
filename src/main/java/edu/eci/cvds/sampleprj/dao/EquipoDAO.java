package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.exceptions.PersistenceException;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface EquipoDAO{

	public void añadirEquipo(Equipo equipo) throws PersistenceException;
}