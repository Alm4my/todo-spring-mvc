package fr.almamy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("onStartup");

        // Create the spring application context
        var context = new AnnotationConfigWebApplicationContext();

        // registering a configuration class (our WebConfig class in this instance)
        context.register(WebConfig.class);
    }
}
