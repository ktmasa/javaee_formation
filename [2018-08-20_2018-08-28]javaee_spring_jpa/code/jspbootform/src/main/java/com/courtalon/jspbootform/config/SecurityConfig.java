package com.courtalon.jspbootform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.passwordEncoder(new BCryptPasswordEncoder())
			// "P@ssw0rd" -> "$2y$12$md37HdIWTaokac2PmUiDmu6Zwy7h8/i57yqhPaUkQ8GpTn3nO977q"
			.withUser("admin").password("$2y$12$md37HdIWTaokac2PmUiDmu6Zwy7h8/i57yqhPaUkQ8GpTn3nO977q").roles("ADMIN", "USER").and()
			// "1234" -> "$2y$12$DaHSvHUFuJT04RkOdFHhCervVqZ1x.aNg9dJeR2Qd2hMNsj4A/IOC"
			.withUser("vincent").password("$2y$12$DaHSvHUFuJT04RkOdFHhCervVqZ1x.aNg9dJeR2Qd2hMNsj4A/IOC").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
														.and()
		    .authorizeRequests().antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
		    											.and()
		    .authorizeRequests().antMatchers("/").permitAll().and()
		    					.httpBasic();
		
	}

	
	
}
