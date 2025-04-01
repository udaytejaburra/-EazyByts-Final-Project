package com.app.aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aggregator.entity.NewsArticle;
import com.app.aggregator.repository.NewsRepository;
import com.app.aggregator.util.RSSParser;

import java.util.List;

@Service
public class RSSFeedService {

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private RSSParser rssParser;

    // Fetch and store news from a default RSS feed URL
    public List<NewsArticle> fetchRSSFeeds() {
        String rssUrl = "https://example.com/rss"; // Set a default RSS feed URL
        List<NewsArticle> articles = rssParser.parseRSSFeed(rssUrl);
        newsRepository.saveAll(articles);
        return articles;
    }
}
