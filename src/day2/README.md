# Day 2 - Tip Calculator

## 🎯 Learning Objectives
- Work with different numeric data types (int, double)
- Perform mathematical operations
- Format decimal output
- Practice type casting and conversion
- Understand operator precedence

## 📖 Theory

### Numeric Data Types
Java has several numeric data types:

```java
int wholeNumber = 42;           // 32-bit integer
long bigNumber = 123456789L;    // 64-bit integer (note the L)
float decimal = 3.14f;          // 32-bit floating point (note the f)
double preciseDecimal = 3.14159; // 64-bit floating point
```

### Mathematical Operations
```java
int a = 10, b = 3;
int sum = a + b;        // Addition: 13
int difference = a - b; // Subtraction: 7
int product = a * b;    // Multiplication: 30
int quotient = a / b;   // Integer division: 3
int remainder = a % b;  // Modulus (remainder): 1

double preciseQuotient = (double) a / b; // 3.3333...
```

### Formatting Output
```java
// Using printf for formatted output
System.out.printf("%.2f", 3.14159);  // Prints: 3.14

// Using String.format
String formatted = String.format("%.2f", 3.14159);
```

## 🚀 Project: Tip Calculator

Create a program that calculates the tip and total amount for a restaurant bill.

### Requirements:
1. Ask for the total bill amount
2. Ask for the tip percentage (15%, 18%, 20%, etc.)
3. Ask how many people are splitting the bill
4. Calculate and display:
   - Tip amount
   - Total amount (bill + tip)
   - Amount per person

### Example Output:
```
💰 Welcome to the Tip Calculator! 💰
Enter the total bill amount: $85.50
What percentage tip would you like to give (10, 12, 15, 18, 20)? 18
How many people are splitting the bill? 4

Bill Summary:
--------------
Original Bill: $85.50
Tip (18%): $15.39
Total Amount: $100.89
Per Person: $25.22
```

## 💡 Hints
1. Use `double` for money calculations to handle cents
2. Convert percentage to decimal (18% = 0.18)
3. Use `Math.round()` or `printf("%.2f")` to format money to 2 decimal places
4. Be careful with integer division vs. floating-point division

## 🎯 Challenges
1. **Challenge 1**: Add input validation (ensure positive numbers)
2. **Challenge 2**: Allow custom tip percentages (not just preset options)
3. **Challenge 3**: Add a "round up" feature for the final amount
4. **Challenge 4**: Calculate how much each person saves with different tip percentages

## 📚 Key Concepts Learned
- Numeric data types and their differences
- Mathematical operations and operator precedence
- Type casting between int and double
- Formatting decimal output
- Real-world application of programming concepts

## 🔗 Resources
- [Java Primitive Data Types](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html)
- [Math Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html)
- [Printf Formatting](https://docs.oracle.com/javase/tutorial/java/data/numberformat.html)

---
**Previous**: Day 1 - Band Name Generator | **Next**: Day 3 - Treasure Island Game


