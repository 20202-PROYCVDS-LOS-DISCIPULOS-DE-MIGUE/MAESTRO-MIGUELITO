package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import edu.eci.cvds.samples.entities.Laboratorio;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;


public interface LaboratorioMapper {

	public Laboratorio getLaboratorio(int idLaboratorio);
	public void registrarLaboratorio(@Param("nombre")String nombre,@Param("informacion")String informacion);
	public ArrayList<Laboratorio>getLaboratorios();
}
