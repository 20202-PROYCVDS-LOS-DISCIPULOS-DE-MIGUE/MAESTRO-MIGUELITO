package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import edu.eci.cvds.samples.entities.Laboratorio;

import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface LaboratorioMapper {

	public Laboratorio getLaboratorio(int id);

	public void registrarLaboratorio(@Param("nombre")String nombre,@Param("horario")String horario,@Param("descripcion") String descripcion);
	public ArrayList<Laboratorio>getLaboratorios();
}
