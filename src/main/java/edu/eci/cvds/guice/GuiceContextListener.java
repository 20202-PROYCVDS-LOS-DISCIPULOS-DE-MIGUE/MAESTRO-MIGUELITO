/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.sampleprj.dao.UsuarioDAO;
import edu.eci.cvds.sampleprj.dao.ElementoDAO;
import edu.eci.cvds.sampleprj.dao.EquipoDAO;
//import edu.eci.cvds.sampleprj.dao.NovedadDAO;
//import edu.eci.cvds.sampleprj.dao.LaboratorioDAO;

import edu.eci.cvds.sampleprj.dao.myBatis.MyBatisUsuarioDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.MyBatisElementoDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.MyBatisEquipoDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.MyBatisNovedadDAO;
import edu.eci.cvds.sampleprj.dao.myBatis.MyBatisLaboratorioDAO;

import edu.eci.cvds.samples.services.impl.ServicesElementoImpl;
import edu.eci.cvds.samples.services.impl.ServicesEquipoImpl;
import edu.eci.cvds.samples.services.impl.ServicesUserImpl;

import edu.eci.cvds.samples.services.ServiciosElemento;
import edu.eci.cvds.samples.services.ServiciosEquipo;
import edu.eci.cvds.samples.services.ServiciosHistorialFactory;
import edu.eci.cvds.samples.services.ServiciosNovedad;
import edu.eci.cvds.samples.services.ServiciosUsuario;
/**
 *
 * @author Daniel Ducuara - Miguel Rodríguez - James Torres
 */
public class GuiceContextListener implements ServletContextListener
{   
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) 
    {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }
    
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) 
    {
        Injector injector = Guice.createInjector(new XMLMyBatisModule() 
        {
            @Override
            protected void initialize() 
            {
                install(JdbcHelper.PostgreSQL);
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
        servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
    }
}
