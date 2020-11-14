package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Novedad;
import edu.eci.cvds.exceptions.PersistenceException;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface NovedadDAO 
{
  
	public void añadirNovedad(Novedad novedad)throws PersistenceException;
}