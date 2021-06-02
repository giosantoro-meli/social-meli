package com.mercadolivre.socialmeli.dto;

import com.mercadolivre.socialmeli.entities.User;

import java.util.HashSet;
import java.util.Set;

public class UserFollowersListDTO{
    private final Integer userId;
    private final String username;
    private Set<UserDTO> followers = new HashSet<>();

    public UserFollowersListDTO(User user) {
        this.userId = user.getId();
        this.username = user.getUsername();
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Set<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<UserDTO> followers) {
        this.followers = followers;
    }
}
