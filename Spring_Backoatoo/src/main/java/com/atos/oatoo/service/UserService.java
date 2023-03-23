package com.atos.oatoo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.atos.oatoo.models.User;
import com.atos.oatoo.repository.IUserRepository;


@Service
public class UserService {

    private IUserRepository repository;


    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserService(IUserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public User authenticate(String email, String password) {
        User user = null;
        user = repository.findUserByEmail(email);

        if (user == null) {
            return null;
        }

        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            return null;
        }

        return user;
    }
}
