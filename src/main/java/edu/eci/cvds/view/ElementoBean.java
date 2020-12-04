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

@SuppressWarnings("deprecation")
@ManagedBean(name="elementoBean")
@SessionScoped
public class ElementoBean {
    //@Inject
    //private ElementoServicios elementoServicios;
    private ElementoServicios elementoServicios = ServiciosFactory.getInstance().getElementoServicios();
    private int idElemento;
    private String tipo;
    private String marca;
    private boolean activo;
    private int equipo;
    private ArrayList<Elemento>elementos= new ArrayList<Elemento>();

    public ElementoServicios getElementoServices(){
        return elementoServicios;
    }

    public void setElementoServices(ElementoServicios elementoServicios){
        this.elementoServicios=elementoServicios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    public int getEquipo() {
        return equipo;
    }

    public void setEquipo(int equipo) {
        this.equipo = equipo;
    }

	public void registrarElemento(String tipo,String marca,boolean activo)throws PersistenceException{
        try{
			elementoServicios.registrarElemento(tipo,marca,activo);
            FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrar elemento", "Registro del elemento exitoso"));
        }catch (PersistenceException ex){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrar equipo", "No se pudo registrar el elemento"));
        }
    }
    public ArrayList<Elemento> getElementos()throws PersistenceException{
		try{
			ArrayList<Elemento> elementos = elementoServicios.getElementos();
		}catch(PersistenceException ex){
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Consultar equipo", "No se pudo consultar el elemento"));
		}
        return elementoServicios.getElementos();
    }
	public void setElementos(ArrayList<Elemento> elementos){
        this.elementos=elementos;
    }
}
