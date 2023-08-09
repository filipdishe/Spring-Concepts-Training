package com.dishe.vip.security;

import com.dishe.vip.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

            var user = userRepository.findByUsername(username);

            return user
                    .map(MyUserPrincipal::new)
                    .orElseThrow(() -> new UsernameNotFoundException("Username not found: " + username));
    }
}
