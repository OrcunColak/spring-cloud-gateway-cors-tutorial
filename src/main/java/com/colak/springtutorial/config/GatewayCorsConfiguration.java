package com.colak.springtutorial.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

// @Configuration
public class GatewayCorsConfiguration {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);

        config.addAllowedOrigin("http://localhost:3000");
        config.addAllowedOrigin("https://example.com");
        config.addAllowedOrigin("https://another-domain.com");

        config.addAllowedHeader("Content-Type");
        config.addAllowedHeader("Authorization");

        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.setExposedHeaders(List.of("Authorization", "X-Trace-Id"));
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}