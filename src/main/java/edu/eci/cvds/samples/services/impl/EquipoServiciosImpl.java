package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.EquipoServicios;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class EquipoServiciosImpl implements EquipoServicios {
    @Inject
    private EquipoDAO equipoDAO;


    @Override
    public void registrarEquipo(String nombre, String estado, String enUso, int idLaboratorio) throws PersistenceException {
        if(estado==null){
            throw new PersistenceException("Equipo incorrecto");
        }else{
            equipoDAO.registrarEquipo(nombre,estado,enUso,idLaboratorio);
        }
    }

    @Override
    public Equipo getEquipo(int id) throws PersistenceException {
        return null;
    }

    public void imprimir(){
        System.out.println("imprimir");
    }

    @Override
    public ArrayList<Equipo>getEquipos()throws PersistenceException{
        return equipoDAO.getEquipos();

    }

}