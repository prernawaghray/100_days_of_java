# Day 3 - Text Adventure Game (Python → Java Control Flow)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Days 1-2:** You've mastered input/output and numeric operations. Now let's explore Java's decision-making and control structures!

## 🎯 Learning Objectives
- Master Java's `if/else if/else` statements vs Python's `if/elif/else`
- Learn Java's `switch` statements (Python doesn't have these!)
- Understand boolean operations and logical operators
- Practice nested conditionals and complex decision trees
- Explore Java's `String.equals()` vs Python's `==` for strings

## 📖 Theory - Python vs Java Control Flow

### 🐍 Python Conditionals (What You Know)
```python
# Python - Simple and clean
choice = input("Choose your path: ")

if choice == "left":
    print("You found treasure!")
elif choice == "right":
    print("You encountered a dragon!")
elif choice in ["quit", "exit"]:
    print("Game over!")
else:
    print("Invalid choice!")

# Python boolean operations
if age >= 18 and has_license:
    print("You can drive!")
```

### ☕ Java Conditionals (What You're Learning)
```java
// Java - More verbose but explicit
String choice = scanner.nextLine();

if (choice.equals("left")) {                    // Note: .equals(), not ==
    System.out.println("You found treasure!");
} else if (choice.equals("right")) {
    System.out.println("You encountered a dragon!");
} else if (choice.equals("quit") || choice.equals("exit")) {
    System.out.println("Game over!");
} else {
    System.out.println("Invalid choice!");
}

// Java boolean operations
if (age >= 18 && hasLicense) {                  // && instead of 'and'
    System.out.println("You can drive!");
}
```

### 🚨 **Critical Java Gotcha: String Comparison**
```python
# Python - Works as expected
if name == "John":
    print("Hello John!")
```

```java
// Java - DON'T do this!
if (name == "John") {        // ❌ Compares memory addresses, not content!
    System.out.println("Hello John!");
}

// Java - Correct way
if (name.equals("John")) {   // ✅ Compares actual string content
    System.out.println("Hello John!");
}

// Java - Safe way (handles null)
if ("John".equals(name)) {   // ✅ Won't crash if name is null
    System.out.println("Hello John!");
}
```

### 🆕 **Java Switch Statements (Python Doesn't Have These!)**
```java
// Java switch - Great for multiple exact matches
switch (choice.toLowerCase()) {
    case "north":
        System.out.println("You go north...");
        break;
    case "south":
        System.out.println("You go south...");
        break;
    case "east":
    case "e":  // Multiple cases can share code
        System.out.println("You go east...");
        break;
    default:
        System.out.println("Invalid direction!");
        break;
}

// Modern Java (14+) - Switch expressions
String result = switch (choice.toLowerCase()) {
    case "north" -> "You go north...";
    case "south" -> "You go south...";
    case "east", "e" -> "You go east...";
    default -> "Invalid direction!";
};
```

## 🚀 Project: Interactive Adventure Game

Create a text-based adventure game with multiple paths and outcomes!

### Game Structure:
```
🏰 Welcome to the Mystic Castle Adventure! 🏰

You stand before a mysterious castle with three paths:
1. Enter through the main gate
2. Sneak around to the back entrance  
3. Climb the tower wall

Your choice (1/2/3): 2

🌙 You sneak to the back entrance...
You find a locked door with a riddle:
"I have keys but no locks. I have space but no room. What am I?"

Your answer: keyboard
🎉 Correct! The door opens...

You're in the castle kitchen. You see:
A) A glowing potion on the table
B) Stairs leading to the dungeon
C) A door to the throne room

Your choice (A/B/C): A
```

### Requirements:
1. **Multiple Decision Points:** At least 5 different choice scenarios
2. **Different Endings:** 3+ different ways the game can end
3. **Input Validation:** Handle invalid choices gracefully
4. **Score System:** Track player's choices and give different endings based on score
5. **Replay Option:** Ask if player wants to play again

### Advanced Features:
- **Inventory System:** Collect items that affect later choices
- **Health/Lives System:** Some choices reduce health
- **Random Events:** Use `Math.random()` for surprise encounters
- **Save Progress:** Remember choices for complex storylines

## 💡 Key Java Concepts You'll Practice

### **1. String Comparison**
```java
// Always use .equals() for strings
if (choice.equals("yes")) { ... }

// Case-insensitive comparison
if (choice.equalsIgnoreCase("YES")) { ... }

// Safe comparison (handles null)
if ("yes".equals(choice)) { ... }
```

### **2. Boolean Operators**
```java
// Java uses symbols, not words
if (health > 0 && hasKey) { ... }     // && = and
if (choice.equals("quit") || gameOver) { ... }  // || = or
if (!hasWeapon) { ... }               // ! = not
```

### **3. Switch Statements**
```java
switch (direction) {
    case "north":
        // code
        break;  // Don't forget break!
    case "south":
        // code
        break;
    default:
        // default case
}
```

### **4. Input Validation Loop**
```java
String choice;
do {
    System.out.print("Enter A, B, or C: ");
    choice = scanner.nextLine().toUpperCase();
} while (!choice.equals("A") && !choice.equals("B") && !choice.equals("C"));
```

## 🎯 Challenges

**Challenge 1: Basic Adventure**
- Create a simple 3-choice adventure with different endings
- Use proper string comparison and input validation

**Challenge 2: Advanced Branching**
- Add inventory system (collect items that affect later choices)
- Implement a scoring system based on choices

**Challenge 3: Game Loop**
- Add replay functionality
- Track high scores or best endings achieved

**Challenge 4: Random Events**
- Use `Math.random()` to add surprise encounters
- Create dynamic storylines that change each playthrough

## 📚 Key Concepts You'll Master

**From Python (Review):**
- Conditional logic and decision trees
- User input and validation
- Game loop concepts

**New in Java:**
- `String.equals()` vs `==` (crucial difference!)
- `switch` statements for clean multiple choices
- Boolean operators (`&&`, `||`, `!`)
- `do-while` loops for input validation
- Method organization for complex games

## 🔗 Python vs Java Quick Reference

| Concept | Python | Java |
|---------|--------|------|
| String comparison | `if name == "John":` | `if (name.equals("John")) {` |
| Boolean AND | `if a and b:` | `if (a && b) {` |
| Boolean OR | `if a or b:` | `if (a \|\| b) {` |
| Boolean NOT | `if not flag:` | `if (!flag) {` |
| Multiple choices | `if/elif/else` | `switch/case` or `if/else if/else` |
| Case insensitive | `if name.lower() == "john":` | `if (name.equalsIgnoreCase("john")) {` |

## 🎮 Sample Game Flow
```
🏰 Mystic Castle Adventure 🏰
═══════════════════════════════

Chapter 1: The Entrance
You approach a mysterious castle...
[Choices lead to different paths]

Chapter 2: Inside the Castle  
Based on your entrance choice...
[Different scenarios unfold]

Chapter 3: The Final Challenge
Your previous choices determine...
[Multiple possible endings]

🎯 Final Score: 85/100
🏆 Achievement: "Brave Explorer"
Play again? (y/n):
```

---

**Previous**: Day 2 - Tip Calculator | **Next**: Day 4 - Rock Paper Scissors (Loops & Random)
