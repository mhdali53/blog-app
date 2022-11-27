package com.yasir.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.yasir.blog.entities.User;
import com.yasir.blog.exceptions.ResourceNotFoundException;
import com.yasir.blog.repositories.UserRepo;
import com.yasir.blog.security.CustomUserDetailService;
import com.yasir.blog.security.JwtAuthenticationEntryPoint;
import com.yasir.blog.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired private CustomUserDetailService customUserDetailService;
	 
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	
		http.csrf().
		disable().
		authorizeHttpRequests()
		.antMatchers("/api/v1/auth/login").permitAll().
		anyRequest().
		authenticated().
		and().exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
		.and().
		sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	
		  
		http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		
		return http.build();
		
		
	}
	
	/*
	 * @Bean AuthenticationManager
	 * authenticationManager(AuthenticationManagerBuilder builder) throws Exception
	 * { return builder.userDetailsService(customUserDetailService).passwordEncoder(
	 * passwordEncoder()).and().build(); }
	 */

     @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
         return authenticationConfiguration.getAuthenticationManager();
     }
 

	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * @Bean public DaoAuthenticationProvider authenticationProvider() {
	 * DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	 * 
	 * authProvider.setUserDetailsService(customUserDetailService);
	 * authProvider.setPasswordEncoder(passwordEncoder());
	 * 
	 * return authProvider; }
	 */
}
