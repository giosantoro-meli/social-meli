package com.mercadolivre.socialmeli.resources;

import com.mercadolivre.socialmeli.dto.UserDTO;
import com.mercadolivre.socialmeli.dto.UserFollowedListDTO;
import com.mercadolivre.socialmeli.dto.UserFollowersCountDTO;
import com.mercadolivre.socialmeli.dto.UserFollowersListDTO;
import com.mercadolivre.socialmeli.entities.User;
import com.mercadolivre.socialmeli.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService service;

    public UserController(UserService service){
        this.service = service;
    }

    @RequestMapping(value = "/{userId}/follow/{userIdToFollow}", method = RequestMethod.POST)
    public ResponseEntity<Void> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow){
        User user = service.follow(userId, userIdToFollow);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/{userId}/followers/count", method = RequestMethod.GET)
    public ResponseEntity<UserFollowersCountDTO> getUserFollowersCount(@PathVariable Integer userId){
        UserFollowersCountDTO userFollowersCount = service.getUserFollowersCount(userId);
        return ResponseEntity.ok(userFollowersCount);
    }

    @RequestMapping(value = "/{userId}/followers/list", method = RequestMethod.GET)
    public ResponseEntity<UserFollowersListDTO> getUserFollowersList(@PathVariable Integer userId){
        UserFollowersListDTO userFollowersListDTO = service.getUserFollowersList(userId);
        return ResponseEntity.ok(userFollowersListDTO);
    }

    @RequestMapping(value = "/{userId}/followed/list", method = RequestMethod.GET)
    public ResponseEntity<UserFollowedListDTO> getUserFollowedList(@PathVariable Integer userId){
        UserFollowedListDTO userFollowedListDTO = service.getUserFollowedList(userId);
        return ResponseEntity.ok(userFollowedListDTO);
    }
}
