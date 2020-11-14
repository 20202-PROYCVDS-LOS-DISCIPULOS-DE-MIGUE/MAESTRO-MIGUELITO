/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;


import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.EquipoMapper;
import edu.eci.cvds.exceptions.PersistenceException;


/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class MyBatisEquipoDAO implements EquipoDAO
{
	@Inject
    private EquipoMapper equipoMapper;
	

	@Override
    public void añadirEquipo(Equipo equipo) throws PersistenceException {
        try{
            equipoMapper.añadirEquipo(equipo);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error Adicionando Equipo",e);
        }
    }
    
}
