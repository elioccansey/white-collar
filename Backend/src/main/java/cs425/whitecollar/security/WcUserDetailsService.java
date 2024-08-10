package cs425.whitecollar.security;


import cs425.whitecollar.entity.user.User;
import cs425.whitecollar.entity.user.role.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;


@Component
public class WcUserDetailsService implements UserDetailsService {



    private User userRes;

    private static final Logger LOGGER = LoggerFactory.getLogger(WcUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        userRes = null;// client.fetchUser(email);
        if(userRes == null){
            LOGGER.info("Could not findUser with email = " + email);
            throw new UsernameNotFoundException("Could not findUser with email = " + email);}
        return new org.springframework.security.core.userdetails.User(
                email,
                userRes.getPassword(),
                getAuthorities());
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<UserRole> rolesN = userRes.getRoles();

        List<SimpleGrantedAuthority> authories = new ArrayList<>();

        for (UserRole role : rolesN) {
            authories.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
        }

        return authories;
    }



}
