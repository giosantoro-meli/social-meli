package com.mercadolivre.socialmeli.dto;

import com.mercadolivre.socialmeli.entities.User;

import java.util.HashSet;
import java.util.Set;

public class UserFollowedListDTO{
    private final Integer userId;
    private final String username;
    private Set<UserDTO> followed = new HashSet<>();

    public UserFollowedListDTO(User user) {
        this.userId = user.getId();
        this.username = user.getUsername();
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public Set<UserDTO> getFollowed() {
        return followed;
    }

    public void setFollowed(Set<UserDTO> followed) {
        this.followed = followed;
    }
}
