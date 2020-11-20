package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import java.sql.Time;
import java.util.ArrayList;

public interface ElementoServicios {
    public void registrarElemento(String tipo ,String marca,boolean activo,int equipo)throws PersistenceException;
    public Elemento getElemento(int idElemento)throws PersistenceException;
    public void imprimir() throws PersistenceException;
    public ArrayList<Elemento> getElementos() throws PersistenceException;
    public void editElemento(int idElemento, int equipo) throws PersistenceException;
}
