package com.demo.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;
import lombok.extern.log4j.Log4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * 使用 Java 自定义启动 Servlet
 * 除了 WebApplicationInitializer 还可以使用 AbstractAnnotationConfigDispatcherServletInitializer
 * @link https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-servlet-context-hierarchy
 *
 * @author gnl
 * @since 2023/4/20
 */
@Log4j
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    public MyWebApplicationInitializer() {
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("onStartup");

        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        // ac.register(WebAppConfig.class);

        // Create and register the DispatcherServlet
        DispatcherServlet servlet = new DispatcherServlet(ac);
        ServletRegistration.Dynamic registration = servletContext.addServlet("web", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/web/*");
    }
}
