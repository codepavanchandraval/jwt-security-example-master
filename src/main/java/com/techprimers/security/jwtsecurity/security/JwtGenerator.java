package com.techprimers.security.jwtsecurity.security;

import com.techprimers.security.jwtsecurity.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {


	public String generate(JwtUser jwtUser, Environment environment) {
		long ttlMillis = 5 * 24 * 3600000;
		Date exp = new Date(System.currentTimeMillis() + ttlMillis);
		Claims claims = Jwts.claims().setSubject(jwtUser.getUserName()).setExpiration(exp);
		String secretKey = environment.getProperty("spring.application.secret");
		if (secretKey != null) {
			return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS256, secretKey).compact();
		}
		System.out.println("Error in Environment Variable");
		return null;
	}
}
