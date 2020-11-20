package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;
import java.time.LocalDate;
import java.util.ArrayList;

public interface NovedadDAO{
    public Novedad getNovedad(int id) throws PersistenceException;
    public void registrarNovedad(String descripcion, String estado, String tipo, int idElemento)throws PersistenceException;
    public ArrayList<Novedad> getNovedades();
}
