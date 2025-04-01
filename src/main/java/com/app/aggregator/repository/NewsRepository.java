package com.app.aggregator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.aggregator.entity.NewsArticle;
import java.util.List;

public interface NewsRepository extends JpaRepository<NewsArticle, Long> {

    List<NewsArticle> findByCategory(String category);

    // Search by title or content containing keyword
    List<NewsArticle> findByTitleContainingOrContentContaining(String titleKeyword, String contentKeyword);

    // Filter by source
    List<NewsArticle> findBySource(String source);

    // Search by keyword, category, and source
    List<NewsArticle> findByTitleContainingAndCategoryAndSource(String keyword, String category, String source);
}
