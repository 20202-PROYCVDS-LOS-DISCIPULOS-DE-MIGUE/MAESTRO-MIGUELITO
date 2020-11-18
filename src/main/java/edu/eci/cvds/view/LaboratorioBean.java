package edu.eci.cvds.view;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.services.LaboratorioServicios;
import edu.eci.cvds.samples.services.ServiciosFactory;
import org.primefaces.PrimeFaces;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
@ManagedBean(name="laboratorioBean")
@SessionScoped
public class LaboratorioBean {
	//@Inject
    //private LaboratorioServicios laboratorioServicios;
	LaboratorioServicios laboratorioServicios= ServiciosFactory.getInstance().getLaboratorioServicios();
	private int id;
    private String nombre;
    private String horario;
    private String descripcion;
    private ArrayList<Laboratorio>laboratorios=new ArrayList<Laboratorio>();
    
    
    public LaboratorioServicios getElementoServices(){
        return laboratorioServicios;
    }

    public void setElementoServices(LaboratorioServicios laboratorioServicios){
        this.laboratorioServicios=laboratorioServicios;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void registrarLaboratorio()throws PersistenceException{
        try{
            laboratorioServicios.registrarLaboratorio(nombre,horario,descripcion);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Laboratorio registrado"));
            PrimeFaces current = PrimeFaces.current();
            current.executeScript("PF('dlg2').hide();");
        }catch (PersistenceException ex){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error registrando laboratorio","Error"));
            throw ex;
        }
    }
    public ArrayList<Laboratorio> todosLaboratorios() throws PersistenceException {
        laboratorios=laboratorioServicios.getLaboratorios();
        return laboratorioServicios.getLaboratorios();
    }
}
