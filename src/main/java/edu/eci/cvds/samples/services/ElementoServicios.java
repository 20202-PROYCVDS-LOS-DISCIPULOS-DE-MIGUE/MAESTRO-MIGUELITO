package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import java.util.ArrayList;

public interface ElementoServicios {
    public void registrarElemento(String tipo ,String marca)throws PersistenceException;
    public Elemento getElemento(int idElemento)throws PersistenceException;
    public ArrayList<Elemento> getElementos() throws PersistenceException;
<<<<<<< HEAD
	public ArrayList<Elemento> getElementosDisponibles() throws PersistenceException;
	public void asociarElemento(int idElemento, int equipo) throws PersistenceException;
	public void darDeBajaElemento(int idElemento)throws PersistenceException;
=======
    public ArrayList<Elemento> getElementosDisponibles() throws PersistenceException;
    public void eliminarElemento(int idElemento, String marca)throws PersistenceException;
>>>>>>> 52237dc0af5f18e942d3d191081de6417965e8fa
}
