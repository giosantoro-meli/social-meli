package com.mercadolivre.socialmeli.dto;

import com.mercadolivre.socialmeli.entities.User;

public class UserDTO {
    private Integer userId;
    private String name;

    public UserDTO(User user){
        this.userId = getUserId();
        this.name = getName();
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
}
