package edu.eci.cvds.view;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Laboratorio;
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
    private int idNovedad;
    private LocalDate fecha=LocalDate.now();
    private String titulo;
    private String detalle;
    private String responsable;
    private int registro;
	private ArrayList<Novedad>novedades=new ArrayList<Novedad>();

	public void setNovedadServices(NovedadServicios novedadServicios){
        this.novedadServicios=novedadServicios;
    }


    public NovedadServicios getNovedadServices(){
        return novedadServicios;
    }

    public int getIdNovedad(){
        return idNovedad;
    }
    public void setIdNovedad(int idNovedad){
        this.idNovedad=idNovedad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public void registrarNovedad(LocalDate fecha,String titulo,String detalle,String responsable,int registro)throws PersistenceException{
        try{
			novedadServicios.registrarNovedad(fecha,titulo,detalle,responsable,registro);
            FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Registrar novedad", "Registro de novedad exitoso"));
        }catch (PersistenceException ex){
             FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Registrar novedad", "No se pudo registrar la novedad"));
        }
    }
    public ArrayList<Novedad>getNovedades() throws PersistenceException {
        ArrayList<Novedad>novedades=novedadServicios.getNovedades();
        return novedades;
    }
	public void setNovedades(ArrayList<Novedad>novedades){
        this.novedades=novedades;
    }

}
