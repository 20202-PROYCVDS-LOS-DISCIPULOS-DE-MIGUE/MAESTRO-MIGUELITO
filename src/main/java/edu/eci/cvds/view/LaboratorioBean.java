package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.services.LaboratorioServicios;
import edu.eci.cvds.samples.services.ServiciosFactory;
import org.primefaces.PrimeFaces;
import sun.awt.Symbol;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.lang.reflect.Array;
import java.util.ArrayList;

@ManagedBean(name="laboratorioBean")
@SessionScoped

public class LaboratorioBean {
	//@Inject
    //private LaboratorioServicios laboratorioServicios;
	private LaboratorioServicios laboratorioServicios= ServiciosFactory.getInstance().getLaboratorioServicios();
	private int idLaboratorio;
    private String nombre;
    private String informacion;
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
    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }
    
    public String getinformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
    public void registrarLaboratorio()throws PersistenceException{
        try{
            laboratorioServicios.registrarLaboratorio(nombre,informacion);
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
