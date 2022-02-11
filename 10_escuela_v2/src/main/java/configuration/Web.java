package configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Web implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) {
      // Registra la clase de configuraci�n del modelo
      AnnotationConfigWebApplicationContext rootContext =new AnnotationConfigWebApplicationContext();
      rootContext.register(ModeloConfig.class);
      // Registra la clase de configuraci�n del controlador
      AnnotationConfigWebApplicationContext dispatcherContext =new AnnotationConfigWebApplicationContext();
      dispatcherContext.register(MvcConfig.class);
      // Gestiona el ciclo de vida del contexto de aplicaci�n
      container.addListener(new ContextLoaderListener(rootContext)); 
      // Crea y registra el DispatcherServlet
      ServletRegistration.Dynamic dispatcher =
        container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
      dispatcher.setLoadOnStartup(1);
      dispatcher.addMapping("/");
    }
 }

