package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.services.ElementoServicios;
import edu.eci.cvds.samples.services.ServiciosFactory;
import org.primefaces.PrimeFaces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.sql.Time;
import java.util.ArrayList;

@SuppressWarnings("deprecation")
@ManagedBean(name="elementoBean")
@SessionScoped
public class ElementoBean {
    //@Inject
    //private ElementoServicios elementoServicios;
    private ElementoServicios elementoServicios = ServiciosFactory.getInstance().getElementoServicios();
    private ArrayList<Elemento>elementos= new ArrayList<Elemento>();
	private ArrayList<Elemento>elementosDisponibles = new ArrayList<Elemento>();
	private Elemento elemento;
	
    public ElementoServicios getElementoServices(){
        return elementoServicios;
    }

    public void setElementoServices(ElementoServicios elementoServicios){
        this.elementoServicios=elementoServicios;
    }

    
    public void registrarElemento(String tipo,String marca)throws PersistenceException{
        try{
            elementoServicios.registrarElemento(tipo,marca);
            FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrar elemento", "Registro del elemento exitoso"));
        }catch (PersistenceException ex){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrar elemento", "No se pudo registrar el elemento"));
        }
    }
    public ArrayList<Elemento> getElementos()throws PersistenceException {
		try{
			elementos = elementoServicios.getElementos();
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar elemento", "No se pudo consultar el elemento"));
		}
		return elementos;
    }
	
	public ArrayList<Elemento> getElementosDisponibles()throws PersistenceException {
		try{
			elementosDisponibles = elementoServicios.getElementosDisponibles();
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar elemento", "No se pudo consultar el elemento"));
		}
		return elementosDisponibles;
    }
 
	public Elemento getElemento(int idElemento) throws PersistenceException
	{	
		try{
			elemento = elementoServicios.getElemento(idElemento);
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar equipo", "No se pudo consular el elemento"));
		}
		return elemento;
	}
}
