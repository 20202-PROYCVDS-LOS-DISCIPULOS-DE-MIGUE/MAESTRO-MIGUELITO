package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface NovedadServicios{

    public default void registrarNovedad(String descripcion, String estado, String tipo, int idElemento) throws PersistenceException {
    }
    public ArrayList<Novedad> getNovedades()throws PersistenceException;
}
