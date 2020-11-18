package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import edu.eci.cvds.samples.entities.Equipo;

import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface EquipoMapper {
    public void registrarEquipo(@Param("nombre")String nombre,@Param("estado")String estado,@Param("enUso")String enUso,@Param("idLaboratorio")int idLaboratorio);

    public Equipo getEquipo(int id);
    public ArrayList<Equipo> getEquipos();
}
