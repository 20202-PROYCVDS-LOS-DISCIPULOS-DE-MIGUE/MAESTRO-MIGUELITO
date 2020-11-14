/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.sampleprj.dao.myBatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Laboratorio;

import java.util.List;

/**
 *
 * @author M.A.R.S
 */
public interface LaboratorioMapper 
{
    public Laboratorio guardarLaboratorio (@Param("Laboratory") Laboratorio laboratorio);
    
    public Laboratorio cargarLaboratorio (@Param("idLaboratorio") int idLaboratorio);
    
    public List<Laboratorio> consultarLaboratorios();
}
