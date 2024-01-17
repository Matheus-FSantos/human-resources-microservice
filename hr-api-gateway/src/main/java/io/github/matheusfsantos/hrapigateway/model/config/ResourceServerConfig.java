package io.github.matheusfsantos.hrapigateway.model.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	private JwtTokenStore jwtTokenStore;
	
	private static final String[] PUBLIC_ROUTES = {
		"/hr-oauth/oauth/token"
	};
	
	private static final String[] OPERATOR_ROUTES = {
		"/hr-worker/**",
	};
	
	private static final String[] ADMIN_ROUTES = {
		"/hr-user/**",
		"/hr-payroll/**",
		"/actuator/**",
		"/hr-worker/actuator/**",
		"/hr-oauth/actuator/**"
	};
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources
			.tokenStore(jwtTokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(PUBLIC_ROUTES).permitAll()
				.antMatchers(ADMIN_ROUTES).hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, OPERATOR_ROUTES).hasAnyRole("OPERATOR", "ADMIN")
				.anyRequest().authenticated(); /* autentificação obrigatória para qualquer outra rota */
	
		http
			.cors()
				.configurationSource(corsConfigurationSource());
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		
		corsConfig
			.setAllowedOrigins(Arrays.asList("*"));
		
		corsConfig
			.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE"));
		
		corsConfig
			.setAllowCredentials(true);
		
		corsConfig
			.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type"));
		
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfig);
		return urlBasedCorsConfigurationSource;
	}
	
	@Bean
	FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		
		bean
			.setOrder(Ordered.HIGHEST_PRECEDENCE);
		
		return bean;
	}
	
}
