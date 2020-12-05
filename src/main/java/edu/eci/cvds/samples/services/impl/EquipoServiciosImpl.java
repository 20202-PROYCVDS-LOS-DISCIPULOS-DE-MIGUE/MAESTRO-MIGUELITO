package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.EquipoServicios;

import java.util.ArrayList;

public class EquipoServiciosImpl implements EquipoServicios {
    @Inject
    private EquipoDAO equipoDAO;

    @Override
    public void registrarEquipo(String ip, String informacion) throws PersistenceException {
        equipoDAO.registrarEquipo(ip, informacion);
    }

    @Override
    public Equipo getEquipo(int idEquipo) throws PersistenceException {
        return equipoDAO.getEquipo(idEquipo);
    }

    @Override
    public ArrayList<Equipo>getEquipos()throws PersistenceException{
        return equipoDAO.getEquipos();
    }
	
	@Override
    public ArrayList<Equipo> getEquiposDisponibles()throws PersistenceException{
        return equipoDAO.getEquiposDisponibles();
    }
	
	@Override
    public ArrayList<Equipo> getEquiposAsociados(int idLaboratorio)throws PersistenceException{
        return equipoDAO.getEquiposAsociados(idLaboratorio);
    }
	
	@Override
	public void desasociarEquipo(int idEquipo) throws PersistenceException{
		equipoDAO.desasociarEquipo(idEquipo);
	}
	
	@Override
	public void asociarEquipo(int idEquipo, int laboratorio) throws PersistenceException{
		equipoDAO.asociarEquipo(idEquipo,laboratorio);
	}
	
	@Override
	public void darDeBajaEquipo(int idEquipo) throws PersistenceException{
		equipoDAO.darDeBajaEquipo(idEquipo);
	}

}