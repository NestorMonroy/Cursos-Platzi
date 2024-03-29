package com.nestor.market.web.security;

import com.nestor.market.domain.service.NestorUserDetailsService;
import com.nestor.market.web.security.filter.JwtFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private NestorUserDetailsService nestorUserDetailsService;

    @Autowired
    private JwtFilterRequest jwtFilterRequest;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(nestorUserDetailsService);
    }

    //https://thearjunmdas.github.io/entries/authorization-field-in-swagger-ui/
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui",
                "/swagger-resources/**", "/configuration/security",
                "/swagger-ui.html", "/webjars/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Todas las peticiones que terminan en authenticate las permite **
        http.csrf().disable().authorizeRequests().antMatchers("/**/authenticate").permitAll().
                anyRequest().authenticated().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilterRequest, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
