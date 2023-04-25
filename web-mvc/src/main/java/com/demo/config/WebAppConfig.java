package com.demo.config;

import com.demo.converter.TimeConverter;
import com.demo.interceptor.TestInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * TODO
 *
 * @author gnl
 * @since 2023/4/20
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = {com.demo.MVCMain.class})
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor());
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // converters.add(new TimeConverter());
    }
}
