package com.app.aggregator.util;

import com.app.aggregator.entity.SocialMediaPost;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class SocialMediaAPIClient {

    private static final String TWITTER_API_URL = "https://api.twitter.com/2/tweets/search/recent?query=";
    private static final String FACEBOOK_API_URL = "https://graph.facebook.com/v12.0/search?q=";

    private static final String TWITTER_BEARER_TOKEN = "YOUR_TWITTER_BEARER_TOKEN";
    private static final String FACEBOOK_ACCESS_TOKEN = "YOUR_FACEBOOK_ACCESS_TOKEN";

    private final RestTemplate restTemplate;

    public SocialMediaAPIClient() {
        this.restTemplate = new RestTemplate();
    }

    public List<SocialMediaPost> fetchNewsFromSocialMedia(String keyword) {
        List<SocialMediaPost> posts = new ArrayList<>();

        // ✅ Fetch from Twitter API with Authorization Header
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + TWITTER_BEARER_TOKEN);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<String> twitterResponse = restTemplate.exchange(
                TWITTER_API_URL + keyword, HttpMethod.GET, entity, String.class);
        
        if (twitterResponse.getBody() != null) {
            JSONArray jsonArray = new JSONObject(twitterResponse.getBody()).optJSONArray("data");
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    SocialMediaPost post = new SocialMediaPost();
                    post.setPlatform("Twitter");
                    post.setContent(obj.optString("text"));
                    posts.add(post);
                }
            }
        }

        // ✅ Fetch from Facebook API with Authorization Header
        headers.set("Authorization", "Bearer " + FACEBOOK_ACCESS_TOKEN);
        entity = new HttpEntity<>(headers);

        ResponseEntity<String> facebookResponse = restTemplate.exchange(
                FACEBOOK_API_URL + keyword, HttpMethod.GET, entity, String.class);
        
        if (facebookResponse.getBody() != null) {
            JSONArray jsonArray = new JSONObject(facebookResponse.getBody()).optJSONArray("data");
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject obj = jsonArray.getJSONObject(i);
                    SocialMediaPost post = new SocialMediaPost();
                    post.setPlatform("Facebook");
                    post.setContent(obj.optString("message"));
                    posts.add(post);
                }
            }
        }

        return posts;
    }
}
