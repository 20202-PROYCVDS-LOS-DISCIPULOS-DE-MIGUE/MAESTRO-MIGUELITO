package edu.eci.cvds.view;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.Stateless;
import edu.eci.cvds.security.Sesion;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ServiciosFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;

@SuppressWarnings("deprecation")
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable{

    private static final Logger log = LoggerFactory.getLogger(LoginBean.class);
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

    public void login() throws PersistenceException  {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(getDocumento(),getContraseña());
        try {
             subject.login(token);
             FacesContext.getCurrentInstance().getExternalContext().redirect("/Menu.xhtml");                                                                
           } catch (UnknownAccountException uae) {    
               FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario no encontrado", "usuario no encontrado"));    
               log.error("Username Not Found!", uae);        
           } catch (IncorrectCredentialsException ice) {   
            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "contraseña invalida", "contraseña invalida"));  
               log.error("Invalid Credentials!", ice);       
           } catch (LockedAccountException lae) {       
            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "usuario bloqueado", "usuario bloqueado"));  
               log.error("Your Account is Locked!", lae);    
           } catch (AuthenticationException ae) {    
            FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "error desconocido", "error desconocido"));  
               log.error("Unexpected Error!", ae);           
            } catch (IOException e){
                FacesContext.getCurrentInstance().addMessage("shiro", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario no registrado", "Usuario no registrado"));
                log.error("Unexpected Error!", e); 
            }catch (NullPointerException e) {
            System.err.println("null");                                               
            }
        }

    

    public void activeSession () throws IOException {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext().redirect("");
    }
}
