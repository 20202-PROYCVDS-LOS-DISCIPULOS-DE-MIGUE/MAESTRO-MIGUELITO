package edu.eci.cvds.samples.services.impl;
 
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
import edu.eci.cvds.samples.services.ServiciosEquipo;


public class ServicesEquipoImpl implements ServiciosEquipo
{
    @Inject
    private  EquipoDAO equipoDAO;
	
	
    @Override
    public void añadirEquipo(Equipo equipo) throws PersistenceException 
    {
        try{
            equipoDAO.añadirEquipo(equipo);
        }catch (PersistenceException e){
            throw new PersistenceException("Error añadiendo equipo",e);
        }
    }

}