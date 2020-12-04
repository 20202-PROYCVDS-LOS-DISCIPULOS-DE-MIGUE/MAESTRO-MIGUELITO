package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.ElementoMapper;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import java.util.ArrayList;

public class MyBatisElementoDAO implements ElementoDAO {

    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public Elemento getElemento(int idElemento) throws PersistenceException {
        try{
            return elementoMapper.getElemento(idElemento);
        }catch (Exception e){
            throw new PersistenceException("Error consultando elemento",e);
        }
    }
	@Override
    public void registrarElemento(String tipo,String marca,boolean activo) throws PersistenceException{
        try{
            elementoMapper.registrarElemento(tipo,marca,activo);
        }catch (Exception e){
            throw new PersistenceException("Error registrando elemento",e);
        }
   }
   @Override
   public ArrayList<Elemento> getElementos()throws PersistenceException{
        try{
            return elementoMapper.getElementos();
        }catch (Exception e){
            throw new PersistenceException("Error consultando elementos",e);
        }
   }
}
