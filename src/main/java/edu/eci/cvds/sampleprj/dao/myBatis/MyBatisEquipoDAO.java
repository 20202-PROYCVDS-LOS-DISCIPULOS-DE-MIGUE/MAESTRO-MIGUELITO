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

    @Override
    public Equipo getEquipo(int idEquipo) throws PersistenceException {
        try{
            return equipoMapper.getEquipo(idEquipo);
        }catch (Exception e){
            throw new PersistenceException("Error consultando equipo",e);
        }
    }
	@Override
    public void registrarEquipo(String ip,String informacion,boolean activo) throws PersistenceException{
        try{
            equipoMapper.registrarEquipo(ip,informacion,activo);
        }catch (Exception e){
            throw new PersistenceException("Error registrando equipo",e);
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