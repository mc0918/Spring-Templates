package com.example.securityjdbcjpatemplate.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration //we need this code to run before the application starts
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        /* Change prepared statements below to suit your needs */

        authenticationManagerBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username = ?"
                )
                .authoritiesByUsernameQuery(
                        "select username, authority from authorities where username = ?"
                )
                .passwordEncoder(encoder);
    }

    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.httpBasic();

//        Better practice is to just use .hasAuthority() and assign one user multiple authorities in the database
//          Easier to control by updating the database than updating the code
        /* Change endpoints below to your own endpoints, same with authorities */

        httpSecurity.authorizeRequests()
                .mvcMatchers("/endpoint1").hasAnyAuthority("AUTHORIZED_USER", "ADMIN")
                .mvcMatchers("/endpoint2").hasAuthority("ADMIN")
                .mvcMatchers(HttpMethod.DELETE, "/endpoint3/*").hasAuthority("ADMIN") //need to use authorization in postman (basic auth), add XSRF cookie (X-XSRF-TOKEN)
                .anyRequest().permitAll();

        httpSecurity
                .logout() //when a user logs out
                .clearAuthentication(true) // we clear their authentication information
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // list of urls available to logout
                .logoutSuccessUrl("/allDone") // logout confirmation
                .deleteCookies("JSESSIONID") // JSESSIONID holds info about session
                .deleteCookies("XSRF-TOKEN") // XSRF prevents CSRF attacks
                .invalidateHttpSession(true); // users need to re-login when they come back
        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());

    }
}
