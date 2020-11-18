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
    @Override
    public void login(String nombre,String clave) throws PersistenceException {
        try{

            Subject currentUser = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken(nombre,clave);

            currentUser.getSession().setAttribute("Correo",nombre);

            currentUser.login( token );

        } catch ( UnknownAccountException a ) {
            throw new PersistenceException("Usuario o contraseña incorrectos",a);
        } catch ( IncorrectCredentialsException b ) {
            throw new PersistenceException("Usuario o contraseña incorrectos",b);
        }
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

}