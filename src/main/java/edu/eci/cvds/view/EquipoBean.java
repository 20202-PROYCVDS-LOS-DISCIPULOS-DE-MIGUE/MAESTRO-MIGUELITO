package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.ServiciosEquipo;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "equipoBean")
@SessionScoped
public class EquipoBean extends BasePageBean
{
    @Inject
    private  ServiciosEquipo serviciosEquipo;

}
