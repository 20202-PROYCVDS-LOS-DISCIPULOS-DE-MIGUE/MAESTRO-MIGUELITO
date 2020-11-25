package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.EquipoMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;

import java.util.ArrayList;

public class MyBatisEquipoDAO implements EquipoDAO {

    @Inject
    private EquipoMapper equipoMapper;

    public EquipoMapper getEquipoMapper() {
        return equipoMapper;
    }

    public void setEquipoMapper(EquipoMapper equipoMapper) {
        this.equipoMapper = equipoMapper;
    }

    @Override
    public Equipo getEquipo(int idequipo) throws PersistenceException {
        try{
            return equipoMapper.getEquipo(idequipo);
        }catch (Exception e){
            throw new PersistenceException("Error consultando equipo",e);
        }
    }
    public void registrarEquipo(String ip,String informacion,boolean activo,int laboratorio) throws PersistenceException{
        try{
            equipoMapper.registrarEquipo(ip,informacion,activo,laboratorio);
        }catch (Exception e){
            throw new PersistenceException("Error insertando equipo",e);
        }
   }
   public ArrayList<Equipo> getEquipos()throws PersistenceException{
        try{
            return equipoMapper.getEquipos();
        }catch (Exception e){
            throw new PersistenceException("Error consultando equipos",e);
        }
   }
}