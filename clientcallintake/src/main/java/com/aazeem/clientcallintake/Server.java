package com.aazeem.clientcallintake;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

/**
 * Server Configuration Class
 * 
 * This class configures the backend server to enable API endpoints for
 * front-end access.
 * It provides:
 * - CORS (Cross-Origin Resource Sharing) support for front-end communication
 * - Configurable origins for development and production environments
 * - Security headers for API communication
 * 
 * Frontend can access all API endpoints via:
 * - http://localhost:3000 (development)
 * - http://localhost:8080 (production)
 * - Custom configured origins
 */
@Configuration
public class Server implements WebMvcConfigurer {

    /**
     * Configures CORS settings to allow front-end applications to communicate with
     * the API
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOriginPatterns("http://localhost:*", "http://127.0.0.1:*")
                .allowedOrigins("http://localhost:3000", "http://localhost:3001", "http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                .allowedHeaders("*")
                .allowCredentials(true)
                .maxAge(3600)
                .exposedHeaders("Content-Type", "X-Total-Count", "X-Current-Page");
    }

    /**
     * Alternative CORS configuration bean for more granular control
     * This bean can be used alongside addCorsMappings for additional flexibility
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Allowed origins - configure based on your environment
        List<String> allowedOrigins = Arrays.asList(
                "http://localhost:3000",
                "http://localhost:3001",
                "http://localhost:8080",
                "http://127.0.0.1:3000",
                "http://127.0.0.1:3001",
                "http://127.0.0.1:8080");
        configuration.setAllowedOrigins(allowedOrigins);

        // Allowed HTTP methods
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"));

        // Allowed request headers
        configuration.setAllowedHeaders(Arrays.asList("*"));

        // Allow credentials (cookies, authorization headers)
        configuration.setAllowCredentials(true);

        // Cache preflight response for 1 hour
        configuration.setMaxAge(3600L);

        // Exposed headers that front-end can access
        configuration.setExposedHeaders(Arrays.asList(
                "Content-Type",
                "Content-Length",
                "X-Total-Count",
                "X-Current-Page",
                "X-Page-Size"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", configuration);
        return source;
    }

    /**
     * Available API Endpoints for Frontend:
     * 
     * Call Records Endpoints:
     * - POST /api/calls - Create a new call record
     * - PUT /api/calls/{id} - Update an existing call record
     * 
     * Clients Endpoints:
     * - GET /api/clients - Get all clients
     * - GET /api/clients/{id} - Get client by ID
     * - POST /api/clients - Create a new client
     * - PUT /api/clients/{id} - Update an existing client
     * - DELETE /api/clients/{id} - Delete a client
     * 
     * Health Check:
     * - GET /api/health - Check server health status
     * 
     * Example Frontend Usage (JavaScript/Fetch):
     * 
     * // Create a new call record
     * fetch('http://localhost:8080/api/calls', {
     * method: 'POST',
     * headers: {
     * 'Content-Type': 'application/json'
     * },
     * credentials: 'include',
     * body: JSON.stringify({
     * clientId: 1,
     * callReason: "Initial Consultation",
     * priority: "HIGH"
     * })
     * })
     * .then(response => response.json())
     * .then(data => console.log('Call Created:', data));
     * 
     * // Get all clients
     * fetch('http://localhost:8080/api/clients', {
     * method: 'GET',
     * credentials: 'include'
     * })
     * .then(response => response.json())
     * .then(data => console.log('Clients:', data));
     */
}
