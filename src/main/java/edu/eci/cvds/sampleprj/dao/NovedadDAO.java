package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface NovedadDAO{
    public Novedad getNovedad(int id) throws PersistenceException;
    public void registrarNovedad(String descripcion, String estado, String tipo, int idElemento)throws PersistenceException;
    public ArrayList<Novedad> getNovedades();
}
