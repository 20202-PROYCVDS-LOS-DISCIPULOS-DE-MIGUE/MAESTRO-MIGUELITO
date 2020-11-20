package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Novedad;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public interface NovedadMapper {
    public void registrarNovedad(@Param("fecha") LocalDate fecha, @Param("descripcion")String descripcion, @Param("estado")String estado, @Param("tipo")String tipo, @Param("idElemento")int idElemento);

    public Novedad getNovedad(int id);

    public ArrayList<Novedad> getNovedades();
}
