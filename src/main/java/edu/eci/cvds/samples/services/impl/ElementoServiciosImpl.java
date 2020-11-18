package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.services.ElementoServicios;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class ElementoServiciosImpl implements ElementoServicios {
    @Inject
    private ElementoDAO elementoDAO;


    @Override
    public void registrarElemento(String nombre, String marca, String modelo, String caracteristicas, int idEquipo) throws PersistenceException {
        if(marca==null){
            throw new PersistenceException("Elemento incorrecto");
        }else{
            elementoDAO.registrarElemento(nombre,marca,modelo,caracteristicas,idEquipo);
        }
    }

    @Override
    public Elemento getElemento(int id) throws PersistenceException {
        return null;
    }

    public void imprimir(){
        System.out.println("imprimir");
    }

    public ArrayList<Elemento>getElementos()throws PersistenceException {
        return elementoDAO.getElementos();
    }
    @Override
    public void editElemento(int id,int idEquipo)throws PersistenceException{
        elementoDAO.editElemento(id,idEquipo);
    }

}
