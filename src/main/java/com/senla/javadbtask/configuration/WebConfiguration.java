package com.senla.javadbtask.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan("com.senla.javadbtask")
@Configuration
public class WebConfiguration {
}
