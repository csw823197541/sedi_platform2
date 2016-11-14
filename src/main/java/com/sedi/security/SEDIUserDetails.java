package com.sedi.security;

import com.sedi.entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by csw on 2016/11/11 16:22.
 * Explain:
 */
public class SEDIUserDetails implements UserDetails{

    private UserEntity userEntity;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set grantedAuthority = new HashSet();
        if (userEntity != null) {
            grantedAuthority.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_ADMIN";
                }
            });
        } else {
            grantedAuthority.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "ROLE_USER";
                }
            });
        }
        return grantedAuthority;
    }

    public SEDIUserDetails(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getPassword() {
        return userEntity != null ? userEntity.getPassword() : null;
    }

    public String getUsername() {
        return userEntity != null ? userEntity.getUsername() : null;
    }

    //是否过期
    public boolean isAccountNonExpired() {
        return true;
    }

    //账户未锁定为true
    public boolean isAccountNonLocked() {
        return true;
    }

    //证书不过期为true
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //是否可用
    public boolean isEnabled() {
        return true;
    }
}
