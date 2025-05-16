package com.app.qr.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.app.qr.model.entity.consts.Role;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(req -> req
            .requestMatchers("/", "/login", "/resources/**").permitAll()
            .requestMatchers("/user/public/view/**").permitAll() 
            .requestMatchers("/admin/**").hasAuthority(Role.ADMIN.name())
            .anyRequest().authenticated()
        )
        .formLogin(form -> form.disable())
        .httpBasic(Customizer.withDefaults());

		return http.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
    }

}
