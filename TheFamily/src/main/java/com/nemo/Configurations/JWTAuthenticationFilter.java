package com.nemo.Configurations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nemo.Models.LoginViewModel;
import com.nemo.Services.UserPrincipal;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private AuthenticationManager authentication;

	public JWTAuthenticationFilter(AuthenticationManager authentication) {
		super();
		this.authentication = authentication;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		LoginViewModel credential = null;
		try {
			credential = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken
				(credential.getUsername(), credential.getPassword(), new ArrayList<>());
		Authentication auth = authentication.authenticate(authToken);
		return auth;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		UserPrincipal principal = (UserPrincipal) authResult.getPrincipal();
		String token = JWT.create().withSubject(principal.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+ JWTProperties.EXPIRATION_TIME))
				.sign(Algorithm.HMAC512(JWTProperties.SECRET.getBytes()));
		response.addHeader(JWTProperties.HEADER_STRING, JWTProperties.TOKEN_PREFIX+token);
	}
	
	
	
	
	
	
	

}
