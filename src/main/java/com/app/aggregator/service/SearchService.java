package com.app.aggregator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.aggregator.entity.NewsArticle;
import com.app.aggregator.repository.NewsRepository;

import java.util.List;

@Service
public class SearchService {

    @Autowired
    private NewsRepository newsRepository;

    // Search news articles by keyword, category, and source
    public List<NewsArticle> searchNews(String keyword, String category, String source) {
        if (keyword != null && !keyword.isEmpty() && category != null && !category.isEmpty() && source != null && !source.isEmpty()) {
            return newsRepository.findByTitleContainingAndCategoryAndSource(keyword, category, source);
        } else if (keyword != null && !keyword.isEmpty()) {
            return newsRepository.findByTitleContainingOrContentContaining(keyword, keyword);
        } else if (category != null && !category.isEmpty()) {
            return newsRepository.findByCategory(category);
        } else if (source != null && !source.isEmpty()) {
            return newsRepository.findBySource(source);
        }
        return newsRepository.findAll(); // Return all if no filters applied
    }
}
