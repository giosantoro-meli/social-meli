package com.mercadolivre.socialmeli.services;

import com.mercadolivre.socialmeli.dto.UserDTO;
import com.mercadolivre.socialmeli.dto.UserFollowedListDTO;
import com.mercadolivre.socialmeli.dto.UserFollowersCountDTO;
import com.mercadolivre.socialmeli.dto.UserFollowersListDTO;
import com.mercadolivre.socialmeli.entities.User;
import com.mercadolivre.socialmeli.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    //TODO limitar seguidores apenas para vendedores
    public User follow(Integer userId, Integer userToFollowId){
        User user = repository.getById(userId);
        User userToFollow = repository.getById(userToFollowId);

        userToFollow.getFollowed().add(user);

        repository.saveAll(Arrays.asList(user, userToFollow));

       return user;
    }

    public User unfollow(Integer userId, Integer userIdToUnfollow){
        User user = repository.getById(userId);
        User userToUnfollow = repository.getById(userIdToUnfollow);

        userToUnfollow.getFollowed().remove(user);

        repository.saveAll(Arrays.asList(user, userToUnfollow));

        return user;
    }

    public UserFollowersCountDTO getUserFollowersCount(Integer userId){
        User user = repository.getById(userId);
        UserFollowersCountDTO userFollowersCountDTO = new UserFollowersCountDTO(user);
        userFollowersCountDTO.setFollowersCount(user.getFollowed().size());

        return userFollowersCountDTO;
    }

    public UserFollowersListDTO getUserFollowersList(Integer userId){
        User user = repository.getById(userId);
        UserFollowersListDTO userFollowersListDTO = new UserFollowersListDTO(user);
        userFollowersListDTO.setFollowers(user.getFollowed().stream().map(UserDTO::new).collect(Collectors.toSet()));
        return userFollowersListDTO;
    }

    public UserFollowedListDTO getUserFollowedList(Integer userId){
        User user = repository.getById(userId);
        UserFollowedListDTO userFollowedListDTO = new UserFollowedListDTO(user);
        userFollowedListDTO.setFollowed(user.getFollowers().stream().map(UserDTO::new).collect(Collectors.toSet()));
        return userFollowedListDTO;
    }
}
