package edu.eci.cvds.view;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.services.LaboratorioServicios;
import edu.eci.cvds.view.EquipoBean;
import edu.eci.cvds.samples.services.ServiciosFactory;
import org.primefaces.PrimeFaces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

@SuppressWarnings("deprecation")
@ManagedBean(name="laboratorioBean")
@SessionScoped

public class LaboratorioBean {
	//@Inject
    //private LaboratorioServicios laboratorioServicios;
	private LaboratorioServicios laboratorioServicios= ServiciosFactory.getInstance().getLaboratorioServicios();
    private ArrayList<Laboratorio>laboratorios=new ArrayList<Laboratorio>();
    private Laboratorio selectLaboratorio;
	private ArrayList<Equipo> equipos;
	private EquipoBean equipoBean;
    
	
    public LaboratorioServicios getElementoServices(){
        return laboratorioServicios;
    }

    public void setLaboratorioServices(LaboratorioServicios laboratorioServicios){
        this.laboratorioServicios=laboratorioServicios;
    }
	
	public void setSelectLaboratorio(Laboratorio selectLaboratorio){
		this.selectLaboratorio = selectLaboratorio;
	}
	
	public Laboratorio getSelectLaboratorio(){
		return selectLaboratorio;
	}
    
    public void registrarLaboratorio(String nombre)throws PersistenceException{
        try{
            laboratorioServicios.registrarLaboratorio(nombre);
            FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrar laboratorio", "Registro del laboratorio exitoso"));
        }catch (PersistenceException e){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrar laboratorio", "No se pudo registrar el laboratorio"));
        }
    }
    public ArrayList<Laboratorio> getLaboratorios() throws PersistenceException {
        laboratorios=laboratorioServicios.getLaboratorios();
        return laboratorios;
    }

	public void setLaboratorios(ArrayList<Laboratorio>laboratorios){
        this.laboratorios=laboratorios;
    }
	
	public void cerrarLaboratorio(int idLaboratorio) throws PersistenceException
	{	
		try{
			laboratorioServicios.cerrarLaboratorio(idLaboratorio);
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cerrar laboratorio", "laboratorio cerrado  con éxito"));
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cerrar laboratorio", "No se pudo cerrar el laboratorio"));
		}
	}
	
	
	
}
