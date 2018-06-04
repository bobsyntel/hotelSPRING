package com.bob.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter{
	
		@Autowired
		private UserDetailsService userDetailsService;
//		public WebSecurityConfig(UserDetailsService userDetailsService) {
//			this.userDetailsService = userDetailsService;
//		}
		
//		protected void configure(HttpSecurity http) throws Exception {
//			http.cors().and()...		
//			
//		}

		
		@Bean
		public BCryptPasswordEncoder bCryptPasswordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
//		 @Override
//		    public void configure( WebSecurity web ) throws Exception
//		    {
//		        web.ignoring().antMatchers( HttpMethod.OPTIONS, "/**" );
//		    }
		@Override
		protected void configure(HttpSecurity http) throws Exception{
				http.
					cors()
					.and();
//				http.
//					authorizeRequests()
//					.antMatchers("/", "/home").permitAll()
//					.anyRequest().authenticated()
//					.and()
//				.formLogin()
//				.loginPage("/login")
//					.permitAll()
//					.and()
//				.logout()
//					.permitAll()
//				;
		}
		
		@Bean
		CorsConfigurationSource corsConfigurationSource() {
			CorsConfiguration configuration = new CorsConfiguration();
			configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000/signup"));
			configuration.setAllowedMethods(Arrays.asList("GET","POST"));
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", configuration);
			return source;
		}
		

		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
			auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
		}

}
