package com.app.aggregator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.aggregator.entity.NewsArticle;
import com.app.aggregator.service.RSSFeedService;

import java.util.List;

@RestController
@RequestMapping("/api/rss")
@CrossOrigin(origins = "*")
public class RSSFeedController {

    @Autowired
    private RSSFeedService rssFeedService;

    @GetMapping("/fetch")
    public ResponseEntity<List<NewsArticle>> fetchRSSFeeds() {
        List<NewsArticle> feeds = rssFeedService.fetchRSSFeeds();
        return ResponseEntity.ok(feeds);
    }
}
