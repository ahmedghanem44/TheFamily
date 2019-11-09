package com.nemo.Configurations;

public class JWTProperties {
	
	public static final String SECRET="secret";
	public static final long EXPIRATION_TIME=1800000L;//ONE DAY
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEADER_STRING="Authorization";

}
