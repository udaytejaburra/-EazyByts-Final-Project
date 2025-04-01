# News Aggregator Website

A full-stack **News Aggregator Website** that collects news from various sources (RSS Feeds, APIs, and Social Media). Built using **Spring Boot (Java) + MySQL/PostgreSQL + HTML/CSS/JavaScript**.

---
## 🚀 Features
✅ User Authentication (Login/Register) using Spring Security
✅ Fetches and aggregates news from RSS feeds & APIs
✅ Supports filtering, search, and categories
✅ Saves user preferences and favorite articles
✅ Secure session-based authentication
✅ Responsive UI with HTML5, CSS3, and JavaScript

---
##  Project Structure

```
├── src/main/java/com/app/aggregator
│   ├── controller/
│   │   ├── NewsController.java          # Handles news-related API requests
│   │   ├── UserController.java          # Manages user authentication & preferences
│   │   ├── SearchController.java        # Search & filtering functionality
│   │   ├── SocialMediaController.java   # Fetches news from Twitter, Facebook, etc.
│   │   ├── RSSFeedController.java       # Fetches & processes RSS feeds
│   ├── model/
│   │   ├── NewsArticle.java             # Entity for news articles
│   │   ├── User.java                    # Entity for user accounts
│   │   ├── Preference.java              # Stores user preferences
│   │   ├── SocialMediaPost.java         # Represents social media posts
│   ├── repository/
│   │   ├── NewsRepository.java          # JPA Repository for News
│   │   ├── UserRepository.java          # JPA Repository for Users
│   │   ├── PreferenceRepository.java    # Stores & retrieves user preferences
│   ├── service/
│   │   ├── NewsService.java             # Fetches news from APIs
│   │   ├── UserService.java             # Manages user authentication & favorites
│   │   ├── RSSFeedService.java          # Parses & stores RSS feed data
│   │   ├── SocialMediaService.java      # Handles fetching news from social media
│   │   ├── SearchService.java           # Implements filtering & search
│   ├── config/
│   │   ├── WebSecurityConfig.java       # Security configurations
│   │   ├── AppConfig.java               # External API & database configurations
│   ├── util/
│   │   ├── RSSParser.java               # Parses RSS feed XML data
│   │   ├── SocialMediaAPIClient.java    # Connects with Twitter/Facebook API
│   ├── NewsAggregatorApplication.java   # Main Spring Boot entry point
│
├── src/main/resources
│   ├── static/
│   │   ├── styles.css                   # CSS file for frontend styling
│   │   ├── script.js                    # JavaScript for API calls & UI interactions
│   ├── templates/
│   │   ├── index.html                   # Homepage
│   │   ├── news.html                    # Displays fetched news articles
│   │   ├── login.html                   # User login page
│   │   ├── dashboard.html               # User dashboard
│   │   ├── search.html                  # Search & filter results
│   │   ├── social.html                  # Social media news page
│
└── pom.xml                               # Project dependencies (Maven)
```

---
## 🛠 Setup Instructions

### 📌 Prerequisites
- Install **Java 17+**
- Install **Maven**
- Install **MySQL/PostgreSQL**

### 🔧 Steps to Run
1️⃣ **Clone the repository:**
```sh
git clone https://github.com/your-repo/news-aggregator.git
cd news-aggregator
```
2️⃣ **Set up the database** (MySQL/PostgreSQL):
```sh
CREATE DATABASE news_aggregator;
```
3️⃣ **Configure `application.properties`:**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/news_aggregator
spring.datasource.username=root
spring.datasource.password=yourpassword
```
4️⃣ **Run the application:**
```sh
mvn clean spring-boot:run
```
5️⃣ **Open the app in your browser:**
```sh
http://localhost:8080/
```

---
## 🔗 API Endpoints

| Endpoint              | Method | Description                        |
|----------------------|--------|--------------------------------|
| `/api/news`          | GET    | Fetches news articles        |
| `/api/users/register` | POST   | Registers a new user        |
| `/api/users/login`    | POST   | Authenticates user login    |
| `/api/favorites`      | GET/POST | Saves and fetches user favorites |
| `/api/search`         | GET    | Filters news articles       |

---
## 🐛 Troubleshooting

**1️⃣ Issue: `localhost redirected you too many times (ERR_TOO_MANY_REDIRECTS)`**  
✅ **Fix:** Clear cookies & modify `WebSecurityConfig.java` to remove unnecessary redirects.

**2️⃣ Issue: `Database connection failed`**  
✅ **Fix:** Ensure MySQL/PostgreSQL is running & check `application.properties`.

**3️⃣ Issue: `Login not working`**  
✅ **Fix:** Check password encryption (`BCryptPasswordEncoder`) and session handling.

---
## 🤝 Contributing
Feel free to submit issues or pull requests!

---
## 📜 License
This project is licensed under the MIT License.

---
### 🚀 Happy Coding! 🎉

