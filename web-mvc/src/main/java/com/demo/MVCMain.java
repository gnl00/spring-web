package com.demo;

import com.demo.config.WebAppConfig;
import jakarta.servlet.ServletContext;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MVCMain {

    public MVCMain() throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context context = tomcat.addContext("", null);

        DispatcherServlet dispatcherServlet =
                new DispatcherServlet(this.createWebApplicationContext(context.getServletContext()));

        Wrapper servlet = tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*");

        // Servlet 容器开启异步请求支持
        servlet.setAsyncSupported(true);

        tomcat.start();
    }

    public WebApplicationContext createWebApplicationContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebAppConfig.class);

        ctx.setServletContext(servletContext);
        ctx.refresh();
        ctx.registerShutdownHook();
        return ctx;
    }

    public static void main(String[] args) throws LifecycleException {
        new MVCMain();
    }
}