package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;
import java.sql.Time;
import java.util.ArrayList;

public interface EquipoServicios {
    public void registrarEquipo(String ip ,String informacion,boolean activo,int laboratorio)throws PersistenceException;
    public Equipo getEquipo(int id)throws PersistenceException;
    public void imprimir() throws PersistenceException;
    public ArrayList<Equipo> getEquipos()throws PersistenceException;
}