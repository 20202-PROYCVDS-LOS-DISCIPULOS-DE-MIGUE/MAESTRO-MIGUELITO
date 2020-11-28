package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.LaboratorioDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.LaboratorioMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Laboratorio;
import org.mybatis.guice.transactional.Transactional;

import java.util.ArrayList;

public class MyBatisLaboratorioDAO implements LaboratorioDAO{

    @Inject
    private LaboratorioMapper laboratorioMapper;

    @Override
    public Laboratorio getLaboratorio(int idlaboratorio) throws PersistenceException {
        try{
            return laboratorioMapper.getLaboratorio(idlaboratorio);
        }catch (Exception e){
            throw new PersistenceException("Error consultando laboratorios",e);
        }
    }

    @Override
    public void registrarLaboratorio(String nombre,String informacion) throws PersistenceException{
        try{
            laboratorioMapper.registrarLaboratorio(nombre,informacion);
        }catch (Exception e){
            throw new PersistenceException("Error registrando laboratorio",e);
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