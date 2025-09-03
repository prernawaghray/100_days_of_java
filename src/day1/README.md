# Day 1 - Band Name Generator (Python → Java Translation)

## 🐍 ➡️ ☕ Python to Java Transition

**You already know this in Python, now let's do it in Java!**

## 🎯 Learning Objectives
- Translate Python's dynamic typing to Java's static typing
- Convert Python's `input()` to Java's `Scanner`
- Understand Java's compilation vs Python's interpretation
- Learn Java's class structure vs Python's script structure
- Practice the fundamental Python → Java syntax differences

## 📖 Theory - Python vs Java Side-by-Side

### 🐍 Python Variables (What You Know)
```python
# Python - Dynamic typing, no declaration needed
name = "John"           # str
age = 25               # int  
price = 19.99          # float
is_active = True       # bool
```

### ☕ Java Variables (What You're Learning)
```java
// Java - Static typing, must declare type
String name = "John";        // String (note capital S)
int age = 25;               // int (32-bit integer)
double price = 19.99;       // double (64-bit float)
boolean isActive = true;    // boolean (note lowercase b)
```

**Key Differences:**
- Java requires **type declaration** before variable name
- Java uses **semicolons** to end statements
- Java is **case-sensitive** with types (`String` vs `string`)
- Java uses **camelCase** convention (`isActive` vs `is_active`)

### 🐍 Python Input (What You Know)
```python
# Python - Simple and direct
name = input("What's your name? ")
age = int(input("What's your age? "))  # Convert to int if needed
```

### ☕ Java Input (What You're Learning)
```java
import java.util.Scanner;  // Must import first!

// Basic approach
Scanner scanner = new Scanner(System.in);
System.out.print("What's your name? ");
String name = scanner.nextLine();

// Modern Java: Try-with-resources (like Python's 'with')
try (Scanner scanner = new Scanner(System.in)) {
    System.out.print("What's your name? ");
    String name = scanner.nextLine();
}  // Automatically closes scanner
```

**Key Differences:**
- Java needs **import statement** for Scanner
- Java requires **explicit object creation** (`new Scanner()`)
- Java has **separate methods** for different types (`nextLine()`, `nextInt()`)
- Java's try-with-resources is like Python's `with open()` for cleanup

### 🐍 Python Strings (What You Know)
```python
# Python - Multiple ways to combine strings
first_name = "John"
last_name = "Doe"

# Concatenation
full_name = first_name + " " + last_name

# f-strings (modern Python)
full_name = f"{first_name} {last_name}"

# Multi-line strings
message = """
Welcome to the Band Name Generator!
Let's create something awesome!
"""
```

### ☕ Java Strings (What You're Learning)
```java
String firstName = "John";  // Note: camelCase, not snake_case
String lastName = "Doe";

// Concatenation (same as Python)
String fullName = firstName + " " + lastName;

// Modern formatting (Java 15+, like Python f-strings)
String formatted = "Hello %s %s!".formatted(firstName, lastName);

// Text blocks (Java 15+, like Python triple quotes)
String message = """
    Welcome to the Band Name Generator!
    Let's create something awesome!
    """;
```

**Key Differences:**
- Java uses **camelCase** (`firstName`) vs Python's **snake_case** (`first_name`)
- Java's `.formatted()` is similar to Python's f-strings
- Java text blocks work like Python's triple quotes

## 🚀 Project: Band Name Generator

Create a program that generates a band name by combining:
1. The name of the city where you grew up
2. The name of your pet (or favorite animal)

### Example Output:
```
Welcome to the Band Name Generator!
What's the name of the city you grew up in? 
> Seattle
What's your pet's name? 
> Fluffy
Your band name could be: Seattle Fluffy
```

## 💡 Hints
1. Import the Scanner class at the top of your file
2. Create a Scanner object to read user input
3. Use `nextLine()` to read strings with spaces
4. Combine the inputs to create the band name
5. Don't forget to close the Scanner when done

## 🎯 Challenges
After completing the basic project, try these variations:

1. **Challenge 1**: Add more inputs (favorite color, birth month) for more creative names
2. **Challenge 2**: Make the program ask if the user wants to generate another name
3. **Challenge 3**: Add some random adjectives to make the names more interesting

## 📚 Key Concepts Learned
- Variable declaration and initialization
- Scanner class for user input
- String concatenation
- Basic program structure
- Import statements

## 🔗 Resources
- [Java Variables](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/variables.html)
- [Scanner Class Documentation](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)
- [String Concatenation](https://docs.oracle.com/javase/tutorial/java/data/strings.html)

---
**Next**: Day 2 - Tip Calculator

