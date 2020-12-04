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

    @Override
    public Elemento getElemento(int idElemento){
        return elementoMapper.getElemento(idElemento);
    }
	@Override
    public void registrarElemento(String tipo,String marca){
        elementoMapper.registrarElemento(tipo,marca);
    }
	@Override
    public ArrayList<Elemento>getElementos(){
        return elementoMapper.getElementos();
	}
 
}
