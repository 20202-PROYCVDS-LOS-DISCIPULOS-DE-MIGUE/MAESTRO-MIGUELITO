package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import edu.eci.cvds.samples.entities.Equipo;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

public interface EquipoMapper {
    public void registrarEquipo(@Param("ip")String ip,@Param("informacion")String informacion);
	public void asociarEquipo(@Param("idEquipo")int idEquipo,@Param("laboratorio")int laboratorio);
	public void desasociarEquipo(@Param("idEquipo")int idEquipo);
	public void darDeBajaEquipo(@Param("idEquipo")int idEquipo);
    public Equipo getEquipo(int idEquipo);
    public ArrayList<Equipo> getEquipos();
	public ArrayList<Equipo> getEquiposAsociados(@Param("idLaboratorio")int idLaboratorio);
	public ArrayList<Equipo> getEquiposDisponibles();
}
