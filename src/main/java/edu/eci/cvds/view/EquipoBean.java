package edu.eci.cvds.view;


import com.google.inject.Inject;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Equipo;
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
    private int idEquipo;
    private String ip;
    private String informacion;
    private boolean activo;
    private int laboratorio;
    private ArrayList<Equipo>equipos;

    public EquipoServicios getEquipoServices(){
        return equipoServicios;
    }

    public void setEquipoServices(EquipoServicios equiposServicios){
        this.equipoServicios=equipoServicios;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip){
        this.ip = ip;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(int laboratorio) {
        this.laboratorio = laboratorio;
    }
    public void registrarEquipo(String ip,String informacion,boolean activo)throws PersistenceException{
        try{
			equipoServicios.registrarEquipo(ip,informacion,activo);
            FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrar equipo", "Registro del equipo exitoso"));
        }catch (PersistenceException ex){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrar equipo", "No se pudo registrar el equipo"));
        }
    }
    public ArrayList<Equipo> getEquipos()throws PersistenceException{
        ArrayList<Equipo>equipos=equipoServicios.getEquipos();
        return equipoServicios.getEquipos();
    }
	public void setEquipos(ArrayList<Equipo>equipos){
        this.equipos=equipos;
    }
	
}







