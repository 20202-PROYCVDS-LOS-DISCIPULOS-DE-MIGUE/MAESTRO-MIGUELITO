package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import java.util.ArrayList;

public interface ElementoDAO {
    public Elemento getElemento(int idElemento) throws PersistenceException;
	public void registrarElemento(String tipo, String marca, boolean activo) throws PersistenceException;
    public ArrayList<Elemento> getElementos()throws PersistenceException;
}

