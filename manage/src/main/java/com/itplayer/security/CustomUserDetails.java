package com.itplayer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetails implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User
        String encode = encoder.encode("123456");
        System.out.println("dbpasswor======" + encode);

        return new LoginManager(username, encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//        return new User(username,"123456",AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }


}
