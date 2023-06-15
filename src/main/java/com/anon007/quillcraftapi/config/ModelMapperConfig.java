package com.anon007.quillcraftapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ModelMapperConfig {
    // Scope: https://www.tutorialspoint.com/spring/spring_bean_scopes.htm
    @Bean
    @Scope("singleton")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
