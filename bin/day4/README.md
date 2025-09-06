# Day 4 - Rock Paper Scissors (Python → Java Loops & Random)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 3:** You've mastered conditionals and string comparison. Now let's explore Java's loops and random number generation!

## 🎯 Learning Objectives
- Master Java's `for`, `while`, and `do-while` loops vs Python's loops
- Learn Java's `Math.random()` vs Python's `random` module
- Understand Java's `Random` class for better random generation
- Practice game loops and replay functionality
- Explore Java's `enum` types for game choices

## 📖 Theory - Python vs Java Loops & Random

### 🐍 Python Loops & Random (What You Know)
```python
import random

# Python loops
for i in range(5):
    print(f"Round {i + 1}")

while True:
    choice = input("Play again? (y/n): ")
    if choice.lower() == 'n':
        break

# Python random
choices = ["rock", "paper", "scissors"]
computer_choice = random.choice(choices)
random_number = random.randint(1, 6)  # Dice roll
```

### ☕ Java Loops & Random (What You're Learning)
```java
import java.util.Random;

// Java loops
for (int i = 0; i < 5; i++) {
    System.out.println("Round " + (i + 1));
}

while (true) {
    System.out.print("Play again? (y/n): ");
    String choice = scanner.nextLine();
    if (choice.toLowerCase().equals("n")) {
        break;
    }
}

// Java random - Method 1: Math.random()
String[] choices = {"rock", "paper", "scissors"};
int randomIndex = (int) (Math.random() * choices.length);
String computerChoice = choices[randomIndex];

// Java random - Method 2: Random class (preferred)
Random random = new Random();
String computerChoice = choices[random.nextInt(choices.length)];
int diceRoll = random.nextInt(6) + 1;  // 1-6
```

### 🆕 **Java Enums (Python Doesn't Have These Built-in!)**
```java
// Define game choices as enum
public enum Choice {
    ROCK, PAPER, SCISSORS;
    
    // Method to get random choice
    public static Choice getRandomChoice() {
        Random random = new Random();
        Choice[] choices = Choice.values();
        return choices[random.nextInt(choices.length)];
    }
    
    // Method to determine winner
    public boolean beats(Choice other) {
        return (this == ROCK && other == SCISSORS) ||
               (this == PAPER && other == ROCK) ||
               (this == SCISSORS && other == PAPER);
    }
}
```

## 🚀 Project: Advanced Rock Paper Scissors

Create a comprehensive Rock Paper Scissors game with multiple features!

### Game Features:
```
🎮 ROCK PAPER SCISSORS CHAMPIONSHIP 🎮
═══════════════════════════════════════

Choose your game mode:
1. Classic (Rock, Paper, Scissors)
2. Extended (Rock, Paper, Scissors, Lizard, Spock)
3. Tournament (Best of 5)

Mode: 1

Round 1/3
Your choice (rock/paper/scissors): rock
Computer chose: scissors
🎉 You win! Rock crushes scissors!

Score: You 1 - 0 Computer

Round 2/3
Your choice: paper
Computer chose: paper
🤝 It's a tie!

Score: You 1 - 0 Computer
...
```

### Requirements:
1. **Multiple Game Modes:** Classic, Extended (Lizard/Spock), Tournament
2. **Score Tracking:** Keep track of wins/losses/ties
3. **Input Validation:** Handle invalid inputs gracefully
4. **Statistics:** Show win percentage, longest streak
5. **Replay System:** Play multiple rounds or games

### Advanced Features:
- **AI Difficulty Levels:** Easy, Normal, Hard (pattern recognition)
- **Tournament Bracket:** Multiple opponents
- **Save/Load Stats:** Persistent statistics
- **Custom Rules:** Create your own game variants

## 💡 Key Java Concepts You'll Practice

### **1. Loop Types**
```java
// For loop - when you know iteration count
for (int round = 1; round <= 3; round++) {
    System.out.println("Round " + round);
}

// While loop - condition-based
while (!gameOver) {
    playRound();
}

// Do-while loop - execute at least once
do {
    System.out.print("Play again? (y/n): ");
    response = scanner.nextLine();
} while (!response.equals("y") && !response.equals("n"));
```

### **2. Random Generation**
```java
// Method 1: Math.random()
int randomChoice = (int) (Math.random() * 3);  // 0, 1, or 2

// Method 2: Random class (better)
Random random = new Random();
int randomChoice = random.nextInt(3);  // 0, 1, or 2
boolean coinFlip = random.nextBoolean();
```

### **3. Arrays and Enums**
```java
// Array approach
String[] choices = {"rock", "paper", "scissors"};
String computerChoice = choices[random.nextInt(choices.length)];

// Enum approach (more professional)
Choice computerChoice = Choice.getRandomChoice();
```

### **4. Game State Management**
```java
public class GameStats {
    private int wins = 0;
    private int losses = 0;
    private int ties = 0;
    
    public void recordWin() { wins++; }
    public void recordLoss() { losses++; }
    public void recordTie() { ties++; }
    
    public double getWinPercentage() {
        int total = wins + losses + ties;
        return total > 0 ? (double) wins / total * 100 : 0;
    }
}
```

## 🎯 Challenges

**Challenge 1: Basic Game**
- Implement classic Rock Paper Scissors
- Add proper input validation and game loop
- Track and display score

**Challenge 2: Extended Version**
- Add Lizard and Spock options
- Implement the extended rules logic
- Create a rules explanation system

**Challenge 3: Tournament Mode**
- Best of 3, 5, or 7 rounds
- Tournament bracket system
- Statistics and performance tracking

**Challenge 4: AI Opponent**
- Pattern recognition (track player's previous moves)
- Different difficulty levels
- Adaptive strategy based on player behavior

## 📚 Key Concepts You'll Master

**From Python (Review):**
- Game logic and state management
- Random number generation concepts
- Loop-based game flow

**New in Java:**
- `for` loop syntax with initialization, condition, increment
- `Random` class vs `Math.random()`
- `enum` types for type-safe constants
- Array manipulation and indexing
- Method organization in game classes

## 🔗 Python vs Java Quick Reference

| Concept | Python | Java |
|---------|--------|------|
| For loop | `for i in range(5):` | `for (int i = 0; i < 5; i++) {` |
| While loop | `while condition:` | `while (condition) {` |
| Random choice | `random.choice(list)` | `list[random.nextInt(list.length)]` |
| Random integer | `random.randint(1, 6)` | `random.nextInt(6) + 1` |
| Array/List | `choices = ["a", "b", "c"]` | `String[] choices = {"a", "b", "c"};` |
| Constants | `ROCK = "rock"` | `enum Choice { ROCK, PAPER, SCISSORS }` |

## 🎮 Sample Game Flow
```
🎮 ROCK PAPER SCISSORS CHAMPIONSHIP 🎮
═══════════════════════════════════════

Welcome! Choose your game mode:
1. Quick Game (1 round)
2. Best of 3
3. Best of 5
4. Tournament (7 rounds)
5. Practice Mode

Your choice: 2

🏆 BEST OF 3 CHAMPIONSHIP 🏆
First to win 2 rounds wins the match!

Round 1: Your move (rock/paper/scissors): rock
Computer plays: scissors
🎉 You win! Rock crushes scissors!
Score: You 1 - 0 Computer

Round 2: Your move: paper  
Computer plays: scissors
😞 You lose! Scissors cuts paper!
Score: You 1 - 1 Computer

Round 3 (FINAL ROUND): Your move: scissors
Computer plays: rock
😞 You lose! Rock crushes scissors!

🏆 FINAL RESULT 🏆
Computer wins 2-1!
Your win rate: 33.3%

Play another match? (y/n): y
```

---

**Previous**: Day 3 - Adventure Game | **Next**: Day 5 - Password Generator (Arrays & Characters)
