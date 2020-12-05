package edu.eci.cvds.view;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Novedad;
import edu.eci.cvds.samples.services.EquipoServicios;
import edu.eci.cvds.samples.services.NovedadServicios;
import edu.eci.cvds.samples.services.ServiciosFactory;
import org.primefaces.PrimeFaces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.time.LocalDate;
import java.util.ArrayList;

@SuppressWarnings("deprecation")
@ManagedBean(name="novedadBean")
@SessionScoped

public class NovedadBean {
    //@Inject
    //private NovedadServicios novedadServicios;

    private NovedadServicios novedadServicios = ServiciosFactory.getInstance().getNovedadServicios();
	private ArrayList<Novedad>novedades=new ArrayList<Novedad>();
	private Novedad novedad;

	public void setNovedadServices(NovedadServicios novedadServicios){
        this.novedadServicios=novedadServicios;
    }


    public NovedadServicios getNovedadServices(){
        return novedadServicios;
    }

    public void registrarNovedad(String titulo,String detalle,String responsable,int equipo,int elemento,int laboratorio)throws PersistenceException{
        try{
			novedadServicios.registrarNovedad(titulo,detalle,responsable,equipo,elemento,laboratorio);
            FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrar novedad", "Registro de novedad exitoso"));
        }catch (PersistenceException ex){
             FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrar novedad", "No se pudo registrar la novedad"));
        }
    }
    public ArrayList<Novedad>getNovedades() throws PersistenceException {
        try{
			novedades = novedadServicios.getNovedades();
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar novedades", "No se pudo consultar las novedades"));
		}
		return novedades;
    }
	
	public Novedad getNovedad(int idNovedad) throws PersistenceException{	
		try
		{
			novedad = novedadServicios.getNovedad(idNovedad);
		} catch(PersistenceException e)
		{
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar novedad", "No se pudo consultar la novedad"));
		}
		return novedad;
	}
	
	public void setNovedades(ArrayList<Novedad>novedades){
        this.novedades=novedades;
    }

}
