package com.webservice.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(final HttpSecurity http) throws Exception {
	    http
	        .formLogin()
	        .loginPage("/login.html")
	        .failureUrl("/login-error.html")
	        .defaultSuccessUrl("/index.html")
	      .and()
	        .logout()
	        .logoutSuccessUrl("/index.html")
	        .and().authorizeRequests().antMatchers("/admin/usuario/abm-usuario.html").hasAuthority("ROL_ADMIN")
	        .and().authorizeRequests().antMatchers("/admin/usuario/listUsuarios").hasAuthority("ROL_ADMIN")
	        .and().authorizeRequests().antMatchers("/buscador.html").hasAuthority("ROL_AUDITOR")
	        .and().authorizeRequests().antMatchers("/admin/rol/abm-rol.html").hasAuthority("ROL_ADMIN");

}
	
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
}
