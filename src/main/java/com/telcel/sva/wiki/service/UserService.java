package com.telcel.sva.wiki.service;


import com.telcel.sva.wiki.model.User;
import com.telcel.sva.wiki.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}