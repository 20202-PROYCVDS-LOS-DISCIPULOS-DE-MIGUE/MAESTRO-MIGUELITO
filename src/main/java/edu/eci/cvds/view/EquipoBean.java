package edu.eci.cvds.view;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Elemento;
import edu.eci.cvds.samples.entities.Equipo;
import edu.eci.cvds.samples.entities.Laboratorio;
import edu.eci.cvds.samples.services.ElementoServicios;
import edu.eci.cvds.samples.services.EquipoServicios;
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
@ManagedBean(name="equipoBean")
@SessionScoped
public class EquipoBean {
    //@Inject
    //private EquipoServices equipoServices;

    EquipoServicios equipoServicios= ServiciosFactory.getInstance().getEquipoServicios();
    ElementoServicios elementoServicios= ServiciosFactory.getInstance().getElementoServicios();


    private int id;
    private String nombre;
    private String estado;
    private String enUso;
    private int idLaboratorio;
    private Laboratorio idLab;
    private Elemento ejemplo;
    private Elemento ejemploDos;
    private Elemento raton;
    private Elemento torre;
    private ArrayList<Equipo>listaEquipos;


    public ArrayList<Equipo>getListaEquipos(){
        return listaEquipos;
    }
    public void setListaEquipos(ArrayList<Equipo>listaEquipos){
        this.listaEquipos=listaEquipos;
    }

    public Elemento getTorre() {
        return torre;
    }

    public void setTorre(Elemento torre) {
        this.torre = torre;
    }

    public Elemento getRaton() {
        return raton;
    }

    public void setRaton(Elemento raton) {
        this.raton = raton;
    }

    public Elemento getEjemploDos(){
        return ejemploDos;
    }

    public void setEjemploDos(Elemento ejemploDos){
        this.ejemploDos=ejemploDos;
    }
    public Elemento getEjemplo(){
        return ejemplo;
    }

    public void setEjemplo(Elemento ejemplo) {
        this.ejemplo = ejemplo;
    }

    public EquipoServicios getElementoServices(){
        return equipoServicios;
    }

    public void setEquipoServices(EquipoServicios elementoServicios){
        this.equipoServicios=equipoServicios;
    }

    public Laboratorio getIdLab(){
        return idLab;
    }

    public void setIdLab(Laboratorio idLab) {
        this.idLab = idLab;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEnUso() {
        return enUso;
    }

    public void setEnUso(String enUso) {
        this.enUso = enUso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }


    public void registrarEquipo()throws PersistenceException{
        try{
            idLaboratorio=idLab.getIdLaboratorio();
            if(idLaboratorio>0){
                equipoServicios.registrarEquipo(nombre,estado,enUso,idLaboratorio);
                listaEquipos=new ArrayList<Equipo>();
                listaEquipos=getEquipos();
                for(int i=0;i<listaEquipos.size();i++){
                    if(listaEquipos.get(i).getIp().equals(nombre)){
                        elementoServicios.editElemento(ejemplo.getIdElemento(),listaEquipos.get(i).getIdEquipo());
                        elementoServicios.editElemento(ejemploDos.getIdElemento(),listaEquipos.get(i).getIdEquipo());
                        elementoServicios.editElemento(torre.getIdElemento(),listaEquipos.get(i).getIdEquipo());
                        elementoServicios.editElemento(raton.getIdElemento(),listaEquipos.get(i).getIdEquipo());
                    }
                }
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Equipo registrado"));
                PrimeFaces current = PrimeFaces.current();
                current.executeScript("PF('dlg2').hide();");
            }
            else {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Errores registrando equipo","Error"));
            }
        }catch (PersistenceException ex){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error registrando equipo","Error"));
            throw ex;
        }
    }
    public ArrayList<Equipo> getEquipos()throws PersistenceException{
        ArrayList<Equipo>equipos=equipoServicios.getEquipos();
        return equipoServicios.getEquipos();
    }

}







