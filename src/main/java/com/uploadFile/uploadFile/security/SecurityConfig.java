package com.uploadFile.uploadFile.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final OAuth2LoginSuccessHandler successHandler;

    public SecurityConfig(OAuth2LoginSuccessHandler successHandler) {
        this.successHandler = successHandler;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS) // Força criação de sessão
                        .sessionFixation().migrateSession()
                        .maximumSessions(1)
                        .expiredUrl("/login?expired")
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/",
                                "/login",
                                "/registrar",
                                "/files/**",
                                "/v1/client/**",
                                "/css/**",
                                "/js/**",
                                "/webjars/**",
                                "/error"
                        ).permitAll()
                        .requestMatchers("/home", "/dashboard/**").authenticated()
                        .anyRequest().authenticated()
                )
                .oauth2Login(oauth2 -> oauth2
                        .loginPage("/login")
                        .successHandler(successHandler)
                )

                .formLogin(form -> form
                        .loginPage("/login")
                        //   .loginProcessingUrl("/v1/client/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                );


        return http.build();
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                // Configuração CORS
//                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
//
////                // Configuração CSRF
////                .csrf(csrf -> csrf
////                        .ignoringRequestMatchers(
////                                "/v1/client/register",
////                                "/v1/client/login",
////                                "/oauth2/**"
////                        )
////                )
//
//
//
//                // Autorizações
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                "/",
//                                "/login**",
//                                "/registrar**",
//                                "/files/**",
//                                "/v1/client/register**",
//                                "/v1/client/login",
//                                "/css/**",
//                                "/js/**",
//                                "/webjars/**",
//                                "/error"
//                        ).permitAll()
//                        .requestMatchers("/home", "/dashboard/**").authenticated()
//                        .anyRequest().authenticated()
//                )
//
//
//
//                // OAuth2 Login
//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/login")
//                        .successHandler(successHandler)
//                )
//
//                // Logout
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/")
//                        .invalidateHttpSession(true)
//                        .deleteCookies("JSESSIONID")
//                        .permitAll()
//                )
//
//                // Headers de segurança
//                .headers(headers -> headers
//                        .frameOptions(frame -> frame.sameOrigin())
//                        .httpStrictTransportSecurity(hsts -> hsts
//                                .includeSubDomains(true)
//                                .preload(true)
//                                .maxAgeInSeconds(31536000)
//                        )
//                )
//                // Form Login
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .loginProcessingUrl("/v1/client/login")
//                        .defaultSuccessUrl("/home", true)
//                        .permitAll()
//
//                )
//                .csrf(csrf -> csrf.disable());
//                // Gerenciamento de sessão
////                .sessionManagement(session -> session
////                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
////                        .maximumSessions(1)
////                );
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(List.of("*"));
//        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//        configuration.setAllowedHeaders(List.of("*"));
//        configuration.setExposedHeaders(List.of("Authorization", "Content-Disposition"));
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }

}
