package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;

public interface ServiciosNovedad
{
	public void añadirNovedad(Novedad novedad)throws PersistenceException; 
}