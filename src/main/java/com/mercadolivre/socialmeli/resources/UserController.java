package com.mercadolivre.socialmeli.resources;

import com.mercadolivre.socialmeli.dto.UserDTO;
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
}
