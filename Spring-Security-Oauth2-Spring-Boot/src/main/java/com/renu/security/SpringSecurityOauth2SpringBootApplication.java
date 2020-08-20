package com.renu.security;

import java.security.Principal;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class SpringSecurityOauth2SpringBootApplication {
	@GetMapping("/")
	public String hello(Principal principal) {
		Map<String, Object> details = (Map<String, Object>) ((OAuth2Authentication) principal).getUserAuthentication()
				.getDetails();
		return "Hello " + details.get("name");
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityOauth2SpringBootApplication.class, args);
	}

}
