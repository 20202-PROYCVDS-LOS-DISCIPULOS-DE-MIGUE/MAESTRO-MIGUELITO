package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.services.ElementoServicios;
import java.util.ArrayList;

public class ElementoServiciosImpl implements ElementoServicios {
    @Inject
    private ElementoDAO elementoDAO;

    @Override
    public void registrarElemento (String tipo, String marca) throws PersistenceException {
        elementoDAO.registrarElemento(tipo,marca);
    }

    @Override
    public Elemento getElemento (int idElemento) throws PersistenceException {
        return elementoDAO.getElemento(idElemento);
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 887c69887ffe3b0f1d5ce89f473246ed57c061ca
	@Override
    public ArrayList<Elemento>getElementos()throws PersistenceException {
        return elementoDAO.getElementos();
    }
	@Override
	public ArrayList<Elemento>getElementosDisponibles()throws PersistenceException {
=======

    @Override
    public ArrayList<Elemento>getElementos () throws PersistenceException {
        return elementoDAO.getElementos();
    }
	
    @Override
	public ArrayList<Elemento>getElementosDisponibles () throws PersistenceException {
>>>>>>> 52237dc0af5f18e942d3d191081de6417965e8fa
        return elementoDAO.getElementosDisponibles();
    }
	@Override
	public void asociarElemento(int idElemento, int equipo) throws PersistenceException{
		elementoDAO.asociarElemento(idElemento,equipo);
	}
	
	@Override
	public void darDeBajaElemento(int idElemento) throws PersistenceException{
		elementoDAO.darDeBajaElemento(idElemento);
	}

    @Override
    public void eliminarElemento (int idElemento,String marca) throws PersistenceException {
    	elementoDAO.eliminarElemento(idElemento, marca);
    }
}
