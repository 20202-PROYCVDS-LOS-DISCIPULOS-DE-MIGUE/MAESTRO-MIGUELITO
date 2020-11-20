package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.EquipoServicios;

import java.util.ArrayList;

public class EquipoServiciosImpl implements EquipoServicios {
    @Inject
    private EquipoDAO equipoDAO;


    @Override
    public void registrarEquipo(String ip, String informacion, boolean activo, int laboratorio) throws PersistenceException {
        if(informacion==null){
            throw new PersistenceException("Equipo incorrecto");
        }else{
            equipoDAO.registrarEquipo(ip,informacion,activo,laboratorio);
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