package com.running.crew.config;


import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig
        extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private static final String SWAGGER_PATTERNS =
            List.of(
                            "/swagger-resources/**",
                            "/swagger-ui/**",
                            "/v3/api-docs/**",
                            "/v3/api-docs",
                            "/api-docs/**")
                    .toString();

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin().disable().cors().and().csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().mvcMatchers(SWAGGER_PATTERNS).permitAll();
        return http.build();
    }
}
