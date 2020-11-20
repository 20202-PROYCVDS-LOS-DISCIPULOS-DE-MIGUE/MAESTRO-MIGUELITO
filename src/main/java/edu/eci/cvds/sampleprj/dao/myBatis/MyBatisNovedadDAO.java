package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.NovedadDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.NovedadMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;

import java.time.LocalDate;
import java.util.ArrayList;

public class MyBatisNovedadDAO implements NovedadDAO{

    @Inject
    private NovedadMapper novedadMapper;

    public NovedadMapper getNovedadMapper() {

        return novedadMapper;
    }

    public void setNovedadMapper(NovedadMapper novedadMapper)
    {
        this.novedadMapper = novedadMapper;
    }

    @Override
    public Novedad getNovedad(int id) throws PersistenceException {
        try{
            return novedadMapper.getNovedad(id);
        }catch (Exception e){
            throw new PersistenceException("Error consultando novedad",e);
        }
    }
    public void registrarNovedad(String descripcion,String estado,String tipo,int idElemento) throws PersistenceException{
        try{
            LocalDate fecha=LocalDate.now();
            novedadMapper.registrarNovedad(fecha,descripcion,estado,tipo,idElemento);
        }catch (Exception e){
            throw new PersistenceException("Error insertando Novedad",e);
        }
    }

    @Override
    public ArrayList<Novedad> getNovedades() {
        return novedadMapper.getNovedades();
    }
}
