package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import java.util.ArrayList;

public interface ElementoDAO {
    public void registrarElemento(String tipo,String marca);
    public Elemento getElemento(int idElemento);
    public ArrayList<Elemento> getElementos();
	public ArrayList<Elemento> getElementosDisponibles();
}

