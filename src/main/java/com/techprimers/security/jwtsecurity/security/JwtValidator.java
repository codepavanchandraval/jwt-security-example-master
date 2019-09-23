package com.techprimers.security.jwtsecurity.security;

import com.techprimers.security.jwtsecurity.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

	public JwtUser validate(String token,Environment environment) {

		String secretKey = environment.getProperty("spring.application.secret");
		if(secretKey==null) {
			System.out.println("Error in environment Variable");
			return null;
		}
        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(environment.getProperty("spring.application.secret"))
                    .parseClaimsJws(token)
                    .getBody();
            jwtUser = new JwtUser();
            jwtUser.setUserName(body.getSubject());
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }
}
