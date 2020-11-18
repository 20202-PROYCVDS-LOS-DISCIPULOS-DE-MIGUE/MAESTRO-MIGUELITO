package edu.eci.cvds.view;

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

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
@ManagedBean(name="elementoBean")
@SessionScoped
public class ElementoBean {
    //@Inject
    //private ElementoServicios elementoServicios;

    ElementoServicios elementoServicios = ServiciosFactory.getInstance().getElementoServicios();

    private int id;
    private String nombre;
    private String marca;
    private String modelo;
    private String caracteristicas;
    private int idEquipo;
    private ArrayList<Elemento>tecladosDisponibles;
    private ArrayList<Elemento>monitoresDisponibles;
    private ArrayList<Elemento>cpusDisponibles;
    private ArrayList<Elemento>mousesDisponibles;
    private ArrayList<Elemento>elementos;


    public ArrayList<Elemento>getTecladosDisponibles() throws PersistenceException {
        elementos=getElementos();
        //System.out.println("llega a teclados");
        tecladosDisponibles=new ArrayList<Elemento>();
        for(int i=0;i<elementos.size();i++){
            //System.out.println(elementos.get(i).getNombre().equals("Teclado"));
            //System.out.println(elementos.get(i).getIdEquipo());
            if(elementos.get(i).getTipo().equals("Teclado")&& elementos.get(i).getEquipo()==0){
                tecladosDisponibles.add(elementos.get(i));
            }
        }
        return tecladosDisponibles;
    }
    public void setTecladosDisponibles(ArrayList<Elemento>tecladosDisponibles){
        this.tecladosDisponibles=tecladosDisponibles;
    }
    public void setMonitoresDisponibles(ArrayList<Elemento>monitoresDisponibles){
        this.monitoresDisponibles=monitoresDisponibles;
    }
    public ArrayList<Elemento>getMonitoresDisponibles() throws PersistenceException {
        getElementos();
        monitoresDisponibles=new ArrayList<Elemento>();
        for(int i=0;i<getElementos().size();i++){
            if(elementos.get(i).getTipo().equals("Monitor")&& elementos.get(i).getEquipo()==0){
                monitoresDisponibles.add(elementos.get(i));
            }
        }
        return monitoresDisponibles;
    }
    public ArrayList<Elemento>getMousesDisponibles() throws PersistenceException {
        getElementos();
        mousesDisponibles=new ArrayList<Elemento>();
        for(int i=0;i<getElementos().size();i++){
            if(elementos.get(i).getTipo().equals("Mouse")&& elementos.get(i).getEquipo()==0){
                mousesDisponibles.add(elementos.get(i));
            }
        }
        return mousesDisponibles;
    }

    public void setMousesDisponibles(ArrayList<Elemento> mousesDisponibles) {
        this.mousesDisponibles = mousesDisponibles;
    }

    public ArrayList<Elemento>getCpusDisponibles() throws PersistenceException {
        getElementos();
        cpusDisponibles=new ArrayList<Elemento>();
        for(int i=0;i<getElementos().size();i++){
            if(elementos.get(i).getTipo().equals("Torre")&& elementos.get(i).getEquipo()==0){
                cpusDisponibles.add(elementos.get(i));
            }
        }
        return cpusDisponibles;
    }
    public void setCpusDisponibles(ArrayList<Elemento>cpusDisponibles){
        this.cpusDisponibles=cpusDisponibles;
    }


    public void setElementos(ArrayList<Elemento>elementos){
        this.elementos=elementos;
    }


    public ElementoServicios getElementoServices(){
        return elementoServicios;
    }

    public void setElementoServices(ElementoServicios elementoServicios){
        this.elementoServicios=elementoServicios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public void registrarElemento()throws PersistenceException{
        try{
            elementoServicios.registrarElemento(nombre,marca,modelo,caracteristicas,idEquipo);
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("Elemento registrado"));
            PrimeFaces current = PrimeFaces.current();
            current.executeScript("PF('dlg2').hide();");
        }catch (PersistenceException ex){
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"No se pudo crear el Elemento","Error"));
            throw ex;
        }
    }
    public ArrayList<Elemento> getElementos()throws PersistenceException {
        ArrayList<Elemento> elementos=new ArrayList<Elemento>();
        elementos=elementoServicios.getElementos();
        return elementos;
    }
    public void editElemento(int id,int idEquipo)throws PersistenceException{
        elementoServicios.editElemento(id,idEquipo);
    }

}
