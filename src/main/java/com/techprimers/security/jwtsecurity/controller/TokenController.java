package com.techprimers.security.jwtsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.security.jwtsecurity.model.JwtUser;
import com.techprimers.security.jwtsecurity.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {

	@Autowired
	private Environment environment;

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public String generate(@RequestParam final String userName) {
        JwtUser user = new JwtUser();
        user.setUserName(userName);
        return jwtGenerator.generate(user,environment);

    }
}
