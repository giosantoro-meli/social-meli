package com.mercadolivre.socialmeli.dto;

import com.mercadolivre.socialmeli.entities.User;

public class UserFollowersCountDTO extends UserDTO{
    private final Integer followersCount;

    public UserFollowersCountDTO(User user, Integer followersCount) {
        super(user);
        this.followersCount = followersCount;
    }

    public Integer getFollowersCount() {
        return followersCount;
    }
}
