package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;
import edu.eci.cvds.samples.services.NovedadServicios;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class NovedadServiciosImpl implements NovedadServicios {
    @Inject
    private NovedadDAO novedadDAO;
    @Override
    public void registrarNovedad(String descripcion, String estado, String tipo, int idElemento) throws PersistenceException {
        if(descripcion==null){
            throw new PersistenceException(("novedad incorrecta"));
        }else{
            novedadDAO.registrarNovedad(descripcion,estado,tipo,idElemento);
        }
    }

    @Override
    public ArrayList<Novedad> getNovedades() throws PersistenceException {
        return novedadDAO.getNovedades();
    }
}
