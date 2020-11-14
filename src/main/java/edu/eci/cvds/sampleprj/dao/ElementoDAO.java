package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.exceptions.PersistenceException;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface ElementoDAO{

	public void añadirElemento(Elemento elemento) throws PersistenceException;
	
}