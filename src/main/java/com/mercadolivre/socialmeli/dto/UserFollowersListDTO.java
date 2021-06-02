package com.mercadolivre.socialmeli.dto;

import com.mercadolivre.socialmeli.entities.User;

import java.util.HashSet;
import java.util.Set;

public class UserFollowersListDTO extends UserDTO{
    private Set<UserDTO> followers = new HashSet<>();

    public UserFollowersListDTO(User user) {
        super(user);
    }

    public Set<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<UserDTO> followers) {
        this.followers = followers;
    }
}
