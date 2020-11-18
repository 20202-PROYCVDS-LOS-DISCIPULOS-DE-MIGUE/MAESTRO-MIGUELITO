package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.EquipoMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
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
    public Equipo getEquipo(int id) throws PersistenceException {
        try{
            return equipoMapper.getEquipo(id);
        }catch (Exception e){
            throw new PersistenceException("Error consultando equipo",e);
        }
    }
    
    @Override
    public void registrarEquipo(String nombre,String estado,String enUso,int idLaboratorio) throws PersistenceException{
        try{
            equipoMapper.registrarEquipo(nombre,estado,enUso,idLaboratorio);
        }catch (Exception e){
            throw new PersistenceException("Error insertando equipo",e);
        }
   }
    
    @Override
    public ArrayList<Equipo> getEquipos()throws PersistenceException{
        try{
            return equipoMapper.getEquipos();
        }catch (Exception e){
            throw new PersistenceException("Error consultando equipos",e);
        }
   }
}