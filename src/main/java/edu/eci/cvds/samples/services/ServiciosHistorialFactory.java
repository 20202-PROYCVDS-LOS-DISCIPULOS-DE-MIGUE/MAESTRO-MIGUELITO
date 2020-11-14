package edu.eci.cvds.samples.services;

import com.google.inject.Injector;
import com.google.inject.Guice;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import org.mybatis.guice.XMLMyBatisModule;
import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.sampleprj.dao.myBatis.*;
import edu.eci.cvds.samples.services.impl.*;
/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class ServiciosHistorialFactory {
    private static final ServiciosHistorialFactory instance = new ServiciosHistorialFactory();
    private static Injector injector;
	
	public ServiciosHistorialFactory() {
		injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
            protected void initialize() {
				this.install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
				bind(EquipoDAO.class).to(MyBatisEquipoDAO.class);
                bind(ElementoDAO.class).to(MyBatisElementoDAO.class);
                //bind(NovedadDAO.class).to(MyBatisNovedadDAO.class);
                
                bind(ServiciosUsuario.class).to(ServicesUserImpl.class);
				bind(ServiciosEquipo.class).to(ServicesEquipoImpl.class);
                bind(ServiciosElemento.class).to(ServicesElementoImpl.class);
                //bind(ServiciosNovedad.class).to(ServicesNovedadImpl.class);
            }
        });
    }
	public static ServiciosHistorialFactory getInstance() {
        return instance;
    }

    public ServiciosUsuario getServicesUsuario() {
        return injector.getInstance(ServiciosUsuario.class);
    }

}