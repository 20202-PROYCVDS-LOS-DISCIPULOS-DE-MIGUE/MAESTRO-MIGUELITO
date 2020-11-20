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
        if(marca==null){
            throw new PersistenceException("Elemento incorrecto");
        }else{
            elementoDAO.registrarElemento(tipo,marca,activo,equipo);
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
