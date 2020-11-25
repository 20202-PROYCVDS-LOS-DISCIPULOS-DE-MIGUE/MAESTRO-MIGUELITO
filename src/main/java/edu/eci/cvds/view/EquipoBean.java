package edu.eci.cvds.view;


import com.google.inject.Inject;
import edu.eci.cvds.view.ElementoBean;
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

@SuppressWarnings("deprecation")
@ManagedBean(name="equipoBean")
@SessionScoped
public class EquipoBean {
    //@Inject
    //private EquipoServicios equipoServicios;
    private EquipoServicios equipoServicios = ServiciosFactory.getInstance().getEquipoServicios();
    private ElementoServicios elementoServicios= ServiciosFactory.getInstance().getElementoServicios();


    private int idEquipo;
    private String ip;
    private String informacion;
    private boolean activo;
    private int laboratorio;
    private Laboratorio conLaboratorio;
    private Elemento teclado;
    private Elemento monitor;
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

    public Elemento getMonitor(){
        return monitor;
    }


    public void setMonitor(Elemento monitor){
        this.monitor=monitor;
    }
    public Elemento getTeclado(){
        return teclado;
    }

    public void setTeclado(Elemento teclado) {
        this.teclado = teclado;
    }

    public EquipoServicios getElementoServices(){
        return equipoServicios;
    }

    public void setEquipoServices(EquipoServicios elementoServicios){
        this.equipoServicios=equipoServicios;
    }

    public Laboratorio getConLaboratorio(){
        return conLaboratorio;
    }

    public void setConLaboratorio(Laboratorio conLaboratorio) {
        this.conLaboratorio = conLaboratorio;
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


    public void registrarEquipo(int laboratorio,String ip)throws PersistenceException{
        try{
            laboratorio=conLaboratorio.getIdLaboratorio();
            if(laboratorio>0){
                equipoServicios.registrarEquipo(ip,informacion,activo,laboratorio);
                listaEquipos=new ArrayList<Equipo>();
                listaEquipos=getEquipos();
                for(int i=0;i<listaEquipos.size();i++){
                    if(listaEquipos.get(i).getIp().equals(ip)){
                        elementoServicios.editElemento(teclado.getIdElemento(),listaEquipos.get(i).getIdEquipo());
                        elementoServicios.editElemento(monitor.getIdElemento(),listaEquipos.get(i).getIdEquipo());
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







