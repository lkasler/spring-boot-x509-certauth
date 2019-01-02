package hu.bridgesoft.prototype.cert.certdemo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Simple X509 Cert base client config.
 * @author kasler
 */
@EnableWebSecurity
public class CertSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
     * Enables x509 client authentication.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // @formatter:off
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .x509()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .csrf()
                .disable();
        // @formatter:on
    }

    /*
     * Create an in-memory authentication manager. We create 2 user (User name must match with
     * the CN name of the client certificate: client, other-client) which has a role of USER.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("client").password("none").roles("USER").
                and().withUser("other-client").password("none").roles("USER");
    }
}