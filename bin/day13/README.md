# Day 13 - Coffee Machine Simulator (Python → Java OOP Fundamentals)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 12:** You've mastered API integration and data processing. Now let's dive into Java's object-oriented programming fundamentals!

## 🎯 Learning Objectives
- Learn Java class design and object creation
- Master constructors, getters, and setters
- Practice encapsulation and data hiding
- Understand method overloading and static methods
- Compare Java's explicit OOP with Python's flexible approach

## 📖 Theory - Python vs Java OOP

### 🐍 Python Classes (What You Know)
```python
class CoffeeMachine:
    def __init__(self, water=1000, milk=500, coffee=100):
        self.water = water
        self.milk = milk
        self.coffee = coffee
        self.money = 0
    
    def make_coffee(self, drink_type):
        if drink_type == "espresso":
            if self.water >= 50 and self.coffee >= 18:
                self.water -= 50
                self.coffee -= 18
                self.money += 1.50
                return "☕ Espresso ready!"
            return "❌ Not enough ingredients"
    
    def report(self):
        return f"Water: {self.water}ml, Milk: {self.milk}ml, Coffee: {self.coffee}g"

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
    private int coffee;
    private double money;
    
    // Constructor
    public CoffeeMachine(int water, int milk, int coffee) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.money = 0.0;
    }
    
    // Default constructor
    public CoffeeMachine() {
        this(1000, 500, 100); // Constructor chaining
    }
    
    // Public methods
    public String makeCoffee(String drinkType) {
        if ("espresso".equals(drinkType)) {
            if (water >= 50 && coffee >= 18) {
                water -= 50;
                coffee -= 18;
                money += 1.50;
                return "☕ Espresso ready!";
            }
            return "❌ Not enough ingredients";
        }
        return "❌ Unknown drink type";
    }
    
    // Getters and setters
    public int getWater() { return water; }
    public void setWater(int water) { this.water = water; }
    
    public String getReport() {
        return String.format("Water: %dml, Milk: %dml, Coffee: %dg", 
                           water, milk, coffee);
    }
}

// Usage
CoffeeMachine machine = new CoffeeMachine();
System.out.println(machine.makeCoffee("espresso"));
```

## 🚀 Project: Advanced Coffee Machine Simulator

Create a comprehensive coffee shop management system with multiple machine types and business logic!

### Example Output:
```
☕ JAVA COFFEE MACHINE SIMULATOR ☕
═══════════════════════════════════════

🏪 Welcome to JavaBeans Coffee Shop!

Current Machines:
1. Espresso Machine (Premium)
2. Drip Coffee Machine (Standard)
3. Cappuccino Machine (Deluxe)

Select machine (1-3): 1

═══ ESPRESSO MACHINE (Premium) ═══
💧 Water: 1000ml | 🥛 Milk: 500ml | ☕ Coffee: 200g
💰 Revenue: $0.00

Menu:
1. ☕ Espresso ($2.50)
2. 🥛 Latte ($3.50)
3. 🍫 Mocha ($4.00)
4. 📊 Show Report
5. 🔧 Maintenance
6. 💰 Collect Money
7. 🔄 Switch Machine

Your choice: 1

💳 Espresso costs $2.50
Insert coins: $3.00

✅ Making your Espresso...
🔥 Heating water to 92°C...
⚡ Extracting coffee at 9 bars pressure...
☕ Your Espresso is ready!

💰 Change: $0.50
🧾 Receipt: Espresso - $2.50 (Saved $0.50)

Continue? (y/n): y
```

### Requirements:
1. **Multiple Machine Types:** Different capabilities and drink menus
2. **Ingredient Management:** Track and validate ingredient levels
3. **Payment System:** Handle coins, change, and revenue tracking
4. **Maintenance Mode:** Refill ingredients, clean machine
5. **Business Analytics:** Sales reports, popular drinks, profit margins

## 💡 Key Java Concepts You'll Practice

### **1. Class Design and Encapsulation**
```java
public class CoffeeMachine {
    // Private fields - data hiding
    private String machineType;
    private int water, milk, coffee, cups;
    private double revenue;
    private boolean isOperational;
    
    // Constructor overloading
    public CoffeeMachine(String type) {
        this(type, 1000, 500, 200, 50);
    }
    
    public CoffeeMachine(String type, int water, int milk, int coffee, int cups) {
        this.machineType = type;
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cups = cups;
        this.revenue = 0.0;
        this.isOperational = true;
    }
    
    // Getter methods
    public String getMachineType() { return machineType; }
    public int getWater() { return water; }
    public double getRevenue() { return revenue; }
    public boolean isOperational() { return isOperational; }
    
    // Setter methods with validation
    public void setWater(int water) {
        if (water >= 0) {
            this.water = water;
        } else {
            throw new IllegalArgumentException("Water cannot be negative");
        }
    }
}
```

### **2. Method Overloading and Business Logic**
```java
public class DrinkMaker {
    // Method overloading - same name, different parameters
    public String makeDrink(String type) {
        return makeDrink(type, "regular");
    }
    
    public String makeDrink(String type, String size) {
        return makeDrink(type, size, false);
    }
    
    public String makeDrink(String type, String size, boolean extraShot) {
        Recipe recipe = getRecipe(type, size, extraShot);
        
        if (!hasIngredients(recipe)) {
            return "❌ Insufficient ingredients for " + type;
        }
        
        consumeIngredients(recipe);
        revenue += recipe.getPrice();
        
        return String.format("✅ %s %s%s ready! ($%.2f)", 
                           size, type, 
                           extraShot ? " with extra shot" : "",
                           recipe.getPrice());
    }
    
    private boolean hasIngredients(Recipe recipe) {
        return water >= recipe.getWater() && 
               milk >= recipe.getMilk() && 
               coffee >= recipe.getCoffee() &&
               cups > 0;
    }
}
```

### **3. Static Methods and Utility Classes**
```java
public class CoffeeUtils {
    // Static constants
    public static final double ESPRESSO_PRICE = 2.50;
    public static final double LATTE_PRICE = 3.50;
    public static final double CAPPUCCINO_PRICE = 3.00;
    
    // Static utility methods
    public static String formatCurrency(double amount) {
        return String.format("$%.2f", amount);
    }
    
    public static boolean isValidCoin(double coin) {
        double[] validCoins = {0.25, 0.50, 1.00, 2.00, 5.00, 10.00, 20.00};
        for (double valid : validCoins) {
            if (Math.abs(coin - valid) < 0.01) {
                return true;
            }
        }
        return false;
    }
    
    public static double calculateChange(double paid, double cost) {
        return Math.round((paid - cost) * 100.0) / 100.0;
    }
}
```

## 🎯 Challenges

**Challenge 1: Basic Coffee Machine**
- Create a simple CoffeeMachine class with basic drinks
- Implement ingredient tracking and validation
- Add simple payment processing

**Challenge 2: Multiple Machine Types**
- Create different machine classes (inheritance or composition)
- Implement different drink menus per machine type
- Add machine-specific features and limitations

**Challenge 3: Business Management**
- Add maintenance scheduling and costs
- Implement dynamic pricing based on ingredient costs
- Create sales analytics and reporting

**Challenge 4: Advanced Features**
- Customer loyalty program with discounts
- Inventory management with automatic reordering
- Multi-location coffee shop chain management

## 📚 Key Concepts You'll Master

**From Python (Review):**
- Class definition and object instantiation
- Method calls and attribute access
- Constructor concepts

**New in Java:**
- **Encapsulation:** Private fields with public getters/setters
- **Constructor overloading:** Multiple ways to create objects
- **Method overloading:** Same method name, different parameters
- **Static methods:** Class-level functionality
- **this keyword:** Referencing current object
- **Access modifiers:** public, private, protected

## 🔗 Python vs Java Quick Reference

| Concept | Python | Java |
|---------|--------|------|
| Class definition | `class CoffeeMachine:` | `public class CoffeeMachine {` |
| Constructor | `def __init__(self, water):` | `public CoffeeMachine(int water) {` |
| Instance variable | `self.water = water` | `this.water = water;` |
| Method definition | `def make_coffee(self):` | `public String makeCoffee() {` |
| Object creation | `machine = CoffeeMachine()` | `CoffeeMachine machine = new CoffeeMachine();` |
| Method call | `machine.make_coffee()` | `machine.makeCoffee();` |
| Private variable | `self._water` (convention) | `private int water;` (enforced) |

---
**Previous**: Day 12 - Higher or Lower Game | **Next**: Day 14 - Debugging Practice