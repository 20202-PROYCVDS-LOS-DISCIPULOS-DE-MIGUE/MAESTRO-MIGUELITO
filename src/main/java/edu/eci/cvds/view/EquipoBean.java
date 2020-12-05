package edu.eci.cvds.view;


import com.google.inject.Inject;
import edu.eci.cvds.view.ElementoBean;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.services.ElementoServicios;
import edu.eci.cvds.samples.services.EquipoServicios;
import edu.eci.cvds.samples.services.ServiciosFactory;
import org.primefaces.PrimeFaces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

@SuppressWarnings("deprecation")
@ManagedBean(name="equipoBean")
@SessionScoped
public class EquipoBean {
    //@Inject
    //private EquipoServicios equipoServicios;
    private EquipoServicios equipoServicios = ServiciosFactory.getInstance().getEquipoServicios();
    private Equipo equipo;
    private ArrayList<Equipo>equipos;
	private ArrayList<Equipo>equiposDisponibles;

    public EquipoServicios getEquipoServices(){
        return equipoServicios;
    }

    public void setEquipoServices(EquipoServicios equiposServicios){
        this.equipoServicios=equipoServicios;
    }

    public void registrarEquipo(String ip,String informacion)throws PersistenceException{
        try{
			equipoServicios.registrarEquipo(ip,informacion);
            FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrar equipo", "Registro del equipo exitoso"));
        }catch (PersistenceException ex){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrar equipo", "No se pudo registrar el equipo"));
        }
    }
    public ArrayList<Equipo> getEquipos()throws PersistenceException {
		try{
			equipos = equipoServicios.getEquipos();
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar equipos", "No se pudo consultar los equipos"));
		}
		return equipos;
    }
	
	public ArrayList<Equipo> getEquiposDisponibles()throws PersistenceException {
		try{
			equiposDisponibles = equipoServicios.getEquiposDisponibles();
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar equipos", "No se pudo consultar los equipos"));
		}
		return equiposDisponibles;
    }
 
	public Equipo getEquipo(int idEquipo) throws PersistenceException
	{	
		try{
			equipo = equipoServicios.getEquipo(idEquipo);
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar equipo", "No se pudo consular el equipo"));
		}
		return equipo;
	}
}







