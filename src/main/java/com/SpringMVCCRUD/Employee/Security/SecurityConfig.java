package com.SpringMVCCRUD.Employee.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable); //http.csrf(csrf -> csrf.disable());

        http.authorizeHttpRequests(configuration ->
                configuration
                        .anyRequest().authenticated())
                .formLogin(login ->
                        login
                             .loginPage("/employee/loginPage")
                             .loginProcessingUrl("/authenticateTheUser")
                             .permitAll()
                )
                .logout(LogoutConfigurer::permitAll); // .logout(logout -> logout.permitAll()

        return http.build();
    }
}
