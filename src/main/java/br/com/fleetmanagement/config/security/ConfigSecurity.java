package br.com.fleetmanagement.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfigSecurity {
	@Autowired
	private SecurityFilter securityFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(HttpMethod.GET, "/login").permitAll()
						.requestMatchers(HttpMethod.GET, "/html/login.html").permitAll()
						.requestMatchers(HttpMethod.POST, "/usuario/cadastrado/login").permitAll()
						.requestMatchers(HttpMethod.POST, "/usuario/cadastrado/registrar").permitAll()
					    .requestMatchers(HttpMethod.POST, "/cadastro/veiculo-preposto").hasRole("ADMIN")
					    .requestMatchers(HttpMethod.POST, "/veiculo/cadastrado/frota/veicular").hasRole("ADMIN")
					    .requestMatchers(HttpMethod.POST, "/api/rota/salvar").hasRole("ADMIN")
					    .requestMatchers(HttpMethod.POST, "/documentos/upload").hasRole("ADMIN")
					    //GETTER AS INFORMATION IN SYSTEM REQUER AUTH USER 
					    .requestMatchers(HttpMethod.GET, "/index").hasRole("USER")
					    .requestMatchers(HttpMethod.GET, "/html/index.html").hasRole("USER")
					    .requestMatchers(HttpMethod.GET, "/css/style.css").hasRole("USER")
					    .requestMatchers(HttpMethod.GET, "/js/script.js").hasRole("USER")
					    .requestMatchers(HttpMethod.GET, "/veiculo/cadastrado").hasRole("USER")
					    .requestMatchers(HttpMethod.GET, "/usuario/cadastrado").hasRole("USER")
					    .requestMatchers(HttpMethod.GET, "/operador/operadoras").hasRole("USER")
					    .requestMatchers(HttpMethod.GET, "/preposto/motorista").hasRole("USER")
					    .requestMatchers(HttpMethod.GET, "/api/rota/geojson").hasRole("USER")
					    .requestMatchers(HttpMethod.GET, "/servico/prestado").hasRole("USER")
					    .requestMatchers(HttpMethod.GET, "/rota/trajeto").hasRole("USER")
					    .anyRequest().authenticated()
					)
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
}
