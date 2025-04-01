package com.app.aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.aggregator.entity.NewsArticle;
import com.app.aggregator.repository.NewsRepository;
import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    // Fetch all news articles
    public List<NewsArticle> getAllNews() {
        return newsRepository.findAll();
    }

    // Fetch news by category
    public List<NewsArticle> getNewsByCategory(String category) {
        return newsRepository.findByCategory(category);
    }

    // Search news by keyword
    public List<NewsArticle> searchNews(String keyword) {
        return newsRepository.findByTitleContainingOrContentContaining(keyword, keyword);
    }

    // Save a new news article
    public NewsArticle saveNews(NewsArticle article) {
        return newsRepository.save(article);
    }

    // Fetch news by ID
    public Optional<NewsArticle> getNewsById(Long id) {
        return newsRepository.findById(id);
    }

    public List<NewsArticle> filterByCategory(String category) {
        return newsRepository.findByCategory(category);
    }

    public List<NewsArticle> getNewsBySource(String source) {
        return newsRepository.findBySource(source);
    }
}
