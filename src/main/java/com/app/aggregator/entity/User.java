package com.app.aggregator.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    @Column(unique = true, nullable = false)
    private String email;
    
    @ElementCollection
    @CollectionTable(name = "user_favorite_categories", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "category")
    private Set<String> favoriteCategories = new HashSet<>();

   

    public User() {}

    public User(String username, String password, String email, Set<String> favoriteCategories) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.favoriteCategories = favoriteCategories;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Set<String> getFavoriteCategories() { return favoriteCategories; }
    public void setFavoriteCategories(Set<String> favoriteCategories) { this.favoriteCategories = favoriteCategories; }
}
