# Day 15 - OOP Deep Dive (Python → Java Classes & Objects)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 14:** You've mastered debugging and error handling. Now let's dive deep into Java's object-oriented programming!

## 🎯 Learning Objectives
- Master Java class creation and object instantiation
- Learn constructors, getters, and setters
- Practice encapsulation and data hiding
- Understand `this` keyword and object references
- Compare Java's explicit OOP with Python's flexible approach

## 📖 Theory - Python vs Java OOP

### 🐍 Python Classes (What You Know)
```python
class CoffeeMachine:
    def __init__(self, water=1000, milk=500, beans=200):
        self.water = water
        self.milk = milk
        self.beans = beans
        self.money = 0
    
    def make_coffee(self, coffee_type):
        if coffee_type == "espresso":
            if self.water >= 50 and self.beans >= 18:
                self.water -= 50
                self.beans -= 18
                self.money += 1.50
                return "☕ Espresso ready!"
            return "❌ Not enough ingredients"
    
    def report(self):
        return f"Water: {self.water}ml, Milk: {self.milk}ml, Beans: {self.beans}g"

# Usage
machine = CoffeeMachine()
print(machine.make_coffee("espresso"))
```

### ☕ Java Classes (What You're Learning)
```java
public class CoffeeMachine {
    // Private fields (encapsulation)
    private int water;
    private int milk;
    private int beans;
    private double money;
    
    // Constructor
    public CoffeeMachine(int water, int milk, int beans) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.money = 0.0;
    }
    
    // Default constructor
    public CoffeeMachine() {
        this(1000, 500, 200); // Constructor chaining
    }
    
    // Public methods
    public String makeCoffee(String coffeeType) {
        if ("espresso".equals(coffeeType)) {
            if (water >= 50 && beans >= 18) {
                water -= 50;
                beans -= 18;
                money += 1.50;
                return "☕ Espresso ready!";
            }
            return "❌ Not enough ingredients";
        }
        return "❌ Unknown coffee type";
    }
    
    // Getters and setters
    public int getWater() { return water; }
    public void setWater(int water) { 
        if (water >= 0) this.water = water; 
    }
    
    public String getReport() {
        return String.format("Water: %dml, Milk: %dml, Beans: %dg", 
                           water, milk, beans);
    }
}

// Usage
CoffeeMachine machine = new CoffeeMachine();
System.out.println(machine.makeCoffee("espresso"));
```

## 🚀 Project: Advanced OOP Coffee Shop System

Create a comprehensive coffee shop management system using proper OOP principles!

**Key Java Concepts:**
- Class definition with proper encapsulation
- Constructor overloading and chaining
- Instance variables with private access
- Public methods for controlled access
- `this` keyword for object reference

**Features to Build:**
- Multiple coffee machine types with inheritance
- Coffee recipe system with composition
- Customer order management
- Inventory tracking and alerts
- Sales reporting and analytics

**Challenges:**
1. **Basic OOP** - Create CoffeeMachine class with proper encapsulation
2. **Advanced Design** - Add inheritance and composition patterns
3. **System Integration** - Build complete coffee shop management
4. **Professional Features** - Add persistence and advanced analytics

---
**Previous**: Day 14 - Debugging Practice | **Next**: Day 16 - Coffee Machine OOP