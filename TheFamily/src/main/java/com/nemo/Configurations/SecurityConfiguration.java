package com.nemo.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.nemo.Services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired 
	UserService userService;

	@Bean
	public BCryptPasswordEncoder getEncoder() {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		return bcrypt;
	}

	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(getEncoder());
		return provider;
	}

	// Due we have implemented Spring Security we need to let Spring knows that our
	// resources folder can be
	// served skipping the antMatchers defined.
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
//	}
	
	/*
	 * Here we define the antMatchers to provide access based on the role(s) (lines
	 * 48 to 51), the parameters for the login process (lines 55 to 56), the success
	 * login page(line 53), the failure login page(line 53), and the logout page
	 * (line 58).
	 */
	
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
		 	// need to get changed
	        http	
	        	.csrf().disable()
	        	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        	.and()
	        	.addFilter(new JWTAuthenticationFilter(authenticationManager()))
	        	.addFilter(new JWTAuthorizationFilter(authenticationManager(), userService))
	        	.authorizeRequests()
	        	.antMatchers(HttpMethod.POST, "/login").permitAll()
	        	.anyRequest().authenticated();
	        	
//	                authorizeRequests()
//	                .antMatchers("/").permitAll()
//	                .antMatchers("/login").permitAll()
//	                .antMatchers("/registration").permitAll()
//	                .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
//	                .authenticated().and().csrf().disable().formLogin()
//	                .loginPage("/login").failureUrl("/login?error=true")
//	                .defaultSuccessUrl("/admin/home")
//	                .usernameParameter("email")
//	                .passwordParameter("password")
//	                .and().logout()
//	                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//	                .logoutSuccessUrl("/").and().exceptionHandling()
//	                .accessDeniedPage("/access-denied");
	    }
	
	

}
