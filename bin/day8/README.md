# Day 8 - Calculator App (Python → Java Methods & Organization)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 7:** You've mastered string algorithms and cryptography. Now let's explore Java's method organization and mathematical operations!

## 🎯 Learning Objectives
- Master method creation and organization
- Learn parameter passing and return types
- Practice mathematical operations and precision
- Understand method overloading and static methods
- Compare Java's explicit method signatures with Python's flexibility

## 📖 Theory - Python vs Java Method Organization

### 🐍 Python Functions (What You Know)
```python
import math

def add(a, b):
    return a + b

def calculate(operation, a, b=None):
    if operation == "sqrt":
        return math.sqrt(a)
    elif operation == "add":
        return a + b
    elif operation == "power":
        return a ** b

# Python - Dynamic and flexible
result = calculate("add", 5, 3)
result2 = calculate("sqrt", 16)
print(f"Results: {result}, {result2}")
```

### ☕ Java Methods (What You're Learning)
```java
public class Calculator {
    
    // Method overloading - same name, different parameters
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double add(double a, double b, double c) {
        return a + b + c;
    }
    
    // Specific methods for different operations
    public static double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(a);
    }
    
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}

// Java - Explicit and type-safe
double result = Calculator.add(5.0, 3.0);
double result2 = Calculator.sqrt(16.0);
System.out.println("Results: " + result + ", " + result2);
```

## 🚀 Project: Advanced Scientific Calculator

Create a comprehensive calculator with multiple operation modes and advanced mathematical functions!

### Example Output:
```
🧮 JAVA SCIENTIFIC CALCULATOR 🧮
═══════════════════════════════════════

Current Value: 0.0
Memory: Empty

Main Menu:
1. 🔢 Basic Operations
2. 🔬 Scientific Functions  
3. 📐 Geometry Calculator
4. 💾 Memory Operations
5. 📊 Statistics Mode
6. 🔄 Unit Converter
7. 📋 History
8. ⚙️ Settings

Your choice: 2

🔬 SCIENTIFIC FUNCTIONS 🔬
═══════════════════════════════

Current Value: 0.0

Available Functions:
1. sin(x)     6. ln(x)      11. x!
2. cos(x)     7. log₁₀(x)   12. nCr
3. tan(x)     8. eˣ         13. nPr  
4. √x         9. x²         14. |x|
5. ∛x        10. xʸ         15. Back

Enter function number or value: 45

Current Value: 45.0

Enter function number: 1

sin(45°) = 0.7071067811865476
Current Value: 0.7071067811865476

Continue with result? (y/n): y
Enter function number: 9

(0.7071067811865476)² = 0.5000000000000001
Current Value: 0.5000000000000001

🔄 Operations performed:
1. Input: 45
2. sin(45°) = 0.7071067811865476
3. x² = 0.5000000000000001

Save to memory? (y/n): y
Result saved to memory slot M1.
```

### Requirements:
1. **Basic Operations:** Addition, subtraction, multiplication, division with precision handling
2. **Scientific Functions:** Trigonometric, logarithmic, exponential, factorial
3. **Memory System:** Multiple memory slots with save/recall/clear operations
4. **Expression Parser:** Handle complex mathematical expressions
5. **Unit Conversion:** Length, weight, temperature, currency conversions

## 💡 Key Java Concepts You'll Practice

### **1. Method Organization and Overloading**
```java
public class MathOperations {
    
    // Basic arithmetic with different parameter types
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static int add(int a, int b) {
        return a + b;
    }
    
    public static double add(double... numbers) { // Varargs
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }
    
    // Method chaining for complex operations
    public static double calculate(double value) {
        return new CalculationBuilder(value).build();
    }
    
    public static class CalculationBuilder {
        private double value;
        
        public CalculationBuilder(double value) {
            this.value = value;
        }
        
        public CalculationBuilder add(double n) {
            this.value += n;
            return this;
        }
        
        public CalculationBuilder multiply(double n) {
            this.value *= n;
            return this;
        }
        
        public CalculationBuilder sqrt() {
            this.value = Math.sqrt(this.value);
            return this;
        }
        
        public double build() {
            return this.value;
        }
    }
}

// Usage: MathOperations.calculate(16).sqrt().add(2).multiply(3).build()
```

### **2. Scientific and Mathematical Functions**
```java
public class ScientificCalculator {
    
    // Trigonometric functions with degree/radian support
    public static double sin(double angle, boolean isDegrees) {
        if (isDegrees) {
            angle = Math.toRadians(angle);
        }
        return Math.sin(angle);
    }
    
    public static double cos(double angle, boolean isDegrees) {
        if (isDegrees) {
            angle = Math.toRadians(angle);
        }
        return Math.cos(angle);
    }
    
    // Logarithmic functions
    public static double log(double value, double base) {
        if (value <= 0) {
            throw new IllegalArgumentException("Logarithm undefined for non-positive values");
        }
        if (base <= 0 || base == 1) {
            throw new IllegalArgumentException("Invalid logarithm base");
        }
        return Math.log(value) / Math.log(base);
    }
    
    public static double ln(double value) {
        return log(value, Math.E);
    }
    
    public static double log10(double value) {
        return log(value, 10);
    }
    
    // Factorial with overflow protection
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial undefined for negative numbers");
        }
        if (n > 20) {
            throw new ArithmeticException("Factorial too large for long type");
        }
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    
    // Combinations and permutations
    public static long combination(int n, int r) {
        if (r > n || r < 0) {
            throw new IllegalArgumentException("Invalid combination parameters");
        }
        return factorial(n) / (factorial(r) * factorial(n - r));
    }
    
    public static long permutation(int n, int r) {
        if (r > n || r < 0) {
            throw new IllegalArgumentException("Invalid permutation parameters");
        }
        return factorial(n) / factorial(n - r);
    }
}
```

### **3. Memory Management and History**
```java
public class CalculatorMemory {
    private Map<String, Double> memorySlots;
    private List<String> calculationHistory;
    private Stack<Double> undoStack;
    private static final int MAX_HISTORY = 50;
    
    public CalculatorMemory() {
        memorySlots = new HashMap<>();
        calculationHistory = new ArrayList<>();
        undoStack = new Stack<>();
        
        // Initialize memory slots M1-M9
        for (int i = 1; i <= 9; i++) {
            memorySlots.put("M" + i, 0.0);
        }
    }
    
    public void store(String slot, double value) {
        if (!memorySlots.containsKey(slot)) {
            throw new IllegalArgumentException("Invalid memory slot: " + slot);
        }
        
        undoStack.push(memorySlots.get(slot)); // For undo
        memorySlots.put(slot, value);
        addToHistory("Stored " + value + " in " + slot);
    }
    
    public double recall(String slot) {
        if (!memorySlots.containsKey(slot)) {
            throw new IllegalArgumentException("Invalid memory slot: " + slot);
        }
        
        double value = memorySlots.get(slot);
        addToHistory("Recalled " + value + " from " + slot);
        return value;
    }
    
    public void add(String slot, double value) {
        double current = recall(slot);
        store(slot, current + value);
        addToHistory("Added " + value + " to " + slot + " = " + memorySlots.get(slot));
    }
    
    public void clear(String slot) {
        store(slot, 0.0);
        addToHistory("Cleared " + slot);
    }
    
    public void clearAll() {
        for (String slot : memorySlots.keySet()) {
            memorySlots.put(slot, 0.0);
        }
        addToHistory("Cleared all memory slots");
    }
    
    private void addToHistory(String operation) {
        calculationHistory.add(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")) + 
                              " - " + operation);
        
        // Limit history size
        if (calculationHistory.size() > MAX_HISTORY) {
            calculationHistory.remove(0);
        }
    }
    
    public List<String> getHistory() {
        return new ArrayList<>(calculationHistory);
    }
    
    public Map<String, Double> getAllMemorySlots() {
        return new HashMap<>(memorySlots);
    }
}
```

## 🎯 Challenges

**Challenge 1: Basic Calculator**
- Implement four basic operations with proper error handling
- Add method overloading for different number types
- Create a simple menu-driven interface

**Challenge 2: Scientific Functions**
- Add trigonometric functions with degree/radian modes
- Implement logarithmic and exponential functions
- Add factorial, combination, and permutation calculations

**Challenge 3: Advanced Features**
- Create memory system with multiple slots
- Implement calculation history with undo/redo
- Add expression parsing for complex calculations

**Challenge 4: Professional Calculator**
- Build unit conversion system
- Add statistical functions (mean, median, standard deviation)
- Create graphing capabilities for mathematical functions

## 📚 Key Concepts You'll Master

**From Python (Review):**
- Function definition and parameter passing
- Mathematical operations and library usage
- Error handling for invalid inputs

**New in Java:**
- **Method Overloading:** Same method name, different parameters
- **Static Methods:** Class-level methods without object instantiation
- **Varargs:** Variable number of arguments (`double... numbers`)
- **Math Class:** Built-in mathematical functions and constants
- **Exception Handling:** Specific exceptions for mathematical errors
- **Builder Pattern:** Method chaining for complex operations

## 🔗 Python vs Java Quick Reference

| Concept | Python | Java |
|---------|--------|------|
| Function definition | `def add(a, b):` | `public static double add(double a, double b) {` |
| Method call | `result = add(5, 3)` | `double result = Calculator.add(5.0, 3.0);` |
| Square root | `math.sqrt(16)` | `Math.sqrt(16.0)` |
| Power | `5 ** 3` or `pow(5, 3)` | `Math.pow(5.0, 3.0)` |
| Exception | `raise ValueError("message")` | `throw new IllegalArgumentException("message");` |
| Variable args | `def func(*args):` | `public static void func(double... args) {` |

---
**Previous**: Day 7 - Caesar Cipher | **Next**: Day 9 - Auction Program