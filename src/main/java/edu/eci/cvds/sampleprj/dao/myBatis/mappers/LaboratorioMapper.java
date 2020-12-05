package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import edu.eci.cvds.samples.entities.Laboratorio;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.ArrayList;


public interface LaboratorioMapper {
	public Laboratorio getLaboratorio(@Param("idLaboratorio")int idlaboratorio);
	public void registrarLaboratorio(@Param("nombre")String nombre,@Param("fechaRegistro")LocalDate fechaRegistro);
	public void cerrarLaboratorio(@Param("idLaboratorio")int idLaboratorio,@Param("fechaCierre")LocalDate fechaCierre);
	public ArrayList<Laboratorio>getLaboratorios();
}
