package com.mercadolivre.socialmeli.services;

import com.mercadolivre.socialmeli.dto.PostDTO;
import com.mercadolivre.socialmeli.dto.ProductDTO;
import com.mercadolivre.socialmeli.dto.PromoPostDTO;
import com.mercadolivre.socialmeli.entities.Post;
import com.mercadolivre.socialmeli.entities.Product;
import com.mercadolivre.socialmeli.entities.User;
import com.mercadolivre.socialmeli.repositories.PostRepository;
import com.mercadolivre.socialmeli.repositories.ProductRepository;
import com.mercadolivre.socialmeli.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, ProductRepository productRepository, UserRepository userRepository){
        this.postRepository = postRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    public void createPost(PostDTO postDTO){
        Integer userId = postDTO.getUserId();
        User user = userRepository.getById(userId);
        if(!user.getIsSeller()) user.setSeller(true);

        Product product = new Product(postDTO.getDetail());
        Post post = new Post(user, postDTO.getDate(), product, postDTO.getCategory(), postDTO.getPrice());

        productRepository.save(product);
        postRepository.save(post);
        userRepository.save(user);
    }

    public void createPromoPost(PromoPostDTO promoPostDTO){
        Integer userId = promoPostDTO.getUserId();
        User user = userRepository.getById(userId);
        if(!user.getIsSeller()) user.setSeller(true);

        Product promoProduct = new Product(promoPostDTO.getDetail());
        Post promoPost = new Post(user, promoPostDTO.getDate(), promoProduct, promoPostDTO.getCategory(),
                promoPostDTO.getPrice(), promoPostDTO.getHasPromo(), promoPostDTO.getDiscount());

        productRepository.save(promoProduct);
        postRepository.save(promoPost);
        userRepository.save(user);
    }
}
