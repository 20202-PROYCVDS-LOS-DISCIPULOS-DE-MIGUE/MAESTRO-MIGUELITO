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
    public Equipo getEquipo(int idEquipo){
        return equipoMapper.getEquipo(idEquipo);
    }
    public void registrarEquipo(String ip,String informacion){
        equipoMapper.registrarEquipo(ip,informacion);
   }
   public ArrayList<Equipo> getEquipos(){
        return equipoMapper.getEquipos();
   }
   public ArrayList<Equipo> getEquiposDisponibles(){
        return equipoMapper.getEquiposDisponibles();
   }
}