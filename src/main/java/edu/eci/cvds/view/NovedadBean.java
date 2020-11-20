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


@ManagedBean(name="novedadBean")
@SessionScoped

public class NovedadBean {
    //@Inject
    //private NovedadServicios novedadServicios;

    private NovedadServicios novedadServicios = ServiciosFactory.getInstance().getNovedadServicios();
    private int id;
    private LocalDate fecha=LocalDate.now();
    private String descripcion;
    private String estado;
    private String tipo;
    private int idElemento;




    public NovedadServicios getNovedadServices(){
        return novedadServicios;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    public void registrarNovedad()throws PersistenceException{
        try{

            novedadServicios.registrarNovedad(descripcion,estado,tipo,idElemento);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Novedad registrada"));
            PrimeFaces current = PrimeFaces.current();
            current.executeScript("PF('dlg2').hide();");
        }catch (PersistenceException ex){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error registrando Novedad","Error"));
            throw ex;
        }
    }
    public ArrayList<Novedad>getNovedades() throws PersistenceException {
        ArrayList<Novedad>novedades=novedadServicios.getNovedades();
        return novedades;
    }

}
