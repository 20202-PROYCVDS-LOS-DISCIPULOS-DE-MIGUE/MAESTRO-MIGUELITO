package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.LaboratorioDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.LaboratorioMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Laboratorio;
import org.mybatis.guice.transactional.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;

public class MyBatisLaboratorioDAO implements LaboratorioDAO{

    @Inject
    private LaboratorioMapper laboratorioMapper;

    @Override
    public Laboratorio getLaboratorio(int idlaboratorio) throws PersistenceException {
        return laboratorioMapper.getLaboratorio(idlaboratorio);
    }

    @Override
    public void registrarLaboratorio(String nombre) throws PersistenceException{
        try{
			LocalDate fechaRegistro = LocalDate.now();
            laboratorioMapper.registrarLaboratorio(nombre,fechaRegistro);
        }catch (Exception e){
            throw new PersistenceException("Error registrando laboratorio",e);
        }
    }

    @Override
    public ArrayList<Laboratorio>getLaboratorios()throws PersistenceException{
        return laboratorioMapper.getLaboratorios();
    }
	
	@Override
    public void cerrarLaboratorio(int idLaboratorio) throws PersistenceException{
        try{
			LocalDate fechaCierre = LocalDate.now();
            laboratorioMapper.cerrarLaboratorio(idLaboratorio,fechaCierre);
        }catch (Exception e){
            throw new PersistenceException("Error cerrando laboratorio",e);
        }
    }

}