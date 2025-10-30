package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import jakarta.servlet.DispatcherType;

@Configuration
public class WebSecurityConfig {
	
	@Autowired
	public AuthenticationFailureHandler afh;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.csrf((csrf) -> csrf.disable())
			.cors((cors) -> cors.disable())
			.authorizeHttpRequests(request -> request
					.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
					.requestMatchers("/").permitAll()
					.requestMatchers("/css/**", "/js/**", "/img/**").permitAll()
					.requestMatchers("/guest/**").permitAll()
					.requestMatchers("/member/**").hasAnyRole("USER", "ADMIN")
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
		);
		
		// springboot에서 제공해주는 기본 login폼
		// http.formLogin((formLogin) -> formLogin.permitAll());
		
		// 내가 만든폼
		http.formLogin((formLogin) -> formLogin
				.loginPage("/loginForm")
				.loginProcessingUrl("/login_check")
				//.failureUrl("/loginError")  //  /login?error
				.failureHandler(afh)
				.usernameParameter("username")
				.passwordParameter("pwd")
				.defaultSuccessUrl("/",true)
				.permitAll()
				);
		http.logout((logout) -> logout.permitAll());
		
		return http.build();
	}
	
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder()
				.username("user")
				.password(passwordEncoder().encode("1234"))
				.roles("USER")
				.build();
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("1234"))
				.roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}