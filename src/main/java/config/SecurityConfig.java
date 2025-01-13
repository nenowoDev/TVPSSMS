package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//using database auth
	@Autowired
	 private DataSource dataSource;
	
	@Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler; // Inject the custom handler
		
		    @Override
		    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		        auth.jdbcAuthentication()
		            .dataSource(dataSource)
		            .passwordEncoder(new BCryptPasswordEncoder())
		            .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
		            .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");
		    }


//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		
//		auth
//		.inMemoryAuthentication().withUser("admin")
//		.password(passwordEncoder().encode("admin123"))
//		.roles("ADMIN")
//		.and()
//		.withUser("customer")
//		.password("{noop}customer123")
//		.roles("CUSTOMER");
//	}
//	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		 http.csrf().disable() // Disable CSRF protection
		.authorizeRequests()
        .antMatchers("/register", "/login", "/css/**", "/js/**").permitAll() // Allow public access
        .anyRequest().authenticated() // Restrict access to other endpoints
		.and()
		.formLogin()
		.loginPage("/users/loginrole") // Specify your custom login page
		.permitAll()
		 .successHandler(customAuthenticationSuccessHandler); // Use the custom success handler
		
	
	}
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

