package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;
import java.sql.Time;
import java.util.ArrayList;

public interface EquipoServicios {
    public void registrarEquipo(String ip ,String informacion)throws PersistenceException;
    public Equipo getEquipo(int idEquipo)throws PersistenceException;
    public ArrayList<Equipo> getEquipos()throws PersistenceException;
}