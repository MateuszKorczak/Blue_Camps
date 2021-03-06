package org.niebieskidom.bluecamps.services;


import org.niebieskidom.bluecamps.entity.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.niebieskidom.bluecamps.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    private UserService userService;

    @Autowired
    public void setUserRepository(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("W bazie danych nie ma użytkownika: " + username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(r ->
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(), user.getPassword(), grantedAuthorities);
        return (UserDetails) new CurrentUser(user.getUsername(), user.getPassword(),
                grantedAuthorities, user);

    }
}