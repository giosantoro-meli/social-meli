package com.mercadolivre.socialmeli.services;

import com.mercadolivre.socialmeli.repositories.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository){
        this.repository = repository;
    }
}
