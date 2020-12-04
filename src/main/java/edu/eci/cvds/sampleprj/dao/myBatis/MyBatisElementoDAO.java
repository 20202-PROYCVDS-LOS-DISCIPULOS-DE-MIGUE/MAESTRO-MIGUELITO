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
<<<<<<< HEAD
    public void registrarElemento(String tipo,String marca,boolean activo,int equipo) throws PersistenceException{
=======
    public void registrarElemento(String tipo,String marca,boolean activo) throws PersistenceException{
>>>>>>> e296ddd81abc651d7da6955803969628e607dedb
        try{
            elementoMapper.registrarElemento(tipo,marca,activo);
        }catch (Exception e){
            throw new PersistenceException("Error registrando elemento",e);
        }
<<<<<<< HEAD
    }
	@Override
    public ArrayList<Elemento>getElementos()throws PersistenceException{
=======
   }
   @Override
   public ArrayList<Elemento> getElementos()throws PersistenceException{
>>>>>>> e296ddd81abc651d7da6955803969628e607dedb
        try{
            return elementoMapper.getElementos();
        }catch (Exception e){
            throw new PersistenceException("Error consultando elementos",e);
        }
   }
}
