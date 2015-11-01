package com.amt.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by MedMalek on 06/06/2015.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {
    public CurrentUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public CurrentUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}