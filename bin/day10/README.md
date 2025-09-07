# Day 10 - Blackjack Game (Python → Java ArrayList & Game Logic)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 9:** You've mastered HashMap collections. Now let's explore ArrayList and complex game state management!

## 🎯 Learning Objectives
- Master ArrayList vs Python lists
- Learn dynamic array operations in Java
- Practice complex conditional logic and game rules
- Understand object-oriented game design
- Compare Java's type safety with Python's flexibility

## 📖 Theory - Python vs Java Dynamic Arrays

### 🐍 Python Lists (What You Know)
```python
# Python - Dynamic and flexible
cards = []
cards.append("Ace")
cards.append("King")
cards.extend(["Queen", "Jack"])

# Easy operations
card = cards.pop()  # Remove last
first_card = cards[0]
cards.insert(1, "10")

# List comprehensions
values = [get_card_value(card) for card in cards]
total = sum(values)
```

### ☕ Java ArrayList (What You're Learning)
```java
import java.util.ArrayList;
import java.util.Collections;

// Java - Type-safe with generics
ArrayList<String> cards = new ArrayList<>();
cards.add("Ace");
cards.add("King");
cards.addAll(Arrays.asList("Queen", "Jack"));

// Operations (more verbose but explicit)
String card = cards.remove(cards.size() - 1); // Remove last
String firstCard = cards.get(0);
cards.add(1, "10");

// Manual iteration for calculations
int total = 0;
for (String card : cards) {
    total += getCardValue(card);
}
```

## 🚀 Project: Complete Blackjack Game

Create a full-featured Blackjack game with proper rules and multiple players!

### Game Rules:
- Goal: Get as close to 21 as possible without going over
- Face cards (J, Q, K) = 10 points
- Ace = 1 or 11 points (player's choice)
- Dealer must hit on 16 or less, stand on 17 or more

### Requirements:
1. **Card Management:** Deck creation, shuffling, dealing
2. **Player Actions:** Hit, Stand, Double Down, Split (advanced)
3. **Dealer Logic:** Automated dealer play following rules
4. **Score Calculation:** Handle Ace values dynamically
5. **Game Flow:** Multiple rounds, betting system

### Example Output:
```
🃏 BLACKJACK CASINO 🃏
═══════════════════════

Starting new game...
Your balance: $1000

--- ROUND 1 ---
Place your bet: $50

Dealing cards...
Your cards: [7♠, A♥] = 18 (or 8)
Dealer shows: [K♦, ?]

Your turn:
1. Hit (take another card)
2. Stand (keep current total)
3. Double Down (double bet, take one card)
Your choice: 2

Dealer reveals: [K♦, 6♣] = 16
Dealer hits: [K♦, 6♣, 7♠] = 23 (BUST!)

🎉 You win! Dealer busted!
You win: $50
New balance: $1050

Play another round? (y/n): y
```

## 💡 Key Java Concepts You'll Practice

### **1. ArrayList Operations**
```java
// Creation and initialization
ArrayList<String> deck = new ArrayList<>();
ArrayList<String> playerHand = new ArrayList<>();

// Adding elements
deck.add("A♠");
playerHand.addAll(Arrays.asList("7♠", "A♥"));

// Accessing elements
String firstCard = playerHand.get(0);
String lastCard = playerHand.get(playerHand.size() - 1);

// Removing elements
String drawnCard = deck.remove(0); // Remove first
playerHand.clear(); // Remove all
```

### **2. Deck Management**
```java
public static ArrayList<String> createDeck() {
    ArrayList<String> deck = new ArrayList<>();
    String[] suits = {"♠", "♥", "♦", "♣"};
    String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    
    for (String suit : suits) {
        for (String rank : ranks) {
            deck.add(rank + suit);
        }
    }
    
    Collections.shuffle(deck); // Shuffle the deck
    return deck;
}
```

### **3. Score Calculation with Aces**
```java
public static int calculateScore(ArrayList<String> hand) {
    int score = 0;
    int aces = 0;
    
    for (String card : hand) {
        String rank = card.substring(0, card.length() - 1); // Remove suit
        
        if (rank.equals("A")) {
            aces++;
            score += 11; // Initially count as 11
        } else if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
            score += 10;
        } else {
            score += Integer.parseInt(rank);
        }
    }
    
    // Convert Aces from 11 to 1 if needed
    while (score > 21 && aces > 0) {
        score -= 10; // Convert one Ace from 11 to 1
        aces--;
    }
    
    return score;
}
```

## 🎯 Challenges

**Challenge 1: Basic Blackjack**
- Implement core game with hit/stand options
- Handle Ace values correctly
- Create simple dealer AI

**Challenge 2: Advanced Features**
- Add betting system with balance tracking
- Implement Double Down and Split options
- Create multiple player support

**Challenge 3: Casino Features**
- Add insurance betting when dealer shows Ace
- Implement card counting detection
- Create tournament mode with multiple rounds

**Challenge 4: GUI Version**
- Create visual card representations
- Add animations for dealing cards
- Implement click-based player actions

## 📚 Key Concepts You'll Master

**From Python (Review):**
- List operations and manipulation
- Game logic and state management
- Random operations and shuffling

**New in Java:**
- ArrayList with generics (`ArrayList<T>`)
- Collections utility methods
- Enhanced for loops with collections
- String manipulation and parsing
- Method organization for complex logic

## 🔗 Python vs Java Quick Reference

| Operation | Python | Java |
|-----------|--------|------|
| Create list | `cards = []` | `ArrayList<String> cards = new ArrayList<>();` |
| Add element | `cards.append("Ace")` | `cards.add("Ace");` |
| Get element | `cards[0]` | `cards.get(0)` |
| Remove element | `cards.pop()` | `cards.remove(cards.size()-1)` |
| List size | `len(cards)` | `cards.size()` |
| Check empty | `not cards` | `cards.isEmpty()` |
| Shuffle | `random.shuffle(cards)` | `Collections.shuffle(cards)` |

---
**Previous**: Day 9 - Auction Simulator | **Next**: Day 11 - Number Guessing Game