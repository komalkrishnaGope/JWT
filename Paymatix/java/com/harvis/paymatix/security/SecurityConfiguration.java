package com.harvis.paymatix.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.harvis.paymatix.jwt.JWTFilter;
import com.harvis.paymatix.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTFilter jwtFilter;
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                
                .authorizeRequests()
                .antMatchers("/paymatix/login")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                
//                .authorizeRequests()
//                .antMatchers("/paymatix/login")
//                .permitAll()
//                .antMatchers("/paymatix/adminlogin")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
                
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
