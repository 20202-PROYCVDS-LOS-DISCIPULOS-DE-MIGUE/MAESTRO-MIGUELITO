package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.ElementoMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;

import java.sql.Time;
import java.util.ArrayList;

public class MyBatisElementoDAO implements ElementoDAO {

    @Inject
    private ElementoMapper elementoMapper;

    public ElementoMapper getElementoMapper() {
        return elementoMapper;
    }

    public void setElementoMapper(ElementoMapper elementoMapper) {
        this.elementoMapper = elementoMapper;
    }

    @Override
    public Elemento getElemento(int idElemento) throws PersistenceException {
        try{
            return elementoMapper.getElemento(idElemento);
        }catch (Exception e){
            throw new PersistenceException("Error consultando elemento",e);
        }
    }
    public void registrarElemento(String tipo,String marca,boolean activo,int equipo) throws PersistenceException{
        try{
            elementoMapper.registrarElemento(tipo,marca,activo,equipo);
        }catch (Exception e){
            throw new PersistenceException("Error insertando elemento",e);
        }
    }
    public ArrayList<Elemento>getElementos()throws PersistenceException{
        try{
            return elementoMapper.getElementos();
        }catch (Exception e){
            throw new PersistenceException("Error consultando elementos",e);
        }
    }public void editElemento(int idElemento,int equipo) throws PersistenceException {
        try{
            elementoMapper.editElemento(idElemento,equipo);
        }catch (Exception e){
            throw new PersistenceException("Error en la asociacion",e);
        }
    }
}
