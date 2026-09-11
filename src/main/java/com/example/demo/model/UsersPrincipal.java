package com.example.demo.model;

import com.example.demo.util.Permission;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UsersPrincipal implements UserDetails {

    Users users;

    public UsersPrincipal(Users users) {
        this.users = users;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<GrantedAuthority> authorities = new ArrayList<>();

        // Role
        authorities.add(
                new SimpleGrantedAuthority(
                        "ROLE_" + users.getRole().name()
                )
        );

        // Permissions
        for (Permission permission :
                users.getRole().getPermissions()) {

            authorities.add(
                    new SimpleGrantedAuthority(
                            permission.name()
                    )
            );
        }

        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getUsername();
    }

}
