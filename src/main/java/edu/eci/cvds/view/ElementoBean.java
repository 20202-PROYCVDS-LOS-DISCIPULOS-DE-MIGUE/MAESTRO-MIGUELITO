package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.ServiciosElemento;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "elementoBean")
@SessionScoped
public class ElementoBean extends BasePageBean
{
    @Inject
    private  ServiciosElemento serviciosElemento;
}
