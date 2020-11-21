package edu.eci.cvds.security;
import edu.eci.cvds.exceptions.PersistenceException;


import com.google.inject.Inject;
import edu.eci.cvds.security.Sesion;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.UsuarioServicios;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;

public class Autenticated implements Sesion {
    @Inject
    private UsuarioServicios usuarioServicios;


    public UsuarioServicios getUserServices() {
        return usuarioServicios;
    }

    public void setUserServices(UsuarioServicios usuarioServicios) {
        this.usuarioServicios = usuarioServicios;
    }
    @Override
    public void login(String documento,String contraseña) throws PersistenceException {
        try{

            Subject currentUser = SecurityUtils.getSubject();

            UsernamePasswordToken token = new UsernamePasswordToken(documento,contraseña);

            currentUser.getSession().setAttribute("documento",documento);

            currentUser.login( token );

        } catch ( UnknownAccountException a ) {
            throw new PersistenceException("credenciales inválidas",a);
        } catch ( IncorrectCredentialsException b ) {
            throw new PersistenceException("credenciales inválidas",b);
        }
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

}