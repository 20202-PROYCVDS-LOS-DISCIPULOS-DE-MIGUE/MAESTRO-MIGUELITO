package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.LaboratorioDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.services.LaboratorioServicios;
import java.util.ArrayList;

public class LaboratorioServiciosImpl implements LaboratorioServicios{
	@Inject
    private LaboratorioDAO laboratorioDAO;


	@Override
	public void registrarLaboratorio(String nombre, String informacion) throws PersistenceException {	
			laboratorioDAO.registrarLaboratorio(nombre,informacion);
		}


	@Override
	public Laboratorio getLaboratorio(int idlaboratorio) throws PersistenceException {
		return null;
	}

	@Override
	public ArrayList<Laboratorio> getLaboratorios() throws PersistenceException {
		return laboratorioDAO.getLaboratorios();
	}


}
