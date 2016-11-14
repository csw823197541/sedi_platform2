package com.sedi.security;

import com.sedi.entity.UserEntity;
import com.sedi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by csw on 2016/11/11 16:15.
 * Explain:
 */
@Component("sediUserDetailsService")
public class SEDIUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserEntity user = userService.findByUsername(s);
        if(user == null){
            return null;
        } else {
            return new SEDIUserDetails(user);
        }
    }
}
