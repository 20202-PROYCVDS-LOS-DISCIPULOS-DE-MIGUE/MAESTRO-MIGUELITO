package edu.eci.cvds.view;

import edu.eci.cvds.security.SessionLogger;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ServiciosFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean {


    private static final long serialVersionUID = -2084921068710522276L;

    private String nombre;
    private String clave;
    


    //@Inject
    //private SessionLogger logger;
    private SessionLogger logger = ServiciosFactory.getInstance().getLoginServices();

    public Subject getCurrentUser(){
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser;
    }

    public SessionLogger getLogger() {
        return logger;
    }

    public void setLogger(SessionLogger logger) {
        this.logger = logger;
    }

    public String getNombre() {
        return nombre;
    }
    public String getClave(){
        return clave;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setClave(String clave){
        this.clave=clave;
    }



    @RequiresGuest
    public void login() throws PersistenceException {
        try {
             logger.login(nombre,clave);
             FacesContext.getCurrentInstance().getExternalContext().redirect("/index2.xhtml");

        } catch (PersistenceException | IOException e){
            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no registrado", "Usuario no registrado"));
        }

    }

    public void activeSession () throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("");
    }
}
