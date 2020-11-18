package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.sampleprj.dao.myBatis.*;
import edu.eci.cvds.security.SessionLogger;
import edu.eci.cvds.security.ShiroSession;
import edu.eci.cvds.samples.services.impl.ElementoServiciosImpl;
import edu.eci.cvds.samples.services.impl.LaboratorioServiciosImpl;
import edu.eci.cvds.samples.services.impl.EquipoServiciosImpl;
import edu.eci.cvds.samples.services.impl.NovedadServiciosImpl;
import edu.eci.cvds.samples.services.impl.UsuarioServiciosImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class ServiciosFactory {

    private static ServiciosFactory instance= new ServiciosFactory();

    private static Optional<Injector> optInjector=Optional.empty();


    private Injector myBatisInjector(final String env, final String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(UsuarioServicios.class).to(UsuarioServiciosImpl.class);
                bind(ElementoDAO.class).to(MyBatisElementoDAO.class);
                bind(ElementoServicios.class).to(ElementoServiciosImpl.class);
                bind(NovedadDAO.class).to(MyBatisNovedadDAO.class);
                bind(NovedadServicios.class).to(NovedadServiciosImpl.class);
                bind(EquipoDAO.class).to(MyBatisEquipoDAO.class);
                bind(EquipoServicios.class).to(EquipoServiciosImpl.class);
                bind(LaboratorioDAO.class).to(MyBatisLaboratorioDAO.class);
                bind(LaboratorioServicios.class).to(LaboratorioServiciosImpl.class);
                bind(SessionLogger.class).to(ShiroSession.class);
            }
        });
    }
    public SessionLogger getLoginServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(SessionLogger.class);
    }

    public static ServiciosFactory getInstance(){

        return instance;
    }
    public UsuarioServicios getUserServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(UsuarioServicios.class);
    }

    public ElementoServicios getElementoServicios(){
        if(!optInjector.isPresent()){
            optInjector=Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(ElementoServicios.class);
    }
    
    public EquipoServicios getEquipoServicios(){
        if(!optInjector.isPresent()){
            optInjector=Optional.of(myBatisInjector("test","mybatis-config-h.xml"));
        }
        return optInjector.get().getInstance(EquipoServicios.class);
    }
    public NovedadServicios getNovedadServicios(){
        if(!optInjector.isPresent()){
            optInjector=Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(NovedadServicios.class);
    }
	public LaboratorioServicios getLaboratorioServicios() {
		if(!optInjector.isPresent()){
            optInjector=Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }
        return optInjector.get().getInstance(LaboratorioServicios.class);
	}
}
