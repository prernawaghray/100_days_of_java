# Day 6 - Hangman Game (Python → Java Collections & Game State)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 5:** You've mastered loops and password generation. Now let's explore Java's powerful Collections framework and game state management!

## 🎯 Learning Objectives
- Master Java Collections (ArrayList, HashSet, HashMap)
- Learn String methods and character manipulation
- Practice game state management and data persistence
- Understand Java's enhanced for loops and iterators
- Compare Java's type-safe collections with Python's flexible lists/sets

## 📖 Theory - Python vs Java Collections

### 🐍 Python Collections (What You Know)
```python
# Python - Dynamic and flexible
guessed_letters = []  # List
word_list = {"python", "java", "coding"}  # Set
categories = {
    "animals": ["elephant", "tiger", "lion"],
    "countries": ["france", "japan", "brazil"]
}  # Dict

# Easy operations
guessed_letters.append('a')
if 'a' in guessed_letters:
    print("Already guessed!")

# List comprehension
display = [letter if letter in guessed_letters else '_' for letter in word]
```

### ☕ Java Collections (What You're Learning)
```java
import java.util.*;

// Java - Type-safe and explicit
List<Character> guessedLetters = new ArrayList<>();  // Generic List
Set<String> wordSet = new HashSet<>();  // Generic Set
Map<String, List<String>> categories = new HashMap<>();  // Generic Map

// Explicit operations
guessedLetters.add('a');
if (guessedLetters.contains('a')) {
    System.out.println("Already guessed!");
}

// Enhanced for loop
StringBuilder display = new StringBuilder();
for (char letter : word.toCharArray()) {
    if (guessedLetters.contains(letter)) {
        display.append(letter);
    } else {
        display.append('_');
    }
    display.append(' ');
}
```

## 🚀 Project: Advanced Hangman Game

Create a comprehensive word-guessing game with categories, difficulty levels, and statistics!

### Example Output:
```
🎮 JAVA HANGMAN CHAMPIONSHIP 🎮
═══════════════════════════════════

Welcome back, Player! 
🏆 Your Stats: 15 wins, 8 losses (65% win rate)

Choose your challenge:
1. 🐾 Animals (Easy: 4-6 letters)
2. 🌍 Countries (Medium: 6-8 letters)  
3. 🎬 Movies (Hard: 8-12 letters)
4. 🔬 Science (Expert: 10+ letters)
5. 🎲 Random Mix
6. 📊 View Statistics
7. ⚙️ Settings

Your choice: 2

🌍 COUNTRIES - MEDIUM DIFFICULTY 🌍
═══════════════════════════════════

  +---+
  |   |
      |
      |
      |
      |
=========

Word: _ _ _ _ _ _ _  (7 letters)
Category: Countries
Difficulty: Medium
Lives remaining: 6 ❤️❤️❤️❤️❤️❤️

Guessed letters: []
Hint: This country is famous for its pasta and pizza!

Enter your guess (letter or full word): e

Good guess! 'E' appears 1 time.

  +---+
  |   |
      |
      |
      |
      |
=========

Word: _ _ _ _ _ E _  (7 letters)
Lives remaining: 6 ❤️❤️❤️❤️❤️❤️
Guessed letters: [E]

Enter your guess: italy

🎉 CONGRATULATIONS! 🎉
You guessed "ITALY" correctly!
Final score: 850 points (6 lives × 100 + 250 bonus)

🏆 NEW PERSONAL BEST for Countries category!

Play again? (y/n): y
```

### Requirements:
1. **Multiple Categories:** Animals, countries, movies, science terms
2. **Difficulty Levels:** Word length and complexity-based scoring
3. **Visual Hangman:** ASCII art progression with each wrong guess
4. **Statistics Tracking:** Win/loss ratios, best scores, category performance
5. **Smart Hints:** Context-based clues without giving away the answer

## 💡 Key Java Concepts You'll Practice

### **1. Collections Framework Mastery**
```java
public class WordManager {
    private Map<String, List<String>> categories;
    private Set<Character> guessedLetters;
    private List<String> previousWords;
    
    public WordManager() {
        categories = new HashMap<>();
        guessedLetters = new HashSet<>();
        previousWords = new ArrayList<>();
        
        initializeCategories();
    }
    
    private void initializeCategories() {
        // Using Arrays.asList for easy list creation
        categories.put("animals", Arrays.asList(
            "elephant", "giraffe", "penguin", "kangaroo", "butterfly"
        ));
        
        categories.put("countries", Arrays.asList(
            "australia", "switzerland", "madagascar", "philippines"
        ));
        
        // Or building lists dynamically
        List<String> movies = new ArrayList<>();
        movies.add("inception");
        movies.add("interstellar");
        movies.add("gladiator");
        categories.put("movies", movies);
    }
    
    public String getRandomWord(String category) {
        List<String> words = categories.get(category);
        if (words == null || words.isEmpty()) {
            throw new IllegalArgumentException("Invalid category: " + category);
        }
        
        Random random = new Random();
        String word;
        
        // Ensure we don't repeat recent words
        do {
            word = words.get(random.nextInt(words.size()));
        } while (previousWords.contains(word) && previousWords.size() < words.size());
        
        // Keep track of recent words (limit to last 5)
        previousWords.add(word);
        if (previousWords.size() > 5) {
            previousWords.remove(0);
        }
        
        return word.toLowerCase();
    }
}
```

### **2. Game State Management**
```java
public class HangmanGame {
    private String currentWord;
    private Set<Character> guessedLetters;
    private int wrongGuesses;
    private int maxWrongGuesses;
    private GameState state;
    private int score;
    
    public enum GameState {
        PLAYING, WON, LOST
    }
    
    public HangmanGame(String word, int maxWrong) {
        this.currentWord = word.toLowerCase();
        this.guessedLetters = new HashSet<>();
        this.wrongGuesses = 0;
        this.maxWrongGuesses = maxWrong;
        this.state = GameState.PLAYING;
        this.score = 0;
    }
    
    public boolean makeGuess(char letter) {
        letter = Character.toLowerCase(letter);
        
        if (guessedLetters.contains(letter)) {
            return false; // Already guessed
        }
        
        guessedLetters.add(letter);
        
        if (currentWord.contains(String.valueOf(letter))) {
            // Correct guess - calculate points
            long letterCount = currentWord.chars()
                .filter(c -> c == letter)
                .count();
            score += letterCount * 50;
            
            checkWinCondition();
            return true;
        } else {
            // Wrong guess
            wrongGuesses++;
            if (wrongGuesses >= maxWrongGuesses) {
                state = GameState.LOST;
            }
            return false;
        }
    }
    
    private void checkWinCondition() {
        boolean allLettersGuessed = currentWord.chars()
            .allMatch(c -> guessedLetters.contains((char) c) || !Character.isLetter(c));
            
        if (allLettersGuessed) {
            state = GameState.WON;
            // Bonus points for remaining lives
            score += (maxWrongGuesses - wrongGuesses) * 100;
        }
    }
    
    public String getDisplayWord() {
        StringBuilder display = new StringBuilder();
        
        for (char c : currentWord.toCharArray()) {
            if (Character.isLetter(c)) {
                if (guessedLetters.contains(c)) {
                    display.append(Character.toUpperCase(c));
                } else {
                    display.append('_');
                }
            } else {
                display.append(c); // Keep spaces, hyphens, etc.
            }
            display.append(' ');
        }
        
        return display.toString().trim();
    }
}
```

### **3. Statistics and Data Persistence**
```java
public class PlayerStats {
    private Map<String, Integer> categoryWins;
    private Map<String, Integer> categoryLosses;
    private List<Integer> recentScores;
    private int totalGames;
    private int bestScore;
    
    public PlayerStats() {
        categoryWins = new HashMap<>();
        categoryLosses = new HashMap<>();
        recentScores = new ArrayList<>();
        totalGames = 0;
        bestScore = 0;
    }
    
    public void recordGame(String category, boolean won, int score) {
        totalGames++;
        
        if (won) {
            categoryWins.merge(category, 1, Integer::sum);
            if (score > bestScore) {
                bestScore = score;
            }
        } else {
            categoryLosses.merge(category, 1, Integer::sum);
        }
        
        recentScores.add(score);
        if (recentScores.size() > 10) {
            recentScores.remove(0); // Keep only last 10 scores
        }
    }
    
    public double getWinRate() {
        if (totalGames == 0) return 0.0;
        
        int totalWins = categoryWins.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
            
        return (double) totalWins / totalGames * 100;
    }
    
    public double getCategoryWinRate(String category) {
        int wins = categoryWins.getOrDefault(category, 0);
        int losses = categoryLosses.getOrDefault(category, 0);
        int total = wins + losses;
        
        return total > 0 ? (double) wins / total * 100 : 0.0;
    }
}
```

## 🎯 Challenges

**Challenge 1: Basic Hangman**
- Implement core word guessing with ArrayList for letters
- Create simple hangman drawing progression
- Add basic win/loss detection

**Challenge 2: Enhanced Collections**
- Use HashMap for word categories
- Implement HashSet for efficient letter checking
- Add difficulty levels based on word length

**Challenge 3: Advanced Features**
- Create comprehensive statistics tracking
- Implement hint system with contextual clues
- Add multiplayer support with turn management

**Challenge 4: Data Persistence**
- Save/load player statistics to file
- Implement custom word list management
- Create tournament mode with leaderboards

## 📚 Key Concepts You'll Master

**From Python (Review):**
- List and set operations for data storage
- Dictionary usage for categorized data
- Game loop and state management

**New in Java:**
- **Generic Collections:** `List<T>`, `Set<T>`, `Map<K,V>`
- **Collection Interfaces:** List vs Set vs Map characteristics
- **Enhanced for loops:** `for (Type item : collection)`
- **Stream operations:** `.filter()`, `.map()`, `.collect()`
- **Optional class:** Safe null handling

## 🔗 Python vs Java Quick Reference

| Operation | Python | Java |
|-----------|--------|------|
| Create list | `letters = []` | `List<Character> letters = new ArrayList<>();` |
| Add to list | `letters.append('a')` | `letters.add('a');` |
| Check contains | `'a' in letters` | `letters.contains('a')` |
| Create set | `guessed = set()` | `Set<Character> guessed = new HashSet<>();` |
| Create dict | `categories = {}` | `Map<String, List<String>> categories = new HashMap<>();` |
| For each loop | `for letter in word:` | `for (char letter : word.toCharArray()) {` |

---
**Previous**: Day 5 - Password Generator | **Next**: Day 7 - Caesar Cipher