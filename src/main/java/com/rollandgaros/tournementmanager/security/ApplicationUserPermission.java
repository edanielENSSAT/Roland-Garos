package com.rollandgaros.tournementmanager.security;

public enum ApplicationUserPermission {
    PLAYER_READ("player:read"),
    PLAYER_WRITE("player:write"),
    MATCH_READ("match:read"),
    MATCH_WRITE("match:write");



    private final String permission;


    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
