package com.example.springsecuriryshablon.services;

import com.example.springsecuriryshablon.models.Role;
import com.example.springsecuriryshablon.models.User;
import com.example.springsecuriryshablon.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Загружаю юзер детаилс. ");

         User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceAccessException("Нет юзера с таким именем"));

        org.springframework.security.core.userdetails.User userD = new org.springframework.security.core.userdetails.
                User(user.getUsername(),user.getPassword(), mapRolesTuAuthorities(user.getRoles()));

        userD.getAuthorities().stream().forEach(a-> System.out.println("***Authorities: "+a));
        System.out.println("***NAME: "+userD.getUsername());
        System.out.println("***NAME: "+userD.getPassword());

        return userD;
    }
    private Collection<? extends GrantedAuthority> mapRolesTuAuthorities(Collection<Role> roles) {
        roles.stream().forEach(r -> System.out.println("*: "+r.getName()));
        return roles.stream().map(role ->
                new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
