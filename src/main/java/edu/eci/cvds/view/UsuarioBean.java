package edu.eci.cvds.view;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosFactory;
import edu.eci.cvds.samples.services.UsuarioServicios;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {
    //@Inject
    //Private UsuarioServicios usuariorServicios

    private UsuarioServicios  usuarioServicios= ServiciosFactory.getInstance().getUserServices();
    private String nombre;
    private String clave;


    public void logIn(){
        try{
            if(usuarioServicios.validateLogin(nombre,clave)){
                System.out.println("Validacion ok");
                Usuario usuario=usuarioServicios.getUser(nombre);
            }else{
                System.out.println("Fallo de Validacion");
                FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
            }
        } catch (PersistenceException | IOException persistenceException) {
            persistenceException.printStackTrace();
        }
    }

}
