package com.prudvi.jpeproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
//@EnableWebSecurity
public class WebSecurityConfig {

	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception {
	 * 
	 * // by default uses a Bean by the name of corsConfigurationSource
	 * http.cors(withDefaults()); http .cors().and().csrf().disable()
	 * .authorizeRequests() .requestMatchers("*").permitAll();
	 * //.anyRequest().authenticated();
	 * 
	 * return http.build(); }
	 */

	/*
	 * @Bean CorsConfigurationSource corsConfigurationSource() { CorsConfiguration
	 * configuration = new CorsConfiguration();
	 * configuration.setAllowedOrigins(Arrays.asList("http://192.168.43.3"));
	 * //configuration.setAllowedOrigins("*");
	 * configuration.setAllowedMethods(Arrays.asList("GET","POST"));
	 * UrlBasedCorsConfigurationSource source = new
	 * UrlBasedCorsConfigurationSource(); source.registerCorsConfiguration("/**",
	 * configuration); return source; }
	 */
	public WebMvcConfigurer corsConfigure() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
				.allowedOrigins("*");
			}
		};
	}

}
