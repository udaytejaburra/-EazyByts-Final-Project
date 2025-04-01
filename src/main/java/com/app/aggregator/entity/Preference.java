package com.app.aggregator.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "preferences")
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String preferredSources;
    private String preferredCategories;

    public Preference() {}

    public Preference(User user, String preferredSources, String preferredCategories) {
        this.user = user;
        this.preferredSources = preferredSources;
        this.preferredCategories = preferredCategories;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getPreferredSources() { return preferredSources; }
    public void setPreferredSources(String preferredSources) { this.preferredSources = preferredSources; }

    public String getPreferredCategories() { return preferredCategories; }
    public void setPreferredCategories(String preferredCategories) { this.preferredCategories = preferredCategories; }
}
