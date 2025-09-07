# Day 17 - Quiz Game (Python → Java Data Structures & File I/O)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 16:** You've mastered inheritance and polymorphism. Now let's explore Java's file I/O operations and advanced data structures!

## 🎯 Learning Objectives
- Master file reading and writing operations
- Learn Java's I/O streams and NIO.2 API
- Practice data parsing and serialization
- Understand exception handling for I/O operations
- Compare Java's verbose I/O with Python's simple file operations

## 📖 Theory - Python vs Java File Operations

### 🐍 Python File I/O (What You Know)
```python
import json

# Reading files - simple and elegant
with open("questions.txt", "r") as file:
    questions = file.readlines()

# JSON handling
with open("quiz_data.json", "r") as file:
    data = json.load(file)

# Dictionary for quiz data
quiz = {
    "question": "What is the capital of France?",
    "options": ["London", "Berlin", "Paris", "Madrid"],
    "answer": 2
}
```

### ☕ Java File I/O (What You're Learning)
```java
import java.nio.file.*;
import java.io.*;
import com.fasterxml.jackson.databind.ObjectMapper;

// Modern Java NIO.2 approach
public List<String> readQuestions(String filename) throws IOException {
    Path path = Paths.get(filename);
    return Files.readAllLines(path, StandardCharsets.UTF_8);
}

// JSON handling with Jackson
public QuizData loadQuizData(String filename) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Path path = Paths.get(filename);
    String content = Files.readString(path);
    return mapper.readValue(content, QuizData.class);
}

// Quiz question class
public class QuizQuestion {
    private String question;
    private List<String> options;
    private int correctAnswer;
    
    // Constructors, getters, setters...
}
```

## 🚀 Project: Advanced Quiz Game System

Create a comprehensive quiz platform with multiple categories, difficulty levels, and persistent data storage!

**Key Java Concepts:**
- NIO.2 API for modern file operations
- JSON processing with Jackson library
- Exception handling for I/O operations
- Generic collections for type safety
- Object serialization and deserialization

**Features to Build:**
- Question database loaded from JSON files
- User profiles with persistent statistics
- Multiple game modes and difficulty levels
- Scoring system with leaderboards
- Question editor and content management

**Challenges:**
1. **Basic Quiz System** - Load questions from files and implement gameplay
2. **Data Management** - JSON processing and user profile persistence
3. **Advanced Features** - Multiple categories, timed questions, statistics
4. **Complete Platform** - Question editor, leaderboards, achievements

---
**Previous**: Day 16 - Coffee Machine OOP | **Next**: Day 18 - Turtle Graphics