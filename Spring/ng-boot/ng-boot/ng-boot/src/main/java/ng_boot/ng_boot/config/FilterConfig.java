//package ng_boot.ng_boot.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import ng_boot.ng_boot.security.JwtAuthenticationFilter;
//
//@Configuration
//public class FilterConfig {
//
//	  @Autowired
//	  JwtAuthenticationFilter bearerTokenAuthFilter;
//
//	    @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//	        http
//	                .authorizeHttpRequests(request -> {
//	                    request.requestMatchers("/login").permitAll();
//	                    request.anyRequest().authenticated();
//	                })
//	                .csrf(AbstractHttpConfigurer::disable)
//	                .addFilterAfter(bearerTokenAuthFilter, BasicAuthenticationFilter.class);
//	        return http.build();
//	    }
//}
