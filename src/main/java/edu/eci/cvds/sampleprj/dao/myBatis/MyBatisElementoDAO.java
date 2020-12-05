package edu.eci.cvds.sampleprj.dao.myBatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.mappers.ElementoMapper;
import edu.eci.cvds.samples.entities.Elemento;
<<<<<<< HEAD
=======

>>>>>>> 52237dc0af5f18e942d3d191081de6417965e8fa
import java.util.ArrayList;

public class MyBatisElementoDAO implements ElementoDAO {

    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public Elemento getElemento (int idElemento){
        return elementoMapper.getElemento(idElemento);
    }
    
    @Override
    public void registrarElemento (String tipo, String marca) {
        elementoMapper.registrarElemento(tipo,marca);
    }
    
    @Override
    public ArrayList<Elemento> getElementos () {
        return elementoMapper.getElementos();
    }
	
    @Override
    public ArrayList<Elemento> getElementosDisponibles () {
        return elementoMapper.getElementosDisponibles();
<<<<<<< HEAD
	}
	
	@Override
	public void asociarElemento(int idElemento,int equipo){
		elementoMapper.asociarElemento(idElemento,equipo);
	}
	
	@Override
	public void darDeBajaElemento(int idElemento){
		elementoMapper.darDeBajaElemento(idElemento);
	}
	
=======
    }
    
    @Override
    public void eliminarElemento (int idElemento, String marca) {
	elementoMapper.eliminarElemento(idElemento, marca);
    }
>>>>>>> 52237dc0af5f18e942d3d191081de6417965e8fa
}
