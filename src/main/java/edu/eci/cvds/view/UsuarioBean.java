package edu.eci.cvds.view;

import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.samples.services.ServiciosFactory;
import edu.eci.cvds.samples.services.UsuarioServicios;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {
    //@Inject
    //Private UsuarioServicios usuariorServicios

    private UsuarioServicios  usuarioServicios= ServiciosFactory.getInstance().getUserServices();
    private String documento;
    private String contraseña;


    public void logIn(){
        try{
            if(usuarioServicios.validateLogin(documento,contraseña)){
                System.out.println("Validacion ok");
                Usuario usuario=usuarioServicios.getUser(documento);
            }else{
                System.out.println("Fallo de Validacion");
                FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            }
        } catch (PersistenceException persistenceException) {
            persistenceException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
