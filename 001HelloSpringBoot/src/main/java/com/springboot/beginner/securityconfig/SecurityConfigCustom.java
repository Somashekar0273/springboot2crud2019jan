package com.springboot.beginner.securityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfigCustom extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		auth.inMemoryAuthentication()
			.passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
			.withUser("user")
			.password("userpassword")
			.roles("USER")
			.and()
			.withUser("admin")
			.password("adminpassword")
			.roles("ADMIN")
			.and()
			.withUser("superadmin")
			.password("superpassword")
			.roles("USER", "ADMIN", "SUPERADMIN");
			
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		http.httpBasic()
			.and()
			.authorizeRequests().antMatchers("/").permitAll()
								.antMatchers("/welcome").permitAll()
								.antMatchers("/get/**").hasRole("USER")
								.antMatchers("/update/**").hasRole("ADMIN")
								.antMatchers("/delete/**").hasRole("SUPERADMIN")
								.anyRequest()
								.authenticated()
								.and()
								.csrf().disable().headers().frameOptions().disable();
	}
	
	

}
