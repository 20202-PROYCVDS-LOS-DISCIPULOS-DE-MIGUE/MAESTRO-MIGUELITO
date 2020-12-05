package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;
import edu.eci.cvds.samples.services.NovedadServicios;
import java.time.LocalDate;
import java.util.ArrayList;

public class NovedadServiciosImpl implements NovedadServicios {
    @Inject
    private NovedadDAO novedadDAO;
	
    @Override
    public void registrarNovedad(String titulo,String detalle,String responsable,int equipo,int elemento,int laboratorio) throws PersistenceException {
        novedadDAO.registrarNovedad(titulo,detalle,responsable,equipo,elemento,laboratorio);
    }

    @Override
    public ArrayList<Novedad> getNovedades() throws PersistenceException {
        return novedadDAO.getNovedades();
    }
	
	@Override
    public Novedad getNovedad(int idNovedad) throws PersistenceException {
        return novedadDAO.getNovedad(idNovedad);
    }
}
