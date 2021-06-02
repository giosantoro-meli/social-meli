package com.mercadolivre.socialmeli.services;

import com.mercadolivre.socialmeli.dto.UserDTO;
import com.mercadolivre.socialmeli.dto.UserFollowersCountDTO;
import com.mercadolivre.socialmeli.entities.User;
import com.mercadolivre.socialmeli.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User follow(Integer userId, Integer userToFollowId){
        User user = repository.getById(userId);
        User userToFollow = repository.getById(userToFollowId);

        userToFollow.getFollowed().add(user);

        repository.saveAll(Arrays.asList(user, userToFollow));

       return user;
    }

    public UserFollowersCountDTO getUserFollowersCount(Integer userId){
        User user = repository.getById(userId);
        UserFollowersCountDTO userFollowersCountDTO = new UserFollowersCountDTO(user);
        userFollowersCountDTO.setFollowersCount(user.getFollowed().size());

        return userFollowersCountDTO;
    }
}
