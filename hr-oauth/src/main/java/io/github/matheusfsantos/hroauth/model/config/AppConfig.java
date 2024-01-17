package io.github.matheusfsantos.hroauth.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	JwtAccessTokenConverter getJwtAccessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		
		tokenConverter.
			setSigningKey("My-Secret-Key");
		
		return tokenConverter;
	}
	
	@Bean
	JwtTokenStore getJwtTokenStore() {
		return new JwtTokenStore(getJwtAccessTokenConverter());
	}
	
}
