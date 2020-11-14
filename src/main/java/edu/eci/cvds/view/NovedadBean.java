package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.ServiciosNovedad;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "novedadBean")
@SessionScoped
public class NovedadBean extends BasePageBean
{
    @Inject
     private ServiciosNovedad serviciosNovedad;
	
}
