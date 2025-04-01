package com.app.aggregator.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "social_media_posts")
public class SocialMediaPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String platform;
    private String username;
    private String content;
    private String url;
    private LocalDateTime postedAt;

    public SocialMediaPost() {}

    public SocialMediaPost(String platform, String username, String content, String url, LocalDateTime postedAt) {
        this.platform = platform;
        this.username = username;
        this.content = content;
        this.url = url;
        this.postedAt = postedAt;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPlatform() { return platform; }
    public void setPlatform(String platform) { this.platform = platform; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public LocalDateTime getPostedAt() { return postedAt; }
    public void setPostedAt(LocalDateTime postedAt) { this.postedAt = postedAt; }
}
