package dev.football.playbook.DataConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.cglib.core.Customizer.*;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


        @Autowired
        @Qualifier("securityDataSource")
        private DataSource securityDataSource;

        @Autowired
        private CustomAuthentication authProvider;

        @Autowired
        private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

        @Bean
        public AuthenticationManager authManager(HttpSecurity http) throws Exception {
            AuthenticationManagerBuilder authenticationManagerBuilder =
                    http.getSharedObject(AuthenticationManagerBuilder.class);
            authenticationManagerBuilder.authenticationProvider(authProvider);
            return authenticationManagerBuilder.build();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http.authorizeHttpRequests((auth) -> {

                                try {
                                    auth

                                            .requestMatchers("/Admin/**").hasRole("ADMIN")
                                            .requestMatchers("/Business/**").hasAnyRole("ADMIN","CUSTOMER","EMPLOYEE")
                                            .requestMatchers("/Employee/**").hasAnyRole("ADMIN","EMPLOYEE")
                                            .requestMatchers("/Customer/**").hasAnyRole("ADMIN", "CUSTOMER")
                                            .requestMatchers( "/User/**").hasAnyRole("ADMIN","CUSTOMER","EMPLOYEE")
                                            .requestMatchers("/**","/Welcome/**", "/Login/**").permitAll();
                                } catch (Exception e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }

                    ).formLogin(form -> form
                            .loginPage("/Login/SignIn")
                            .loginProcessingUrl("/authenticateTheUser")
                            .successHandler(customAuthenticationSuccessHandler)
                            .permitAll()
                    )
                    .logout((logout) -> logout
                            .logoutSuccessUrl("/Login/LoginPage")
                            .permitAll())
                    .exceptionHandling((exceptionHandling) -> exceptionHandling
                            .accessDeniedPage("/access-denied")
                    )
                    .httpBasic(withDefaults());

            return http.build();
        }

        @Bean
        public static PasswordEncoder passwordEncoder() {//needs to be static to avoid circular reference exception

            String idForEncode = "bcrypt";
            Map<String, PasswordEncoder> encoders = new HashMap<>();
            encoders.put(idForEncode, new BCryptPasswordEncoder());

            PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder(idForEncode, encoders);

            return passwordEncoder;
        }


    }


