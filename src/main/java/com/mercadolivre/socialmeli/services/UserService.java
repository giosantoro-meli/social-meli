package com.mercadolivre.socialmeli.services;

import com.mercadolivre.socialmeli.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

}
