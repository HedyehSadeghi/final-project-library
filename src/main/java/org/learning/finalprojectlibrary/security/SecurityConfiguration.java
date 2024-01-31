package org.learning.finalprojectlibrary.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    // metodo che restituisce un DatabaseUserDetailsService
    @Bean
    public DatabaseUserDetailsService userDetailsService() {
        return new DatabaseUserDetailsService();
    }

    // metodo che restituisce un PasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    // metodo che restituisce l'AuthenticationProvider
    @Bean
    public DaoAuthenticationProvider authProvider() {
        // creo un provider vuoto
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        // gli passo lo UserDetailsService
        authenticationProvider.setUserDetailsService(userDetailsService());
        // gli passo il PasswordEncoder
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/books", "/books/**")
                .hasAuthority("ADMIN")

                .requestMatchers("/categories", "/categories/**").hasAuthority("ADMIN")

                .requestMatchers("/clients", "/clients/**").hasAuthority("ADMIN")

                .requestMatchers("/suppliers", "/suppliers/**").hasAuthority("ADMIN")

                .requestMatchers(HttpMethod.POST, "/books/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/categories/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/clients/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST, "/suppliers/**").hasAuthority("ADMIN")

                .requestMatchers("/", "/**").hasAnyAuthority("ADMIN", "USER")
                .requestMatchers("/shop", "/shop/**").hasAnyAuthority("ADMIN", "USER")


                .requestMatchers("/", "/**").permitAll()

                .and().formLogin()
                .and().logout()
                .and().exceptionHandling()
                .and().csrf().disable();

        return http.build();
    }
}
