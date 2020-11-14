package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Usuario;
import edu.eci.cvds.exceptions.PersistenceException;
import edu.eci.cvds.samples.services.ServiciosUsuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;


@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean extends BasePageBean
{
    private List<Usuario> usuarios = null;
    @Inject
    private  ServiciosUsuario serviciosUsuario;

    public List<Usuario> consultarUsuarios() throws PersistenceException 
    {
        return serviciosUsuario.consultarUsuarios();
    }
}
