package com.mercadolivre.socialmeli.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;

    @ManyToMany
    @JoinTable(name="user_follows",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns={@JoinColumn(name="followed_id")})
    private Set<User> followed = new HashSet<>();

    @ManyToMany(mappedBy = "followed")
    private Set<User> followers = new HashSet<>();

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Post> posts = new ArrayList<>();

    public User(){}

    public User(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Set<User> getFollowed() {
        return followed;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return id.equals(user.id) && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}
