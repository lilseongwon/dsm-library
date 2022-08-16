package com.example.entryassignment.global.property;

import com.example.entryassignment.global.security.jwt.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties(value = {JwtProperties.class})
@Configuration
public class EnableConfigurationPropertiesConfig {
}