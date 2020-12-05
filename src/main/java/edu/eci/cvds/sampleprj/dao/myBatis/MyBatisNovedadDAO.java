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
        return novedadMapper.getNovedad(idNovedad);
    }
	@Override
    public void registrarNovedad(String titulo,String detalle,String responsable,int equipo,int elemento,int laboratorio) throws PersistenceException{
        try{
            LocalDate fecha=LocalDate.now();
            novedadMapper.registrarNovedad(fecha,titulo,detalle,responsable,equipo,elemento,laboratorio);
        }catch (Exception e){
            throw new PersistenceException("Error insertando Novedad",e);
        }
    }

	@Override
    public ArrayList<Novedad> getNovedades() throws PersistenceException{
		return novedadMapper.getNovedades();
    }
}
