package com.amt.security;

import com.amt.entities.UsersEntity;
import com.amt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by MedMalek on 05/06/2015.
 */
@Service
public class CurrentUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String s) throws UsernameNotFoundException {
        UsersEntity user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User with username=%s was not found", s));
        }
        return new CurrentUser(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toUpperCase()));
    }
}
