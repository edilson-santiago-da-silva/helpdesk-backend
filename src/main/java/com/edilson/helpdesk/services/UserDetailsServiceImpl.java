package com.edilson.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.edilson.helpdesk.domain.Person;
import com.edilson.helpdesk.repositories.PersonRepository;
import com.edilson.helpdesk.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Person> user = repository.findByEmail(email);
        if (user.isPresent()) {
            return new UserSS(user.get().getId(), user.get().getEmail(), user.get().getPassword(), user.get().getProfile());
        }
        throw new UsernameNotFoundException(email);
    }
}
