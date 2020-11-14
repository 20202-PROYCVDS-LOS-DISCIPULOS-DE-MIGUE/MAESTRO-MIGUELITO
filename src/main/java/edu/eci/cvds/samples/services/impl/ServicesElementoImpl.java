package edu.eci.cvds.samples.services.impl;
 
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.samples.services.ServiciosElemento;


public class ServicesElementoImpl implements ServiciosElemento
{
    @Inject
    private  ElementoDAO elementoDAO;
	
    @Override
    public void añadirElemento(Elemento elemento) throws PersistenceException {
        try{
            elementoDAO.añadirElemento(elemento);
        }catch (PersistenceException e){
            throw new PersistenceException("Error añadiendo el elemento",e);
        }
    }
}