package com.demo.config;

import com.demo.converter.CustomConverter;
import com.demo.interceptor.TestInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.*;

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
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new CustomConverter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TestInterceptor());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/test/**")
                .allowedOrigins("http://localhost:5173")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowCredentials(true);
    }

//    @Override
//    public void configurePathMatch(PathMatchConfigurer configurer) {
//        // 添加统一前缀
//        configurer.addPathPrefix("/api", HandlerTypePredicate.forBasePackage("com.demo.controller"));
//    }
}
