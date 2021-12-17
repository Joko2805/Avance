package com.demo.mpb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.demo.mpb.security.jwt.JwtAuthenticationEntryPoint;
import com.demo.mpb.security.jwt.JwtRequestFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/rol/**","/usuario/**","/authenticate/**").permitAll()
				.antMatchers("/alumno/**").hasAnyAuthority("DIRECTOR","SECRETARIA","SUB DIRECTOR")
				.antMatchers("/apoderado/**").hasAnyAuthority("DIRECTOR","SECRETARIA","SUB DIRECTOR")
				.antMatchers("/asignacion/**").hasAnyAuthority("DIRECTOR","SECRETARIA","DOCENTE")
				.antMatchers("/aula/**").hasAnyAuthority("DIRECTOR","SECRETARIA")
				.antMatchers("/calificacion/**").hasAnyAuthority("DOCENTE","ALUMNO")
				.antMatchers("/cargo/**").hasAnyAuthority("DIRECTOR","SECRETARIA")
				.antMatchers("/curso/**").hasAnyAuthority("DIRECTOR","SECRETARIA","DOCENTE")
				.antMatchers("/distrito/**").hasAnyAuthority("DIRECTOR","SECRETARIA")
				.antMatchers("/grado/**").hasAnyAuthority("DIRECTOR","SECRETARIA")
				.antMatchers("/horario/**").hasAnyAuthority("DIRECTOR","SECRETARIA","ALUMNO")
				.antMatchers("/matricula/**").hasAnyAuthority("DIRECTOR","SECRETARIA","ALUMNO")
				//.antMatchers("/rol/**").hasAuthority("DIRECTOR")
				.antMatchers("/seccion/**").hasAnyAuthority("DIRECTOR","SECRETARIA","DOCENTE")
				.antMatchers("/trabajador/**").hasAnyAuthority("DIRECTOR","SUB DIRECTOR");
		
		http.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint);
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter,UsernamePasswordAuthenticationFilter.class);

		http.authorizeRequests().and().httpBasic();

		http.authorizeRequests().and().csrf().disable();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}	
}
