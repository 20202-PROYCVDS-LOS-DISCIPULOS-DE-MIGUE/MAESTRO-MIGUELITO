package edu.eci.cvds.security;

import com.google.inject.Inject;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.UsuarioServicios;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class ShiroSession implements SessionLogger {
    @Inject
    private UsuarioServicios usuarioServicios;


    public UsuarioServicios getUserServices() {
        return usuarioServicios;
    }

    public void setUserServices(UsuarioServicios usuarioServicios) {
        this.usuarioServicios = usuarioServicios;
    }
    public void login(String documento,String contraseña) throws PersistenceException {
        try{

            Subject currentUser = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken(documento,contraseña);

            currentUser.getSession().setAttribute("documento",documento);

            currentUser.login( token );

        } catch ( UnknownAccountException | IncorrectCredentialsException a ) {
            throw new PersistenceException("Usuario o contraseña incorrectos",a);
        }
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }
}