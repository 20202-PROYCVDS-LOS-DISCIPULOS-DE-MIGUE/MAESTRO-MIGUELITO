package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;
import java.time.LocalDate;
import java.util.ArrayList;

public interface NovedadDAO{
    public Novedad getNovedad(int idNovedad) throws PersistenceException;
    public void registrarNovedad(LocalDate fecha,String titulo,String detalle,String responsable,int registro)throws PersistenceException;
    public ArrayList<Novedad> getNovedades();
}
