# Day 11 - Number Guessing Game (Python → Java Loops & Input Validation)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 10:** You've mastered ArrayList and game logic. Now let's explore Java's loop structures and robust input validation!

## 🎯 Learning Objectives
- Master different Java loop types (while, do-while, for)
- Learn input validation and error handling
- Practice random number generation and ranges
- Understand user experience design in console applications
- Compare Java's structured loops with Python's flexibility

## 📖 Theory - Python vs Java Loops & Validation

### 🐍 Python Loops (What You Know)
```python
import random

# Python - Simple and flexible
number = random.randint(1, 100)
attempts = 0

while True:
    try:
        guess = int(input("Guess a number (1-100): "))
        attempts += 1
        
        if guess == number:
            print(f"Correct! You won in {attempts} attempts!")
            break
        elif guess < number:
            print("Too low!")
        else:
            print("Too high!")
            
    except ValueError:
        print("Please enter a valid number!")
```

### ☕ Java Loops (What You're Learning)
```java
import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

// Java - More structured and explicit
Random random = new Random();
Scanner scanner = new Scanner(System.in);
int number = random.nextInt(100) + 1; // 1-100
int attempts = 0;
boolean hasWon = false;

while (!hasWon) {
    System.out.print("Guess a number (1-100): ");
    
    try {
        int guess = scanner.nextInt();
        attempts++;
        
        if (guess == number) {
            System.out.println("Correct! You won in " + attempts + " attempts!");
            hasWon = true;
        } else if (guess < number) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }
    } catch (InputMismatchException e) {
        System.out.println("Please enter a valid number!");
        scanner.nextLine(); // Clear invalid input
    }
}
```

## 🚀 Project: Advanced Number Guessing Game

Create a comprehensive guessing game with multiple difficulty levels and features!

### Game Features:
```
🎯 NUMBER GUESSING CHAMPIONSHIP 🎯
═══════════════════════════════════

Choose your difficulty:
1. Easy (1-10, unlimited attempts)
2. Medium (1-50, 10 attempts)
3. Hard (1-100, 7 attempts)
4. Expert (1-1000, 10 attempts)
5. Custom range

Difficulty: 3

🔥 HARD MODE: Guess the number between 1-100
You have 7 attempts remaining.

Attempt 1/7: 50
📈 Too low! The number is higher.
Hint: Try a number closer to the upper range.

Attempt 2/7: 75
📉 Too high! The number is lower.
Hint: The number is between 50 and 75.

Attempt 3/7: 62
🎉 Correct! You guessed 62 in 3 attempts!

🏆 GAME STATISTICS 🏆
Games played: 5
Games won: 4
Win rate: 80%
Best score: 2 attempts (Easy mode)
Average attempts: 4.2

Play again? (y/n): y
```

### Requirements:
1. **Multiple Difficulty Levels:** Different ranges and attempt limits
2. **Input Validation:** Handle invalid inputs gracefully
3. **Smart Hints:** Provide helpful feedback based on guesses
4. **Statistics Tracking:** Win/loss ratios, best scores, averages
5. **Game Modes:** Single game, tournament, time-based challenges

## 💡 Key Java Concepts You'll Practice

### **1. Loop Types and Usage**
```java
// While loop - condition checked before execution
while (attempts < maxAttempts && !hasWon) {
    // Game logic
}

// Do-while loop - executes at least once
do {
    System.out.print("Play again? (y/n): ");
    response = scanner.nextLine().toLowerCase();
} while (!response.equals("y") && !response.equals("n"));

// For loop - when you know iteration count
for (int round = 1; round <= totalRounds; round++) {
    System.out.println("=== ROUND " + round + " ===");
    playRound();
}
```

### **2. Input Validation Patterns**
```java
public static int getValidInteger(Scanner scanner, int min, int max) {
    while (true) {
        try {
            System.out.print("Enter number (" + min + "-" + max + "): ");
            int input = scanner.nextInt();
            
            if (input >= min && input <= max) {
                return input;
            } else {
                System.out.println("Number must be between " + min + " and " + max);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.nextLine(); // Clear invalid input
        }
    }
}
```

### **3. Game Statistics Management**
```java
public class GameStats {
    private int gamesPlayed = 0;
    private int gamesWon = 0;
    private int totalAttempts = 0;
    private int bestScore = Integer.MAX_VALUE;
    
    public void recordGame(boolean won, int attempts) {
        gamesPlayed++;
        totalAttempts += attempts;
        
        if (won) {
            gamesWon++;
            if (attempts < bestScore) {
                bestScore = attempts;
            }
        }
    }
    
    public double getWinRate() {
        return gamesPlayed > 0 ? (double) gamesWon / gamesPlayed * 100 : 0;
    }
    
    public double getAverageAttempts() {
        return gamesPlayed > 0 ? (double) totalAttempts / gamesPlayed : 0;
    }
}
```

## 🎯 Challenges

**Challenge 1: Basic Game**
- Implement core guessing game with simple feedback
- Add attempt counting and win/loss detection
- Include basic input validation

**Challenge 2: Enhanced Features**
- Add multiple difficulty levels
- Implement smart hint system based on previous guesses
- Create statistics tracking across games

**Challenge 3: Advanced Modes**
- Tournament mode with multiple rounds
- Time-based challenges (guess within time limit)
- Multiplayer mode (take turns guessing)

**Challenge 4: AI Features**
- Computer tries to guess your number
- Implement optimal guessing strategy (binary search)
- Compare human vs computer performance

## 📚 Key Concepts You'll Master

**From Python (Review):**
- Loop logic and game flow control
- Random number generation
- Exception handling concepts

**New in Java:**
- Different loop types and their appropriate usage
- `InputMismatchException` and scanner error handling
- Method organization for input validation
- Object-oriented statistics tracking
- `Random` class vs `Math.random()`

## 🔗 Python vs Java Quick Reference

| Concept | Python | Java |
|---------|--------|------|
| While loop | `while condition:` | `while (condition) {` |
| Do-while | No direct equivalent | `do { } while (condition);` |
| For loop | `for i in range(n):` | `for (int i = 0; i < n; i++) {` |
| Random int | `random.randint(1, 100)` | `random.nextInt(100) + 1` |
| Try-catch | `try: ... except ValueError:` | `try { } catch (InputMismatchException e) {` |
| Input validation | Manual checking | `scanner.hasNextInt()` or try-catch |

---
**Previous**: Day 10 - Blackjack Game | **Next**: Day 12 - Higher or Lower Game