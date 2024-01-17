package io.github.matheusfsantos.hrapigateway.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {
	
	@Bean
	JwtAccessTokenConverter getJwtAccessTokenConverter() {
		JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
		
		tokenConverter.
			setSigningKey("MY-SECRET-KEY");
		
		return tokenConverter;
	}
	
	@Bean
	JwtTokenStore getJwtTokenStore() {
		return new JwtTokenStore(getJwtAccessTokenConverter());
	}
	
}
