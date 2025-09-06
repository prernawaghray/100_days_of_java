# Day 2 - Tip Calculator (Python → Java Math Operations)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 1.5:** You've already done string-to-number conversion! Now let's master Java's numeric operations.

## 🎯 Learning Objectives
- Master Java's numeric data types (`int`, `double`, `float`)
- Understand integer vs floating-point division (big difference from Python!)
- Learn precise decimal formatting for money calculations
- Practice mathematical operations and operator precedence
- Handle percentage calculations properly

## 📖 Theory - Python vs Java Math

### 🐍 Python Numbers (What You Know)
```python
# Python - Simple and flexible
bill = 85.50
tip_percent = 18
people = 4

# Division always returns float
tip_amount = bill * (tip_percent / 100)  # Always precise
per_person = (bill + tip_amount) / people  # Always float

# Easy formatting
print(f"Tip: ${tip_amount:.2f}")
print(f"Per person: ${per_person:.2f}")
```

### ☕ Java Numbers (What You're Learning)
```java
// Java - More explicit and type-aware
double bill = 85.50;        // Use double for money (precise)
int tipPercent = 18;        // int for whole percentages
int people = 4;

// WATCH OUT: Integer division vs floating-point division!
double tipDecimal = tipPercent / 100.0;  // Must use 100.0, not 100!
double tipAmount = bill * tipDecimal;
double perPerson = (bill + tipAmount) / people;

// Formatting options
System.out.printf("Tip: $%.2f%n", tipAmount);
String formatted = "Per person: $%.2f".formatted(perPerson);
```

### 🚨 **Critical Java Gotcha: Division**
```python
# Python - Always works as expected
18 / 100 = 0.18  # Float result
```

```java
// Java - Type matters!
18 / 100 = 0      // ❌ Integer division = 0!
18 / 100.0 = 0.18 // ✅ Floating-point division = 0.18
18.0 / 100 = 0.18 // ✅ Also works
(double) 18 / 100 = 0.18 // ✅ Type casting works too
```

## 🚀 Project: Advanced Tip Calculator

Create a comprehensive tip calculator that handles multiple scenarios:

### Requirements:
1. **Basic Calculation:**
   - Bill amount
   - Tip percentage (15%, 18%, 20%, or custom)
   - Number of people splitting

2. **Advanced Features:**
   - Show multiple tip options (15%, 18%, 20%)
   - Calculate tax if applicable
   - Round up option for convenience
   - Show savings comparison between tip percentages

### Example Output:
```
💰 Welcome to the Advanced Tip Calculator! 💰

Enter the total bill amount: $85.50
Enter tax percentage (0 if no tax): 8.5
How many people are splitting the bill? 4

🧾 TIP OPTIONS:
----------------------------------------
                15%      18%      20%
Tip Amount:    $12.83   $15.39   $17.10
Total + Tax:   $105.47  $108.03  $109.74
Per Person:    $26.37   $27.01   $27.44
----------------------------------------

Which tip percentage would you like? 18
💡 You chose 18% tip!

📊 FINAL BILL BREAKDOWN:
========================
Original Bill:     $85.50
Tax (8.5%):        $7.27
Subtotal:          $92.77
Tip (18%):         $15.39
------------------------
TOTAL:             $108.16
Per Person:        $27.04
========================

💡 Tip: Rounding up to $28.00 per person = $112.00 total
```

## 💡 Key Java Concepts You'll Practice

### **1. Data Type Selection**
```java
double bill;        // For money - needs decimal precision
int tipPercent;     // For percentages - whole numbers
int people;         // For count - whole numbers
```

### **2. Precise Division**
```java
// Convert percentage to decimal
double tipDecimal = tipPercent / 100.0;  // Note the .0!

// Alternative approaches
double tipDecimal = (double) tipPercent / 100;
double tipDecimal = tipPercent * 0.01;
```

### **3. Money Formatting**
```java
// Method 1: printf
System.out.printf("Amount: $%.2f%n", amount);

// Method 2: String.format
String formatted = String.format("$%.2f", amount);

// Method 3: Modern Java (15+)
String formatted = "Amount: $%.2f".formatted(amount);
```

### **4. Mathematical Operations**
```java
double subtotal = bill + tax;
double total = subtotal + tip;
double perPerson = total / people;

// Rounding
double rounded = Math.round(perPerson * 100.0) / 100.0;  // To 2 decimals
int roundedUp = (int) Math.ceil(perPerson);  // Round up to next dollar
```

## 🎯 Challenges

**Challenge 1: Input Validation**
- Handle invalid numbers gracefully
- Ensure positive values for bill and people count

**Challenge 2: Multiple Tip Comparison**
- Show side-by-side comparison of different tip percentages
- Calculate which tip percentage saves the most money

**Challenge 3: Advanced Features**
- Add tax calculation
- Include "round up for convenience" option
- Show total savings between lowest and highest tip

**Challenge 4: Receipt Format**
- Create a nicely formatted receipt
- Include date/time stamp
- Add restaurant name input

## 📚 Key Concepts You'll Master

**From Python (Review):**
- Basic arithmetic operations
- Percentage calculations
- User input handling

**New in Java:**
- Static typing for numbers (`int` vs `double`)
- Integer division gotchas
- Precise decimal formatting
- Type casting and conversion
- Mathematical precision for money

## 🔗 Python vs Java Quick Reference

| Operation | Python | Java |
|-----------|--------|------|
| Division | `18 / 100 = 0.18` | `18 / 100.0 = 0.18` |
| Percentage | `amount * (percent / 100)` | `amount * (percent / 100.0)` |
| Formatting | `f"${amount:.2f}"` | `"$%.2f".formatted(amount)` |
| Rounding | `round(amount, 2)` | `Math.round(amount * 100.0) / 100.0` |
| Type conversion | `float(input())` | `Double.parseDouble(scanner.nextLine())` |

---

**Previous**: Day 1.5 - Band Budget Calculator | **Next**: Day 3 - Adventure Game (Conditionals & Logic)