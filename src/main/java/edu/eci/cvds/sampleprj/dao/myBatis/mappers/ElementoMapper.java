package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import edu.eci.cvds.samples.entities.Elemento;
import org.apache.ibatis.annotations.Param;
import java.util.ArrayList;

public interface ElementoMapper {
    public void registrarElemento(@Param("tipo")String tipo,@Param("marca")String marca);
    public Elemento getElemento(@Param("idElemento")int idElemento);
    public ArrayList<Elemento> getElementos();

}
