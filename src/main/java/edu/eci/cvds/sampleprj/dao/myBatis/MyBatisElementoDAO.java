/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.ElementoMapper;
import edu.eci.cvds.exceptions.PersistenceException;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class MyBatisElementoDAO implements ElementoDAO
{
    @Inject
    private ElementoMapper ElementoMapper;
	
    @Override
    public void añadirElemento(Elemento elemento) throws PersistenceException 
    {
        try {
            
            ElementoMapper.añadirElemento(elemento);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error añadiendo elemento.", e); 
		}
    }
    
}
