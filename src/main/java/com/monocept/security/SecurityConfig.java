package com.monocept.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public InMemoryUserDetailsManager UserDetailManager() {
		
		// {noop} - specifying that we have not used any encoding for password
		
		UserDetails Ravi = User.builder().username("xyz").password("{noop}admin").roles("staff").build();
		UserDetails Vivek = User.builder().username("admin").password("{noop}admin").roles("admin").build();
		
		return new InMemoryUserDetailsManager(Ravi,Vivek);
	}
	

	@Bean
	public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((configurer)->
				configurer.requestMatchers(HttpMethod.GET,"/contactapp/user").hasRole("admin").
				requestMatchers(HttpMethod.GET,"/contactapp/user/**").hasRole("admin").
				requestMatchers(HttpMethod.POST,"/contactapp/user").hasRole("admin").
				requestMatchers(HttpMethod.PUT,"/contactapp/user/**").hasRole("admin").
				requestMatchers(HttpMethod.DELETE,"/contactapp/user/**").hasRole("admin"));
		
		http.authorizeHttpRequests((configurer)->
		configurer.requestMatchers(HttpMethod.GET,"/contactapp/contact").hasRole("staff").
		requestMatchers(HttpMethod.GET,"/contactapp/contact/**").hasRole("staff").
		requestMatchers(HttpMethod.POST,"/contactapp/contact").hasRole("staff").
		requestMatchers(HttpMethod.PUT,"/contactapp/contact/**").hasRole("staff").
		requestMatchers(HttpMethod.DELETE,"/contactapp/contact/**").hasRole("staff"));
		
		http.authorizeHttpRequests((configurer)->
		configurer.requestMatchers(HttpMethod.GET,"/contactapp/contactdetail").hasRole("staff").
		requestMatchers(HttpMethod.GET,"/contactapp/contactdetail/**").hasRole("staff").
		requestMatchers(HttpMethod.POST,"/contactapp/contactdetail").hasRole("staff").
		requestMatchers(HttpMethod.PUT,"/contactapp/contactdetail/**").hasRole("staff").
		requestMatchers(HttpMethod.DELETE,"/contactapp/contactdetail/**").hasRole("staff"));
		
		
		http.httpBasic();
		http.csrf().disable();
		
		return http.build();
	}
	
	
//	@Bean
//	public BCryptPasswordEncoder encodePWD()
//	{
//		return new BCryptPasswordEncoder();
//	}
	
		
}
