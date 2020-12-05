package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;
import java.util.ArrayList;

public interface NovedadServicios{

    public void registrarNovedad(String titulo,String detalle,String responsable,int equipo,int elemento,int laboratorio) throws PersistenceException;
    public ArrayList<Novedad> getNovedades()throws PersistenceException;
	public Novedad getNovedad(int idNovedad)throws PersistenceException;
}
