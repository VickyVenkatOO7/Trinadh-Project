package com.tri.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImpl();
	}
	
	
	@Bean
	public BCryptPasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider getDaoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return daoAuthenticationProvider;
	}
	
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.authenticationProvider(getDaoAuthenticationProvider());
	}
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
        	.authorizeHttpRequests(requests -> {
				try {
                    requests
                            .requestMatchers("/Admin/**")
                            .hasRole("Admin")
                            .requestMatchers("/User/**")
                            .hasRole("User")
                            .requestMatchers("/**")
                            .permitAll()
                            .and().formLogin(login -> login
                            .loginPage("/Signin")
                            .loginProcessingUrl("/Login")
                            .defaultSuccessUrl("/User/Home"))
                            .csrf(csrf -> csrf.disable());
				} catch (Exception e) {
					System.out.println("User Login Successful");
					e.printStackTrace();
				}
			});
		return http.build();
		
	}
}
