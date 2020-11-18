package edu.eci.cvds.samples.services;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Laboratorio;
import java.sql.Time;
import java.util.ArrayList;

public interface LaboratorioServicios {
    public void registrarLaboratorio(String nombre,String informacion)throws PersistenceException;
    public Laboratorio getLaboratorio(int idLaboratorio)throws PersistenceException;
    public ArrayList<Laboratorio> getLaboratorios()throws PersistenceException;


	
}