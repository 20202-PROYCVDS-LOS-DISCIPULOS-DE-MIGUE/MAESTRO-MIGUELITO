package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import java.util.ArrayList;

public interface ElementoServicios {
    public void registrarElemento(String tipo ,String marca)throws PersistenceException;
    public Elemento getElemento(int idElemento)throws PersistenceException;
    public ArrayList<Elemento> getElementos() throws PersistenceException;
	public ArrayList<Elemento> getElementosDisponibles() throws PersistenceException;
	public void asociarElemento(int idElemento, int equipo) throws PersistenceException;
	public void darDeBajaElemento(int idElemento)throws PersistenceException;
}
