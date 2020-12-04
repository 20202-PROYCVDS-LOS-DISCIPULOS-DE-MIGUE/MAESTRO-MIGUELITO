package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import edu.eci.cvds.samples.entities.Equipo;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

public interface EquipoMapper {
    public void registrarEquipo(@Param("ip")String ip,@Param("informacion")String informacion,@Param("activo")boolean activo);
    public Equipo getEquipo(int idEquipo);
    public ArrayList<Equipo> getEquipos();
}
