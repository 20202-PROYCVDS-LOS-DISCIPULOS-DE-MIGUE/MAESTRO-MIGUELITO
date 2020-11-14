package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;

public interface ServiciosElemento 
{
	public void añadirElemento(Elemento elemento) throws PersistenceException; 
}