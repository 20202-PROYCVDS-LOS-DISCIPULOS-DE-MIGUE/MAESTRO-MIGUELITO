package edu.eci.cvds.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;
import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.MyBatisUsuarioDAO;
import edu.eci.cvds.samples.services.UsuarioServicios;
import edu.eci.cvds.samples.services.impl.UsuarioServiciosImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class GuiceContextListener {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
                // TODO Add service class associated to Stub implementation
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(UsuarioServicios.class).to(UsuarioServiciosImpl.class);
            }
        });

        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }

}