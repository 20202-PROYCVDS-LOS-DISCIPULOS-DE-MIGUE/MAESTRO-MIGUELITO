package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.services.ElementoServicios;
import java.sql.Time;
import java.util.ArrayList;

public class ElementoServiciosImpl implements ElementoServicios {
    @Inject
    private ElementoDAO elementoDAO;

    @Override
    public void registrarElemento(String tipo, String marca, boolean activo,int equipo) throws PersistenceException {
        try 
		{
			elementoDAO.registrarElemento(tipo,marca,activo,equipo);
		} catch (PersistenceException e) 
		{
			throw new PersistenceException("Error agregando el elemento");
		}
    }

    @Override
    public Elemento getElemento(int idElemento) throws PersistenceException {
        return elementoDAO.getElemento(idElemento);
    }

    public ArrayList<Elemento>getElementos()throws PersistenceException {
        return elementoDAO.getElementos();
    }

}
