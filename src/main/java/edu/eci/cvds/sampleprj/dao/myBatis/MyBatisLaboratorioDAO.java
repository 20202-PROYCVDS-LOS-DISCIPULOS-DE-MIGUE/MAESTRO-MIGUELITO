/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.LaboratorioMapper;
import edu.eci.cvds.samples.entities.Laboratorio;

import java.util.List;

/**
 *
 * @author M.A.R.S
 */
public class MyBatisLaboratorioDAO 
{
    @Inject
    private LaboratorioMapper laboratoryMapper;
    
    public void guardarLaboratorio (Laboratorio laboratorio) throws PersistenceException 
    {
        try {
            laboratoryMapper.guardarLaboratorio(laboratorio);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error guardando cliente.", e); 
	}
    }
    
    public Laboratorio cargarLaboratorio (int idLaboratorio) throws PersistenceException 
    {
        try {
            return laboratoryMapper.cargarLaboratorio(idLaboratorio);
        }
        catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error consultando cliente.", e); 
	}
    }
    
    public List<Laboratorio> consultarLaboratorio() throws PersistenceException 
    {
        try {
            return laboratoryMapper.consultarLaboratorios();
        } 
        catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error consultando cliente ", e);
        }
    }
}
