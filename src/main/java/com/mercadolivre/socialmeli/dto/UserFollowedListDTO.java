package com.mercadolivre.socialmeli.dto;

import com.mercadolivre.socialmeli.entities.User;

import java.util.HashSet;
import java.util.Set;

public class UserFollowedListDTO extends UserDTO{
    private Set<UserDTO> followed = new HashSet<>();

    public UserFollowedListDTO(User user) {
        super(user);
    }

    public Set<UserDTO> getFollowed() {
        return followed;
    }

    public void setFollowed(Set<UserDTO> followed) {
        this.followed = followed;
    }
}
