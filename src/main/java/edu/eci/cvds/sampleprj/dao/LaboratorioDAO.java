package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Laboratorio;
import java.sql.Time;
import java.util.ArrayList;

public interface LaboratorioDAO {
    public void registrarLaboratorio (String nombre)throws PersistenceException;
	public Laboratorio getLaboratorio(int idlaboratorio) throws PersistenceException;
    public ArrayList<Laboratorio>getLaboratorios()throws PersistenceException;
	public void cerrarLaboratorio(int idLaboratorio)throws PersistenceException;
}
