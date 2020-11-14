/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Laboratorio;

import java.util.List;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public interface LaboratorioDAO 
{
    public void guardarLaboratorio (Laboratorio laboratorio) throws PersistenceException;
    
    public Laboratorio cargarLaboratorio (int idLaboratorio) throws PersistenceException;
    
    public List<Laboratorio> consultarLaboratorio () throws PersistenceException;
}
