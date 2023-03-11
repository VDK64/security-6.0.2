package com.example.basicAuth.entities;

import com.example.basicAuth.config.security.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "usr")
@Table(name = "usr")
public class Usr implements UserDetails {

    @Id
    @GeneratedValue
    private long id;

    private final String firstname;

    private final String lastname;

    private String password;

    private final String username;

    @Enumerated(EnumType.STRING)
    private final Set<UserRole> roles;

    private final boolean accountNonExpired;

    private final boolean accountNonLocked;

    private final boolean credentialsNonExpired;

    private final boolean enabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return authorities;
    }

}


