package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.LaboratorioDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.LaboratorioMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Laboratorio;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class MyBatisLaboratorioDAO implements LaboratorioDAO{

    @Inject
    private LaboratorioMapper laboratorioMapper;

    public LaboratorioMapper getLaboratoriosMapper() {

        return laboratorioMapper;
    }

    public void setLaboratoriosMapper(LaboratorioMapper laboratorioMapper) {
        this.laboratorioMapper = laboratorioMapper;
    }
    
    @Override
    public Laboratorio getLaboratorio(int id) throws PersistenceException {
        try{
            return laboratorioMapper.getLaboratorio(id);
        }catch (Exception e){
            throw new PersistenceException("Error consultando laboratorios",e);
        }
    }
    
    @Override
    public void registrarLaboratorio(String nombre,String horario,String descripcion) throws PersistenceException{
        try{
            laboratorioMapper.registrarLaboratorio(nombre,horario,descripcion);
        }catch (Exception e){
            throw new PersistenceException("Error insertando laboratorio",e);
        }
    }
    
    @Override
    public ArrayList<Laboratorio>getLaboratorios()throws PersistenceException{
        try{
            return laboratorioMapper.getLaboratorios();
        }catch (Exception e){
            throw new PersistenceException("Error consultando laboratorios",e);
        }
    }
}