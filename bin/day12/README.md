# Day 12 - Higher or Lower Game (Python → Java APIs & Data Processing)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 11:** You've mastered loops and input validation. Now let's explore Java's HTTP clients and JSON data processing!

## 🎯 Learning Objectives
- Learn Java's HTTP client for API requests
- Master JSON parsing with Jackson or built-in libraries
- Practice data comparison and sorting algorithms
- Understand external data integration in Java applications
- Compare Java's verbose HTTP handling with Python's simplicity

## 📖 Theory - Python vs Java API Requests

### 🐍 Python API Requests (What You Know)
```python
import requests
import json

# Python - Simple and elegant
response = requests.get("https://api.example.com/data")
data = response.json()

# Easy data processing
followers = data["follower_count"]
if followers > 1000000:
    print("Higher!")
else:
    print("Lower!")
```

### ☕ Java API Requests (What You're Learning)
```java
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

// Java - More verbose but explicit
HttpClient client = HttpClient.newHttpClient();
HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create("https://api.example.com/data"))
    .build();

HttpResponse<String> response = client.send(request, 
    HttpResponse.BodyHandlers.ofString());

ObjectMapper mapper = new ObjectMapper();
JsonNode data = mapper.readTree(response.body());

int followers = data.get("follower_count").asInt();
if (followers > 1000000) {
    System.out.println("Higher!");
} else {
    System.out.println("Lower!");
}
```

## 🚀 Project: Social Media Higher or Lower Game

Create a guessing game using real social media follower data!

### Game Concept:
Compare follower counts, subscriber numbers, or popularity metrics between celebrities, YouTubers, Instagram accounts, or companies.

### Example Output:
```
📱 SOCIAL MEDIA HIGHER OR LOWER 📱
═══════════════════════════════════════

Loading celebrity data...

ROUND 1
┌─────────────────────────────────────┐
│           TAYLOR SWIFT              │
│         🎵 Musician                 │
│      Instagram Followers            │
│         ???,???,???                 │
└─────────────────────────────────────┘

VS

┌─────────────────────────────────────┐
│          CRISTIANO RONALDO          │
│         ⚽ Athlete                  │
│      Instagram Followers            │
│        600,000,000                  │
└─────────────────────────────────────┘

Does Taylor Swift have HIGHER or LOWER 
Instagram followers than Cristiano Ronaldo?

Your guess (H/L): H

✅ CORRECT! 
Taylor Swift: 270,000,000 followers
Cristiano Ronaldo: 600,000,000 followers

Score: 1 | Current Streak: 1

Continue? (y/n): y
```

### Requirements:
1. **Data Source Integration:** Use real APIs or curated datasets
2. **Multiple Categories:** Instagram, YouTube, Twitter, TikTok followers
3. **Diverse Personalities:** Celebrities, YouTubers, brands, politicians
4. **Score Tracking:** Points, streaks, leaderboards
5. **Difficulty Levels:** Easy (obvious differences) to Hard (close numbers)

## 💡 Key Java Concepts You'll Practice

### **1. HTTP Client Usage (Java 11+)**
```java
public class APIClient {
    private final HttpClient client;
    
    public APIClient() {
        this.client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(10))
            .build();
    }
    
    public String fetchData(String url) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Accept", "application/json")
            .timeout(Duration.ofSeconds(30))
            .build();
            
        HttpResponse<String> response = client.send(request,
            HttpResponse.BodyHandlers.ofString());
            
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("API request failed: " + response.statusCode());
        }
    }
}
```

### **2. JSON Processing**
```java
// Using Jackson (add dependency)
public class SocialMediaData {
    private String name;
    private String category;
    private long followers;
    private String platform;
    
    // Constructors, getters, setters
    public static SocialMediaData fromJson(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, SocialMediaData.class);
    }
}

// Or using built-in JSON (Java 17+)
public static long extractFollowers(String jsonResponse) {
    // Simple parsing for basic JSON
    String followersStr = jsonResponse
        .split("\"followers\":")[1]
        .split(",")[0]
        .trim();
    return Long.parseLong(followersStr);
}
```

### **3. Game Data Management**
```java
public class GameData {
    private List<SocialMediaData> celebrities;
    private Random random = new Random();
    
    public GameData() {
        loadCelebrities();
    }
    
    public Pair<SocialMediaData, SocialMediaData> getRandomPair() {
        SocialMediaData first = celebrities.get(random.nextInt(celebrities.size()));
        SocialMediaData second;
        
        do {
            second = celebrities.get(random.nextInt(celebrities.size()));
        } while (first.equals(second));
        
        return new Pair<>(first, second);
    }
    
    public boolean isHigher(SocialMediaData a, SocialMediaData b) {
        return a.getFollowers() > b.getFollowers();
    }
}
```

## 🎯 Challenges

**Challenge 1: Basic Comparison Game**
- Create simple higher/lower with hardcoded data
- Implement basic scoring and streak tracking
- Add different social media platforms

**Challenge 2: Real API Integration**
- Connect to real social media APIs
- Handle API rate limits and errors
- Cache data for offline play

**Challenge 3: Advanced Features**
- Multiple game modes (followers, likes, views)
- Difficulty levels based on follower differences
- Multiplayer competitions

**Challenge 4: Data Analytics**
- Track player performance statistics
- Analyze which comparisons are most difficult
- Create adaptive difficulty based on player skill

## 📚 Key Concepts You'll Master

**From Python (Review):**
- API request concepts and JSON handling
- Data comparison and game logic
- Error handling for network requests

**New in Java:**
- `HttpClient` and `HttpRequest` classes
- JSON parsing with ObjectMapper or built-in methods
- Exception handling for network operations
- Duration and timeout management
- Generic collections for type safety

## 🔗 Python vs Java Quick Reference

| Operation | Python | Java |
|-----------|--------|------|
| HTTP GET | `requests.get(url)` | `HttpClient.newHttpClient().send(request, ...)` |
| JSON parse | `response.json()` | `ObjectMapper().readTree(response.body())` |
| Get JSON field | `data["field"]` | `jsonNode.get("field").asString()` |
| Exception handling | `except requests.RequestException:` | `catch (IOException \| InterruptedException e)` |
| Timeout | `requests.get(url, timeout=30)` | `HttpRequest.newBuilder().timeout(Duration.ofSeconds(30))` |

## 🛠️ Setup Requirements

**Dependencies (Maven):**
```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.15.2</version>
</dependency>
```

**Or use built-in JSON parsing for simple cases (Java 17+)**

---
**Previous**: Day 11 - Number Guessing Game | **Next**: Day 13 - Coffee Machine Simulator