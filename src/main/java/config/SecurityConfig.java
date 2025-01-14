package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Use the injected DataSource for database-based authentication
    @Autowired
    private DataSource dataSource;

    // Inject Custom Authentication Success Handler
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Use JDBC authentication with the provided DataSource
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(new BCryptPasswordEncoder())  // Use injected password encoder
            .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username = ?")
            .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure HTTP security settings
        http.csrf().disable() // Disable CSRF protection
            .authorizeRequests()
                .antMatchers("/register", "/login", "/css/**", "/js/**").permitAll() // Allow public access to register, login, and static resources
                .antMatchers("/users/admin/**").hasRole("ADMIN") // Restrict access to /admin endpoints to ADMIN role only
                .antMatchers("/users/teacher/**").hasRole("TEACHER") // Restrict access to /teacher endpoints to TEACHER role only
                .antMatchers("/users/student/**").hasRole("STUDENT") // Restrict access to /student endpoints to STUDENT role only
                .anyRequest().authenticated() // Other endpoints require authentication
            .and()
            .formLogin()
                .loginPage("/users/loginrole") // Custom login page
                .failureUrl("/users/loginrole?error=true") // Redirect to login page with error if failed
                .permitAll() // Allow all users to access the login page
                .successHandler(customAuthenticationSuccessHandler); // Use custom success handler after successful login
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // Return a BCryptPasswordEncoder bean for password encryption
        return new BCryptPasswordEncoder();
    }
}
