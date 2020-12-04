package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;
import java.util.ArrayList;

public interface EquipoDAO{

    public Equipo getEquipo(int idEquipo) throws PersistenceException;
	public void registrarEquipo(String ip, String informacion, boolean activo, int laboratorio) throws PersistenceException;
    public ArrayList<Equipo> getEquipos()throws PersistenceException;
}
