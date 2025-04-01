package com.app.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.aggregator.entity.SocialMediaPost;
import com.app.aggregator.service.SocialMediaService;

import java.util.List;

@RestController
@RequestMapping("/api/social")
@CrossOrigin(origins = "*")
public class SocialMediaController {

    @Autowired
    private SocialMediaService socialMediaService;

    @GetMapping("/posts")
    public ResponseEntity<List<SocialMediaPost>> getSocialMediaPosts(@RequestParam String platform) {
        List<SocialMediaPost> posts = socialMediaService.getPostsFromPlatform(platform);
        return ResponseEntity.ok(posts);
    }
}
