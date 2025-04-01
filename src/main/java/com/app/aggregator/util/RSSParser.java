package com.app.aggregator.util;

import org.springframework.stereotype.Component;
import org.w3c.dom.*;
import com.app.aggregator.entity.NewsArticle;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
@Component
public class RSSParser {

    public List<NewsArticle> parseRSSFeed(String rssUrl) {
        List<NewsArticle> articles = new ArrayList<>();
        try {
            // ✅ Fix: Avoid deprecated `new URL(String)`
            URI uri = URI.create(rssUrl);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(uri.toURL().openStream());

            NodeList items = doc.getElementsByTagName("item");
            for (int i = 0; i < items.getLength(); i++) {
                Element item = (Element) items.item(i);
                String title = getElementValue(item, "title");
                String link = getElementValue(item, "link");
                String description = getElementValue(item, "description");
                String pubDate = getElementValue(item, "pubDate");

                NewsArticle article = new NewsArticle();
                article.setTitle(title);
                article.setUrl(link);
                article.setContent(description);

                // ✅ Convert `pubDate` to `LocalDateTime`
                DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
                LocalDateTime publishedDate = LocalDateTime.parse(pubDate, formatter);
                article.setPublishedDate(publishedDate);

                articles.add(article);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articles;
    }

    private String getElementValue(Element parent, String tagName) {
        NodeList nodeList = parent.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        }
        return "";
    }
}
