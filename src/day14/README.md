# Day 14 - Debugging Practice (Python → Java Error Handling & IDE Tools)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 13:** You've learned Java OOP fundamentals. Now let's master debugging techniques and error handling in Java!

## 🎯 Learning Objectives
- Master Java debugging tools and techniques
- Learn comprehensive exception handling patterns
- Practice reading and interpreting stack traces
- Understand IDE debugging features (breakpoints, watches, step-through)
- Compare Java's explicit error handling with Python's approach

## 📖 Theory - Python vs Java Error Handling

### 🐍 Python Error Handling (What You Know)
```python
def divide_numbers(a, b):
    try:
        result = a / b
        return f"Result: {result}"
    except ZeroDivisionError:
        return "Error: Cannot divide by zero!"
    except TypeError:
        return "Error: Invalid input types!"
    except Exception as e:
        return f"Unexpected error: {e}"
    finally:
        print("Division operation completed")

# Python debugging
import pdb; pdb.set_trace()  # Debugger breakpoint
print(f"Debug: a={a}, b={b}")  # Print debugging
```

### ☕ Java Error Handling (What You're Learning)
```java
public class Calculator {
    public String divideNumbers(double a, double b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            double result = a / b;
            return String.format("Result: %.2f", result);
            
        } catch (ArithmeticException e) {
            System.err.println("Arithmetic error: " + e.getMessage());
            return "Error: " + e.getMessage();
            
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace(); // Print full stack trace
            return "Unexpected error occurred";
            
        } finally {
            System.out.println("Division operation completed");
        }
    }
}

// Java debugging
System.out.println("Debug: a=" + a + ", b=" + b); // Print debugging
// IDE breakpoints and step-through debugging
```

## 🚀 Project: Bug Hunt Challenge Game

Create a debugging practice game with intentionally buggy code that you must fix!

### Game Concept:
```
🐛 JAVA BUG HUNT CHALLENGE 🐛
═══════════════════════════════════

Welcome to the Bug Hunt! Fix the broken code to advance.

LEVEL 1: Compilation Errors
═══════════════════════════
🎯 Target: Fix 5 compilation errors

Code Preview:
```java
public class BuggyCalculator {
    public static void main(String[] args) {
        int result = addNumbers(5, 10;  // Missing )
        System.out.println("Result: " + result);
        
        String message = "Hello World"  // Missing ;
        system.out.println(message);    // Wrong case
    }
    
    public static int addNumbers(int a int b) {  // Missing comma
        return a + b
    }  // Missing ;
}
```

🔧 Fix the errors and run the code!
Errors found: 0/5

Enter your fix: 
> Fixed missing parenthesis on line 3

✅ Correct! 1/5 errors fixed.
🏆 Level 1 Complete! Moving to Runtime Errors...
```

### Requirements:
1. **Progressive Difficulty:** Compilation → Runtime → Logic errors
2. **Interactive Debugging:** Step through code with explanations
3. **Common Error Patterns:** NullPointer, ArrayIndexOutOfBounds, etc.
4. **IDE Integration:** Practice using debugger tools
5. **Score System:** Points for quick fixes, hints available

## 💡 Key Java Concepts You'll Practice

### **1. Exception Hierarchy and Handling**
```java
public class ErrorHandlingDemo {
    
    // Checked exceptions - must be handled
    public void readFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            System.out.println("First line: " + line);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            throw new RuntimeException("Critical file missing", e);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            throw e; // Re-throw for caller to handle
        }
    }
    
    // Unchecked exceptions - optional handling
    public int divideArray(int[] numbers, int index, int divisor) {
        try {
            return numbers[index] / divisor;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Invalid array index: " + index);
            return 0;
        } catch (ArithmeticException e) {
            System.err.println("Division by zero attempted");
            return Integer.MAX_VALUE;
        } catch (NullPointerException e) {
            System.err.println("Array is null");
            return -1;
        }
    }
}
```

### **2. Custom Exceptions and Error Messages**
```java
// Custom exception classes
public class InsufficientFundsException extends Exception {
    private double balance;
    private double requestedAmount;
    
    public InsufficientFundsException(double balance, double requested) {
        super(String.format("Insufficient funds: Balance $%.2f, Requested $%.2f", 
                          balance, requested));
        this.balance = balance;
        this.requestedAmount = requested;
    }
    
    public double getShortfall() {
        return requestedAmount - balance;
    }
}

public class BankAccount {
    private double balance;
    
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(balance, amount);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. New balance: $" + balance);
    }
}
```

### **3. Debugging Utilities and Logging**
```java
public class DebugUtils {
    private static final boolean DEBUG_MODE = true;
    
    // Debug logging utility
    public static void debug(String message) {
        if (DEBUG_MODE) {
            System.out.println("[DEBUG] " + LocalDateTime.now() + ": " + message);
        }
    }
    
    // Object state inspector
    public static void inspectObject(Object obj, String label) {
        if (DEBUG_MODE) {
            System.out.println("=== " + label + " ===");
            System.out.println("Class: " + obj.getClass().getSimpleName());
            System.out.println("Hash: " + obj.hashCode());
            System.out.println("String: " + obj.toString());
            System.out.println("================");
        }
    }
    
    // Stack trace printer
    public static void printStackTrace() {
        if (DEBUG_MODE) {
            StackTraceElement[] stack = Thread.currentThread().getStackTrace();
            System.out.println("=== STACK TRACE ===");
            for (int i = 2; i < Math.min(stack.length, 10); i++) {
                System.out.println(stack[i]);
            }
            System.out.println("==================");
        }
    }
}
```

## 🎯 Challenges

**Challenge 1: Compilation Error Hunt**
- Fix syntax errors, missing imports, type mismatches
- Practice reading compiler error messages
- Learn common compilation pitfalls

**Challenge 2: Runtime Exception Handling**
- Handle NullPointerException, ArrayIndexOutOfBounds
- Implement proper try-catch-finally blocks
- Create meaningful error messages

**Challenge 3: Logic Error Detection**
- Find and fix algorithmic mistakes
- Use debugging tools to trace execution
- Implement unit tests to catch regressions

**Challenge 4: Advanced Debugging**
- Multi-threaded debugging scenarios
- Memory leak detection and prevention
- Performance debugging with profiling

## 📚 Common Java Errors and Solutions

### **Compilation Errors:**
```java
// Error: Variable might not be initialized
int result;
if (condition) {
    result = 10;
}
System.out.println(result); // ❌ Compiler error

// Solution: Initialize or handle all paths
int result = 0; // ✅ Default value
if (condition) {
    result = 10;
}
```

### **Runtime Errors:**
```java
// NullPointerException
String text = null;
int length = text.length(); // ❌ NPE

// Solution: Null checks
if (text != null) {
    int length = text.length(); // ✅ Safe
}
// Or use Optional<String> for better null handling
```

### **Logic Errors:**
```java
// Off-by-one error
for (int i = 0; i <= array.length; i++) { // ❌ Goes beyond array
    System.out.println(array[i]);
}

// Solution: Correct loop bounds
for (int i = 0; i < array.length; i++) { // ✅ Correct bounds
    System.out.println(array[i]);
}
```

## 🔧 IDE Debugging Features

### **IntelliJ IDEA / VS Code:**
1. **Breakpoints:** Click line number to set/remove
2. **Step Over (F8):** Execute current line
3. **Step Into (F7):** Enter method calls
4. **Step Out (Shift+F8):** Exit current method
5. **Variables View:** Inspect current variable values
6. **Watches:** Monitor specific expressions
7. **Call Stack:** See method call hierarchy

## 🔗 Python vs Java Quick Reference

| Concept | Python | Java |
|---------|--------|------|
| Try-catch | `try: ... except ValueError:` | `try { } catch (NumberFormatException e) {` |
| Finally block | `finally:` | `finally {` |
| Raise exception | `raise ValueError("message")` | `throw new IllegalArgumentException("message");` |
| Print debug | `print(f"Debug: {var}")` | `System.out.println("Debug: " + var);` |
| Stack trace | `import traceback; traceback.print_exc()` | `e.printStackTrace();` |
| Debugger | `import pdb; pdb.set_trace()` | IDE breakpoints or `System.out.println()` |

---
**Previous**: Day 13 - Coffee Machine Simulator | **Next**: Day 15 - Object-Oriented Programming Deep Dive