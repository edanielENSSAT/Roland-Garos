package com.rollandgaros.tournementmanager.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.rollandgaros.tournementmanager.security.ApplicationUserPermission.*;


public enum ApplicationUserRole {



    PLAYER(Sets.newHashSet(PLAYER_WRITE,PLAYER_READ)),
    MATCH(Sets.newHashSet( MATCH_READ,MATCH_WRITE)),
    ADMIN(Sets.newHashSet(PLAYER_WRITE,PLAYER_READ, MATCH_READ,MATCH_WRITE));

    private  final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission ->new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+ this.name()));
        return permissions;
    }


}
