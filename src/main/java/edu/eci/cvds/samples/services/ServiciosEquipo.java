package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;

public interface ServiciosEquipo
{
	public void añadirEquipo(Equipo equipo) throws PersistenceException;
}