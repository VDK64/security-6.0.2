package com.example.basicAuth.entities;

import com.example.basicAuth.config.security.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Entity(name = "usr")
@Table(name = "usr")
public class Usr implements UserDetails {

    @Id
    @GeneratedValue
    private long id;

    private String firstname;

    private String lastname;

    private String password;

    private String username;

    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private boolean enabled;

    public Usr() {
    }

    public Usr(String firstname, String lastname, String password, String username, Set<UserRole> roles) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
        this.roles = roles;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> permissions = roles.stream()
                .flatMap(userRole -> userRole.getPermissions().stream())
                .map(userPermission -> new SimpleGrantedAuthority(userPermission.getPermission()))
                .collect(Collectors.toSet());

        roles.forEach(role -> permissions.add(new SimpleGrantedAuthority("ROLE_" + role.name())));
        return permissions;
    }

}


