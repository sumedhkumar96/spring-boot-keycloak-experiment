package xyz.experimental.apigateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoders;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

	@Value("${spring.security.oauth2.client.provider.keycloak.issuerUri}")
	private String issuerUri;

	@Bean
	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
		http.authorizeExchange()
				// allowing sign-up, login, config-server APIs for direct access
				.pathMatchers("/api/users/sign-up").permitAll().pathMatchers("/config-server/**").permitAll()
				.pathMatchers("/login").permitAll()
				// all other APIs are authenticated
				.anyExchange().authenticated().and().csrf().disable().oauth2Login().and().oauth2ResourceServer().jwt();
		return http.build();
	}

	@Bean
	public ReactiveJwtDecoder jwtDecoder() {
		return ReactiveJwtDecoders.fromOidcIssuerLocation(issuerUri);
	}

}
