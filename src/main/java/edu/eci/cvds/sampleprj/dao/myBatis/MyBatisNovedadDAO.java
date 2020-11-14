/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Novedad;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.NovedadMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import java.util.List;


/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class MyBatisNovedadDAO implements NovedadDAO
{
    @Inject
    private NovedadMapper novedadMapper;
	
    public List<Novedad> consultarNovedades() throws PersistenceException 
    {
        try {
            return novedadMapper.consultarNovedades();
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error consultando novedades", e);
        }
    }
	
	@Override
    public void añadirNovedad(Novedad novedad) throws PersistenceException {
        try{
            novedadMapper.añadirNovedad(novedad);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error añadiendo Novedad",e);
        }
    }
    
}
