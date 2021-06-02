package com.mercadolivre.socialmeli.dto;

import com.mercadolivre.socialmeli.entities.User;

public class UserFollowersCountDTO{
    private Integer userId;
    private String username;
    private Integer followersCount;

    public UserFollowersCountDTO(User user) {
        this.userId = user.getId();
        this.username = user.getUsername();
    }

    public Integer getFollowersCount() {
        return followersCount;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;


    }
}
