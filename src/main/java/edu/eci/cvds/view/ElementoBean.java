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
import java.util.ArrayList;
import java.util.List;

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
	
	public void setElementos(ArrayList<Elemento> elementos)throws PersistenceException {
		this.elementos=elementos;
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
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar elemento", "No se pudo consular el elemento"));
		}
		return elemento;
	}
	
	public void asociarElemento(int idElemento, int equipo) throws PersistenceException
	{	
		try{
			elementoServicios.asociarElemento(idElemento,equipo);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asociar elemento", "elemento asociado  con éxito"));
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Asociar elemento", "No se pudo Asociar el elemento"));
		}
	}
	
	public void darDeBajaElemento(int idElemento) throws PersistenceException
	{	
		try{
			elementoServicios.darDeBajaElemento(idElemento);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "dar De Baja elemento", "elemento dado de baja  con éxito"));
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "dar De Baja elemento", "No se pudo dar de baja el elemento"));
		}
	}

}
