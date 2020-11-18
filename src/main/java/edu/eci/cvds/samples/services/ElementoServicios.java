package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface ElementoServicios {
    public void registrarElemento(String nombre ,String marca,String modelo,String caracteristicas,int idEquipo)throws PersistenceException;
    public Elemento getElemento(int id)throws PersistenceException;
    public void imprimir() throws PersistenceException;
    public ArrayList<Elemento> getElementos() throws PersistenceException;
    public void editElemento(int id, int idEquipo) throws PersistenceException;
}
