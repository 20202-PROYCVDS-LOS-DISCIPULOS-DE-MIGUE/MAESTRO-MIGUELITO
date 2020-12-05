package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;
import java.util.ArrayList;

public interface EquipoServicios {
    public void registrarEquipo(String ip ,String informacion)throws PersistenceException;
    public Equipo getEquipo(int idEquipo)throws PersistenceException;
	public ArrayList<Equipo> getEquiposAsociados(int idLaboratorio)throws PersistenceException;
    public ArrayList<Equipo> getEquipos()throws PersistenceException;
	public ArrayList<Equipo> getEquiposDisponibles()throws PersistenceException;
	public void asociarEquipo(int idEquipo, int laboratorio) throws PersistenceException;
	public void desasociarEquipo(int idEquipoo) throws PersistenceException;
	public void darDeBajaEquipo(int idEquipo)throws PersistenceException;
}