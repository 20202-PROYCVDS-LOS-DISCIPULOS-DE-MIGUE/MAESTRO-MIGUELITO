package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Novedad;
import org.apache.ibatis.annotations.Param;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public interface NovedadMapper {
    public void registrarNovedad(@Param("fecha") LocalDate fecha, @Param("titulo")String titulo, @Param("detalle")String detalle, @Param("responsable")String responsable, @Param("equipo")int equipo, @Param("elemento")int elemento, @Param("laboratorio")int laboratorio);
    public Novedad getNovedad(int idNovedad);
    public ArrayList<Novedad> getNovedades();
}
