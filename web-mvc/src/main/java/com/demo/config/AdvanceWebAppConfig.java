package com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;

/**
 * For advanced mode, you can remove @EnableWebMvc
 * and extend directly from DelegatingWebMvcConfiguration
 * instead of implementing WebMvcConfigurer
 *
 * @author gnl
 * @since 2023/4/25
 */
@Configuration
public class AdvanceWebAppConfig extends DelegatingWebMvcConfiguration {



}
