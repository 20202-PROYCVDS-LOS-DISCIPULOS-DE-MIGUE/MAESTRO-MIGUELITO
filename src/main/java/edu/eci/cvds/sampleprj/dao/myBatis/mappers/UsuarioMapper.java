package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import edu.eci.cvds.samples.entities.Usuario;

import org.apache.ibatis.annotations.Param;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface UsuarioMapper {

    //public List<Usuarii>getUsers();

    public Usuario getUser(@Param("documento")String documento);
}
