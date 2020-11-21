package edu.eci.cvds.view;

import edu.eci.cvds.security.Sesion;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ServiciosFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;

@SuppressWarnings("deprecation")
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean{

    private static final long serialVersionUID = -2084921068710522276L;

    private String documento;
    private String contraseña;
	//@Inject
    //private Sesion sesion;
    private Sesion sesion = ServiciosFactory.getInstance().getLoginServices();

    public Subject getCurrentUser(){
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setLogger(Sesion sesion) {
        this.sesion = sesion;
    }

    public String getDocumento() {
        return documento;
    }
	
	public void setDocumento(String documento){
        this.documento=documento;
    }
	
    public String getContraseña(){
        return contraseña;
    }
    
    public void setcontraseña(String contraseña){
        this.contraseña=contraseña;
    }



    @RequiresGuest
    public void login() throws PersistenceException {
        try {
             sesion.login(documento,contraseña);
             FacesContext.getCurrentInstance().getExternalContext().redirect("/Menu.xhtml");

        } catch (PersistenceException | IOException e){
            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no registrado", "Usuario no registrado"));
        }

    }

    public void activeSession () throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("");
    }
}
