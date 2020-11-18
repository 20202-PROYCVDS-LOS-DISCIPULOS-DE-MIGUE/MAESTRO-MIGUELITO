package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.ElementoMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;

import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
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
    public Elemento getElemento(int id) throws PersistenceException {
        try{
            return elementoMapper.getElemento(id);
        }catch (Exception e){
            throw new PersistenceException("Error consultando elemento",e);
        }
    }
    
    @Override
    public void registrarElemento(String nombre,String marca,String modelo,String caracteristicas,int idEquipo) throws PersistenceException{
        try{
            elementoMapper.registrarElemento(nombre,marca,modelo,caracteristicas,idEquipo);
        }catch (Exception e){
            throw new PersistenceException("Error insertando elemento",e);
        }
    }
    
    @Override
    public ArrayList<Elemento>getElementos()throws PersistenceException{
        try{
            return elementoMapper.getElementos();
        }catch (Exception e){
            throw new PersistenceException("Error consultando elementos",e);
        }
        
    }
    
    @Override
    public void editElemento(int id,int idEquipo) throws PersistenceException {
        try{
            elementoMapper.editElemento(id,idEquipo);
        }catch (Exception e){
            throw new PersistenceException("Error en la asociacion",e);
        }
    }
}
