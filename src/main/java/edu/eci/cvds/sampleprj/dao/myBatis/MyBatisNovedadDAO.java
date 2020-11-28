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

    @Override
    public Novedad getNovedad(int idNovedad) throws PersistenceException {
        try{
            return novedadMapper.getNovedad(idNovedad);
        }catch (Exception e){
            throw new PersistenceException("Error consultando novedad",e);
        }
    }
    public void registrarNovedad(LocalDate fecha,String titulo,String detalle,String responsable,int registro) throws PersistenceException{
        try{
            fecha=LocalDate.now();
            novedadMapper.registrarNovedad(fecha,titulo,detalle,responsable,registro);
        }catch (Exception e){
            throw new PersistenceException("Error insertando Novedad",e);
        }
    }

    @Override
    public ArrayList<Novedad> getNovedades() {
        return novedadMapper.getNovedades();
    }
}
