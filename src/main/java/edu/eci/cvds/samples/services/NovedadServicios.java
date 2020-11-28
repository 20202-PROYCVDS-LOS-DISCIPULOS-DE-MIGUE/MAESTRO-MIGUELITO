package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;
import java.time.LocalDate;
import java.util.ArrayList;

public interface NovedadServicios{

    public void registrarNovedad(LocalDate fecha,String titulo,String detalle,String responsable,int registro) throws PersistenceException;
    public ArrayList<Novedad> getNovedades()throws PersistenceException;
}
