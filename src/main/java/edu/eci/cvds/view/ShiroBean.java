/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.view;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import javax.faces.bean.ManagedBean;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;

@Named
@Stateless
@SessionScoped
@ManagedBean(name = "shiroBean", eager = true)
public class ShiroBean implements Serializable {
	
	

    private static final Logger log = LoggerFactory.getLogger(ShiroBean.class);
    private String documento;
    private String contraseña;
    private Boolean rememberMe = false;
    private String redirectUrl = "/faces/inicio.xhtml";
    static Subject subject;

    /**
     * Try and authenticate the user
     */
    public void doLogin() {
    	//System.out.println("Entra1");
    	
    	/*if (getUsername()=="") {
    		setUsername(null);}*/
        
        //System.out.println("Entra2");
		
        try {
        	System.out.println("Entra a try");
        	
        	System.out.println(getUsername());
        	System.out.println(getPassword());
        	FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/index.xhtml");
        	Subject currentUser = SecurityUtils.getSubject();
			String hex = new Sha256Hash(contraseña).toHex();
			System.out.println(hex);
			UsernamePasswordToken token = new UsernamePasswordToken(getUsername(), hex);
			token.setRememberMe(true);
			currentUser.login(token);
            
			
            
            /*
            if (subject.hasRole("ESTUDIANTE")) {
            	System.out.println("Entra a rol");
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/inicio.xhtml");
			} 
            /*
			else if (subject.hasRole("Proponente")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/inicioUsuarioProponente.xhtml");
			}
			else if (subject.hasRole("Publico")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/inicioPublico.xhtml");
			}
			else if (subject.hasRole("PersonalPMO")) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/InicioPMO.xhtml");
			}*/
			
        }
        catch (NullPointerException e) {
            System.err.println("Null Pointer");
        }
		catch (UnknownAccountException ex) {
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login", "Usuario desconocido."));
           
        } 
		catch (IncorrectCredentialsException ex) {
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login", "Contraseña incorrecta."));
        } 
		catch (LockedAccountException ex) {
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login", "Cuenta bloqueada."));
        } 
		catch (AuthenticationException | IOException ex) {
			FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login", "Todos los campos son obligatorios."));
        } 
    }

    public void doLogOut() {

        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(redirectUrl);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ShiroBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Adds a new SEVERITY_ERROR FacesMessage for the ui
     *
     * @param message Error Message
     */
    private void facesError(String message) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, message, null));
    }

    public String getUsername() {
        return documento;
    }

    public void setUsername(String login) {
        this.documento = login;
    }

    public String getPassword() {
        return contraseña;
    }

    public void setPassword(String senha) {
        this.contraseña = senha;
    }

    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean lembrar) {
        this.rememberMe = lembrar;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
}
