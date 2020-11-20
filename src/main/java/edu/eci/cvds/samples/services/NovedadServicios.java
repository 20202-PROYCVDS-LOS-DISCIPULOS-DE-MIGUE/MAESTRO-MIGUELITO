package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;
import java.time.LocalDate;
import java.util.ArrayList;

public interface NovedadServicios{

    public default void registrarNovedad(String descripcion, String estado, String tipo, int idElemento) throws PersistenceException {
    }
    public ArrayList<Novedad> getNovedades()throws PersistenceException;
}
