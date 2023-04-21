package com.demo.config;

import com.demo.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * TODO
 *
 * @author gnl
 * @since 2023/4/20
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {com.demo.EmbedTomcatMain.class})
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new TestInterceptor());

        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
