package com.example.demo.Web.Config;

import com.example.demo.Web.Config.handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalAuthentication
public class SecurityConfig {




    @Autowired
    LoginSuccessHandler loginSuccessHandler;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .formLogin((login) -> login.loginPage("/login")

                        .successHandler(loginSuccessHandler)
                        .loginProcessingUrl("/login")
                        .usernameParameter("j_username")
                        .passwordParameter("j_password")
                        .permitAll());
        http
                .logout((out)->out.permitAll()
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
                );
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/login").anonymous()
                        .requestMatchers("/admin/**").hasAuthority("admin")
                        .requestMatchers("/user").hasAnyAuthority("admin","user")
                        .anyRequest().authenticated()
                );




        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}