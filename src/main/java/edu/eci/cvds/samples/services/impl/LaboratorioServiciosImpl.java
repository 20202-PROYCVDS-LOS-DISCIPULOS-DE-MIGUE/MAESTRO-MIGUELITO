package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.LaboratorioDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.services.LaboratorioServicios;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class LaboratorioServiciosImpl implements LaboratorioServicios{
	@Inject
    private LaboratorioDAO laboratorioDAO;


	@Override
	public void registrarLaboratorio(String nombre, String horario, String descripcion) throws PersistenceException {
		if(nombre==null){
			throw new PersistenceException("laboratorio incorrecto");
		}else{
			laboratorioDAO.registrarLaboratorio(nombre,horario,descripcion);
		}
	}

	@Override
	public Laboratorio getLaboratorio(int id) throws PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Laboratorio> getLaboratorios() throws PersistenceException {
		return laboratorioDAO.getLaboratorios();
	}


}
