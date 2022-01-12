package com.tracusa.logistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.tracusa.logistica.secutiry.JWTAuthorizationFilter;

@SpringBootApplication(scanBasePackages={
"com.administracion.ibo.IParamsSistemaBO",
"com.tracusa.logistica.dao",
"com.tracusa.logistica.bo",
"com.tracusa.logistica.interfase.bo",
"com.tracusa.logistica.interfase.dao",
"com.tracusa.logistica.controller",
"com.administracion.dao",
"com.administracion.idao",
"com.administracion.bo",
"com.administracion.ibo"})
public class LogisticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogisticaApplication.class, args);
	}

	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/rest/user/login").permitAll()
				.antMatchers(HttpMethod.POST, "/rest/user/insert").permitAll()
				.antMatchers(HttpMethod.GET, "/rest/user/checkAPI").permitAll()
				.antMatchers(HttpMethod.POST, "/rest/entrega/createEntrega").permitAll()
				.anyRequest().authenticated();
		}
		
	}
	
}
