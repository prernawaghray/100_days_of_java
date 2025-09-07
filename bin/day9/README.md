# Day 9 - Auction Simulator (Python → Java HashMaps & Collections)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 8:** You've mastered methods and organization. Now let's explore Java's HashMap and advanced collections!

## 🎯 Learning Objectives
- Master HashMap vs Python dictionaries
- Learn key-value pair operations in Java
- Practice collection iteration and manipulation
- Understand Java's Collections Framework
- Compare Java generics with Python's dynamic typing

## 📖 Theory - Python vs Java Key-Value Storage

### 🐍 Python Dictionaries (What You Know)
```python
# Python - Simple and flexible
bids = {}
bids["Alice"] = 150
bids["Bob"] = 200
bids["Charlie"] = 175

# Easy operations
highest_bid = max(bids.values())
winner = max(bids, key=bids.get)

# Iteration
for name, bid in bids.items():
    print(f"{name}: ${bid}")
```

### ☕ Java HashMap (What You're Learning)
```java
import java.util.HashMap;
import java.util.Map;

// Java - Type-safe with generics
HashMap<String, Integer> bids = new HashMap<>();
bids.put("Alice", 150);
bids.put("Bob", 200);
bids.put("Charlie", 175);

// Finding maximum (more verbose but explicit)
String winner = "";
int highestBid = 0;
for (Map.Entry<String, Integer> entry : bids.entrySet()) {
    if (entry.getValue() > highestBid) {
        highestBid = entry.getValue();
        winner = entry.getKey();
    }
}

// Modern Java with streams
String winner = bids.entrySet().stream()
    .max(Map.Entry.comparingByValue())
    .map(Map.Entry::getKey)
    .orElse("No winner");
```

## 🚀 Project: Silent Auction Simulator

Create a comprehensive auction system with multiple bidders and items!

### Requirements:
1. **Multiple Auctions:** Handle several items being auctioned
2. **Bidder Management:** Track bidder information and history
3. **Bid Validation:** Ensure bids meet minimum requirements
4. **Winner Determination:** Find highest bidder for each item
5. **Auction History:** Track all bids and results

### Example Output:
```
🏛️ SILENT AUCTION SIMULATOR 🏛️
═══════════════════════════════════

Current Auctions:
1. Vintage Guitar - Starting bid: $500
2. Signed Baseball - Starting bid: $100
3. Art Painting - Starting bid: $1000

Enter your name: Alice
Choose auction (1-3): 1
Enter your bid for Vintage Guitar: $750
Bid accepted! Current highest: $750

Add another bidder? (y/n): y
Enter your name: Bob
Choose auction (1-3): 1
Enter your bid for Vintage Guitar: $800
Bid accepted! Current highest: $800

🏆 AUCTION RESULTS 🏆
Vintage Guitar: Winner - Bob ($800)
Signed Baseball: No bids
Art Painting: No bids
```

## 💡 Key Java Concepts You'll Practice

### **1. HashMap Operations**
```java
// Creation with generics
HashMap<String, Integer> bids = new HashMap<>();

// Adding entries
bids.put("Alice", 150);
bids.putIfAbsent("Bob", 100); // Only if key doesn't exist

// Retrieving values
int aliceBid = bids.get("Alice");
int defaultBid = bids.getOrDefault("Charlie", 0);

// Checking existence
if (bids.containsKey("Alice")) {
    System.out.println("Alice has bid: " + bids.get("Alice"));
}
```

### **2. Collection Iteration**
```java
// Enhanced for loop (recommended)
for (Map.Entry<String, Integer> entry : bids.entrySet()) {
    System.out.println(entry.getKey() + ": $" + entry.getValue());
}

// Separate key and value iteration
for (String name : bids.keySet()) {
    System.out.println(name + " bid $" + bids.get(name));
}

for (Integer bid : bids.values()) {
    System.out.println("Bid amount: $" + bid);
}
```

### **3. Advanced HashMap Features**
```java
// Compute operations (Java 8+)
bids.compute("Alice", (key, value) -> value == null ? 100 : value + 50);
bids.computeIfAbsent("Bob", key -> 75);

// Merge operations
bids.merge("Charlie", 200, Integer::max); // Keep higher value
```

## 🎯 Challenges

**Challenge 1: Basic Auction**
- Create single-item auction with multiple bidders
- Implement bid validation (minimum increments)
- Determine and announce winner

**Challenge 2: Multi-Item Auction**
- Handle multiple auction items simultaneously
- Track bidding history for each item
- Generate comprehensive results report

**Challenge 3: Advanced Features**
- Implement reserve prices (minimum to sell)
- Add bidder profiles with contact information
- Create auction statistics and analytics

**Challenge 4: Real-time Simulation**
- Add time limits for bidding
- Implement automatic bid increments
- Create "going once, going twice" countdown

## 📚 Key Concepts You'll Master

**From Python (Review):**
- Dictionary/map operations and logic
- Finding maximum values and keys
- Data organization and retrieval

**New in Java:**
- HashMap with generics (`HashMap<K, V>`)
- Map.Entry interface for key-value pairs
- Collections Framework integration
- Type safety and compile-time checking
- Enhanced for loops with collections

## 🔗 Python vs Java Quick Reference

| Operation | Python | Java |
|-----------|--------|------|
| Create map | `bids = {}` | `HashMap<String, Integer> bids = new HashMap<>();` |
| Add entry | `bids["Alice"] = 150` | `bids.put("Alice", 150);` |
| Get value | `bids["Alice"]` | `bids.get("Alice")` |
| Check key | `"Alice" in bids` | `bids.containsKey("Alice")` |
| Get keys | `bids.keys()` | `bids.keySet()` |
| Get values | `bids.values()` | `bids.values()` |
| Iterate | `for k, v in bids.items():` | `for (Map.Entry<K, V> entry : bids.entrySet())` |

---
**Previous**: Day 8 - Calculator App | **Next**: Day 10 - Blackjack Game