package com.mercadolivre.socialmeli.resources;

import com.mercadolivre.socialmeli.dto.PostDTO;
import com.mercadolivre.socialmeli.dto.PromoPostDTO;
import com.mercadolivre.socialmeli.services.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    private PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public ResponseEntity<Void> newPost(@RequestBody PostDTO postDTO){
        service.createPost(postDTO);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/newpromopost", method = RequestMethod.POST)
    public ResponseEntity<Void> newPromoPost(@RequestBody PromoPostDTO promoPostDTO){
        service.createPromoPost(promoPostDTO);
        return ResponseEntity.ok().build();
    }
}
