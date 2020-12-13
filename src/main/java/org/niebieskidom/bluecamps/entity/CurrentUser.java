package org.niebieskidom.bluecamps.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CurrentUser extends User {
    private final org.niebieskidom.bluecamps.entity.User user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities,
                       org.niebieskidom.bluecamps.entity.User user) {
        super(username, password, authorities);
        this.user = user;
    }

    public org.niebieskidom.bluecamps.entity.User getUser() {
        return user;
    }
}