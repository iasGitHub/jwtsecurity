package sn.ias.servicesecurityjwt.service;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sn.ias.servicesecurityjwt.entities.AppUser;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private AccountService accountService;
    private Converter converter;

    public UserDetailsServiceImpl(AccountService accountService, Converter converter) {
        this.accountService = accountService;
        this.converter = converter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = converter.AppUserDtoToAppUserEntity(accountService.loadAppUserByUsername(username));
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        appUser.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getName()));
        });

        return new User(appUser.getUsername(), appUser.getPassword(), authorities);
    }
}
