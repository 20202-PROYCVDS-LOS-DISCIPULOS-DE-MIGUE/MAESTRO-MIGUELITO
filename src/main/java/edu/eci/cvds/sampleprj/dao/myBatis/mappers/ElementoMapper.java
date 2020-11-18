package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import edu.eci.cvds.samples.entities.Elemento;

import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface ElementoMapper {
    public void registrarElemento(@Param("nombre")String nombre,@Param("marca")String marca,@Param("modelo")String modelo,@Param("caracteristicas")String caracteristicas,@Param("idEquipo")int idEquipo);

    public Elemento getElemento(int id);

    public ArrayList<Elemento> getElementos();

    public void editElemento(@Param("id")int id,@Param("idequipo")int idequipo);
}
