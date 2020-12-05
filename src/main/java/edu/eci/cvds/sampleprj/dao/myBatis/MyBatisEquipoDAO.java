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
    @Override
    public ArrayList<Equipo> getEquipos(){
		return equipoMapper.getEquipos();
    }
	@Override
    public ArrayList<Equipo> getEquiposAsociados(int idLaboratorio){
		return equipoMapper.getEquiposAsociados(idLaboratorio);
    }
    @Override
    public ArrayList<Equipo> getEquiposDisponibles(){
		return equipoMapper.getEquiposDisponibles();
    }
   
    @Override
	public void asociarEquipo(int idEquipo,int laboratorio){
		equipoMapper.asociarEquipo(idEquipo,laboratorio);
	}
	
	@Override
	public void desasociarEquipo(int idEquipo){
		equipoMapper.desasociarEquipo(idEquipo);
	}
	
	@Override
	public void darDeBajaEquipo(int idEquipo){
		equipoMapper.darDeBajaEquipo(idEquipo);
	}
}