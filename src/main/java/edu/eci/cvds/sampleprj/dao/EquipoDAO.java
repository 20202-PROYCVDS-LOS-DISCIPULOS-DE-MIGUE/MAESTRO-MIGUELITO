package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;
import java.util.ArrayList;

public interface EquipoDAO{

    public Equipo getEquipo(int idEquipo);
	public void registrarEquipo(String ip, String informacion);
    public ArrayList<Equipo> getEquipos();
}
