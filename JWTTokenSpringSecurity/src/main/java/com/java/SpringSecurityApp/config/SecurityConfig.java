package com.java.SpringSecurityApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.java.SpringSecurityApp.service.MyUserDetailsService;

import jakarta.servlet.Filter;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	@Autowired
	private MyUserDetailsService userDetailservice;
	@Autowired
	private JwtFilter jwtFilter;
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.csrf(customizer->customizer.disable());
		//http.formLogin(Customizer.withDefaults());
		http.authorizeHttpRequests(authorizeHttp->authorizeHttp.requestMatchers("add-users","login").permitAll().anyRequest().authenticated());
		http.httpBasic(Customizer.withDefaults());
		http.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

	/*
	 * @Bean public UserDetailsService userDetails() { UserDetails user=
	 * User.withDefaultPasswordEncoder().username("Kannu").password("Kannu@12")
	 * .roles("user") .build();
	 * 
	 * UserDetails
	 * admin=User.withDefaultPasswordEncoder().username("Admin").password(
	 * "Kannu@12") .roles("ADMIN") .build(); return new
	 * InMemoryUserDetailsManager(user,admin); }
	 */
	@Bean
	public AuthenticationProvider authProvider()
	{
		DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider();
		daoProvider.setUserDetailsService(userDetailservice);
		//daoProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		daoProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		return daoProvider;
		
	}
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception
	{
		return config.getAuthenticationManager();
	}
}
