package com.nemo.Configurations;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nemo.Models.User;
import com.nemo.Services.UserPrincipal;
import com.nemo.Services.UserService;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter{
		
	@Autowired
	UserService userService;

	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, UserService userService) {
		super(authenticationManager);
		this.userService = userService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader(JWTProperties.HEADER_STRING);
//		System.out.println("header issss "+header);
		if (header==null || !header.startsWith(JWTProperties.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
//			System.out.println("i am null ");
			return;
		}
		Authentication auth = getUsernamePasswordAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(auth);
		chain.doFilter(request, response);
		
	}

	private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
		String token = request.getHeader(JWTProperties.HEADER_STRING).replace(JWTProperties.TOKEN_PREFIX,"");
//		System.out.println("token isss : "+token);
		if (token != null) {
			String username = JWT.require(Algorithm.HMAC512(JWTProperties.SECRET.getBytes())).build()
					.verify(token).getSubject();
//			System.out.println("username isss : "+username);
			if (username != null) {
				User user = userService.getUserByUsername(username);
				UserPrincipal principal = new UserPrincipal(user);
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken
						(username,null, principal.getAuthorities());
				return authToken;
			}
			return null;
		}
		return null;
	}
	
	
}
