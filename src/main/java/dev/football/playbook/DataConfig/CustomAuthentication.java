package dev.football.playbook.DataConfig;

import dev.football.playbook.Entity.Users;
import dev.football.playbook.Service.implementation.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthentication implements AuthenticationProvider {

        @Autowired
        private UsersServiceImpl usersService;

        @Autowired
        private PasswordEncoder passwordEncoder;


        @Override
        public Authentication authenticate(Authentication authentication) throws AuthenticationException {

            String username = authentication.getName();
            String pwd = authentication.getCredentials().toString();


            Users user = usersService.findByUserName(username);
            System.out.println(username);
            System.out.println(pwd);

            System.out.println(user.getPassword().trim());

            if (passwordEncoder.matches(pwd, user.getPassword().trim())) {
                List<GrantedAuthority> authorities = new ArrayList<>();
                authorities.add(new SimpleGrantedAuthority(user.getRole()));
                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
            } else {
                throw new BadCredentialsException("Invalid password!");
            }
        }

        @Override
        public boolean supports(Class<?> authentication) {

            return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
        }

    }

