# Day 7 - Caesar Cipher (Python → Java String Algorithms)

## 🐍 ➡️ ☕ Python to Java Transition

**Building on Day 6:** You've mastered Java Collections and game state management. Now let's dive into string algorithms and cryptographic concepts!

## 🎯 Learning Objectives
- Learn ASCII manipulation and character arithmetic
- Master string building and transformation algorithms
- Practice modular arithmetic and mathematical operations
- Understand StringBuilder for efficient string operations
- Compare Java's explicit character handling with Python's string flexibility

## 📖 Theory - Python vs Java String Manipulation

### 🐍 Python String Algorithms (What You Know)
```python
def caesar_cipher(text, shift):
    result = ""
    
    for char in text:
        if char.isalpha():
            # Get ASCII value and shift
            ascii_offset = ord('A') if char.isupper() else ord('a')
            shifted = (ord(char) - ascii_offset + shift) % 26
            result += chr(shifted + ascii_offset)
        else:
            result += char
    
    return result

# Python - Simple and intuitive
message = "Hello World!"
encrypted = caesar_cipher(message, 3)
print(f"Encrypted: {encrypted}")  # "Khoor Zruog!"
```

### ☕ Java String Algorithms (What You're Learning)
```java
public class CaesarCipher {
    
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                // Determine if uppercase or lowercase
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                
                // Apply Caesar cipher formula
                int shifted = (c - base + shift) % 26;
                if (shifted < 0) shifted += 26; // Handle negative shifts
                
                result.append((char) (shifted + base));
            } else {
                result.append(c); // Keep non-letters unchanged
            }
        }
        
        return result.toString();
    }
}

// Java - More explicit but powerful
String message = "Hello World!";
String encrypted = CaesarCipher.encrypt(message, 3);
System.out.println("Encrypted: " + encrypted); // "Khoor Zruog!"
```

## 🚀 Project: Advanced Cryptography Suite

Create a comprehensive encryption/decryption tool with multiple cipher types and analysis features!

### Example Output:
```
🔐 JAVA CRYPTOGRAPHY SUITE 🔐
═══════════════════════════════════

Welcome to the Advanced Cipher Tool!

Main Menu:
1. 🔒 Caesar Cipher
2. 🗝️ Vigenère Cipher  
3. 🔓 Cipher Breaker (Brute Force)
4. 📊 Frequency Analysis
5. 📁 File Encryption/Decryption
6. 🎯 Cipher Challenge Game
7. ⚙️ Settings

Your choice: 1

🔒 CAESAR CIPHER MODE 🔒
═══════════════════════════

Options:
1. Encrypt message
2. Decrypt message
3. Try all shifts (brute force)

Your choice: 1

Enter your message: The quick brown fox jumps over the lazy dog
Enter shift value (1-25): 13

🔐 ENCRYPTION RESULT 🔐
═══════════════════════════
Original:  The quick brown fox jumps over the lazy dog
Encrypted: Gur dhvpx oebja sbk whzcf bire gur ynml qbt
Shift:     13 (ROT13)

📋 Analysis:
- Message length: 43 characters
- Letters encrypted: 35
- Special characters preserved: 8
- Encryption strength: Medium (ROT13 is easily recognizable)

Options:
1. 📋 Copy to clipboard
2. 💾 Save to file
3. 🔄 Try different shift
4. 🏠 Return to main menu

Your choice: 3

🔍 ALL POSSIBLE SHIFTS 🔍
═══════════════════════════
Shift 1:  Uif rvjdl cspxo gpy kvnqt pwfs uif mbaz eph
Shift 2:  Vjg swkem dtqyp hqz lworv qxgt vjg ncba fqi
Shift 3:  Wkh txlfn eurzo ira mxpsw ryhu wkh odcb grj
...
Shift 13: Gur dhvpx oebja sbk whzcf bire gur ynml qbt ⭐ (ROT13)
...
Shift 25: Sgd pthbj aqnvm enw itlor nudq sgd kzyx cnf

Most likely decryption: Shift 13 (ROT13)
```

### Requirements:
1. **Multiple Cipher Types:** Caesar, Vigenère, Atbash, Rail Fence
2. **Brute Force Analysis:** Try all possible keys automatically
3. **Frequency Analysis:** Letter frequency comparison with English
4. **File Operations:** Encrypt/decrypt entire files
5. **Interactive Games:** Cipher-breaking challenges and puzzles

## 💡 Key Java Concepts You'll Practice

### **1. Character Manipulation and ASCII Operations**
```java
public class CharacterUtils {
    
    // ASCII value manipulation
    public static char shiftCharacter(char c, int shift) {
        if (!Character.isLetter(c)) {
            return c; // Return unchanged if not a letter
        }
        
        // Determine the base (A for uppercase, a for lowercase)
        char base = Character.isUpperCase(c) ? 'A' : 'a';
        
        // Apply modular arithmetic for wrapping
        int position = c - base; // 0-25
        int shiftedPosition = (position + shift) % 26;
        
        // Handle negative shifts
        if (shiftedPosition < 0) {
            shiftedPosition += 26;
        }
        
        return (char) (base + shiftedPosition);
    }
    
    // Character frequency analysis
    public static Map<Character, Integer> getFrequency(String text) {
        Map<Character, Integer> frequency = new HashMap<>();
        
        for (char c : text.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                frequency.merge(c, 1, Integer::sum);
            }
        }
        
        return frequency;
    }
    
    // Calculate character distribution
    public static double[] getLetterDistribution(String text) {
        double[] distribution = new double[26];
        int totalLetters = 0;
        
        for (char c : text.toUpperCase().toCharArray()) {
            if (Character.isLetter(c)) {
                distribution[c - 'A']++;
                totalLetters++;
            }
        }
        
        // Convert counts to percentages
        for (int i = 0; i < 26; i++) {
            distribution[i] = (distribution[i] / totalLetters) * 100;
        }
        
        return distribution;
    }
}
```

### **2. Advanced Cipher Implementations**
```java
public class VigenereCipher {
    
    public static String encrypt(String plaintext, String key) {
        StringBuilder result = new StringBuilder();
        String upperKey = key.toUpperCase();
        int keyIndex = 0;
        
        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                
                // Get the key character for this position
                char keyChar = upperKey.charAt(keyIndex % upperKey.length());
                int keyShift = keyChar - 'A';
                
                // Apply Vigenère cipher
                int shifted = (c - base + keyShift) % 26;
                result.append((char) (shifted + base));
                
                keyIndex++; // Only advance key for letters
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
    
    public static String decrypt(String ciphertext, String key) {
        StringBuilder result = new StringBuilder();
        String upperKey = key.toUpperCase();
        int keyIndex = 0;
        
        for (char c : ciphertext.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                
                char keyChar = upperKey.charAt(keyIndex % upperKey.length());
                int keyShift = keyChar - 'A';
                
                // Reverse the Vigenère cipher
                int shifted = (c - base - keyShift + 26) % 26;
                result.append((char) (shifted + base));
                
                keyIndex++;
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
```

### **3. Cipher Analysis and Breaking**
```java
public class CipherBreaker {
    
    // English letter frequency (approximate percentages)
    private static final double[] ENGLISH_FREQ = {
        8.12, 1.49, 2.78, 4.25, 12.02, 2.23, 2.02, 6.09, 6.97, 0.15,
        0.77, 4.03, 2.41, 6.75, 7.51, 1.93, 0.10, 5.99, 6.33, 9.06,
        2.76, 0.98, 2.36, 0.15, 1.97, 0.07
    };
    
    public static List<CipherResult> bruteForceCaesar(String ciphertext) {
        List<CipherResult> results = new ArrayList<>();
        
        for (int shift = 1; shift <= 25; shift++) {
            String decrypted = CaesarCipher.decrypt(ciphertext, shift);
            double score = calculateEnglishScore(decrypted);
            
            results.add(new CipherResult(shift, decrypted, score));
        }
        
        // Sort by English-likeness score (higher is better)
        results.sort((a, b) -> Double.compare(b.getScore(), a.getScore()));
        
        return results;
    }
    
    private static double calculateEnglishScore(String text) {
        double[] textFreq = CharacterUtils.getLetterDistribution(text);
        double score = 0.0;
        
        // Calculate chi-squared statistic
        for (int i = 0; i < 26; i++) {
            double expected = ENGLISH_FREQ[i];
            double observed = textFreq[i];
            
            if (expected > 0) {
                score += Math.pow(observed - expected, 2) / expected;
            }
        }
        
        // Lower chi-squared means more English-like
        return 1.0 / (1.0 + score);
    }
    
    public static class CipherResult {
        private int key;
        private String plaintext;
        private double score;
        
        public CipherResult(int key, String plaintext, double score) {
            this.key = key;
            this.plaintext = plaintext;
            this.score = score;
        }
        
        // Getters
        public int getKey() { return key; }
        public String getPlaintext() { return plaintext; }
        public double getScore() { return score; }
        
        @Override
        public String toString() {
            return String.format("Shift %2d (Score: %.3f): %s", 
                               key, score, plaintext);
        }
    }
}
```

## 🎯 Challenges

**Challenge 1: Basic Caesar Cipher**
- Implement encryption and decryption with shift values
- Handle both uppercase and lowercase letters
- Preserve non-alphabetic characters

**Challenge 2: Advanced Ciphers**
- Implement Vigenère cipher with keyword support
- Add Atbash cipher (A↔Z, B↔Y, etc.)
- Create Rail Fence cipher with configurable rails

**Challenge 3: Cipher Breaking**
- Implement brute force attack on Caesar cipher
- Add frequency analysis for cipher identification
- Create automatic cipher type detection

**Challenge 4: File Operations & Games**
- Encrypt/decrypt entire text files
- Create interactive cipher-breaking games
- Implement steganography (hiding messages in text)

## 📚 Key Concepts You'll Master

**From Python (Review):**
- String iteration and character manipulation
- ASCII value operations with `ord()` and `chr()`
- Modular arithmetic for wrapping

**New in Java:**
- **StringBuilder:** Efficient string building vs concatenation
- **Character class:** `isLetter()`, `isUpperCase()`, `toUpperCase()`
- **Type casting:** `(char)` and `(int)` conversions
- **Modular arithmetic:** Handling negative numbers properly
- **Stream operations:** Modern Java string processing

## 🔗 Python vs Java Quick Reference

| Operation | Python | Java |
|-----------|--------|------|
| Get ASCII | `ord('A')` | `(int) 'A'` |
| From ASCII | `chr(65)` | `(char) 65` |
| Check letter | `char.isalpha()` | `Character.isLetter(char)` |
| Check uppercase | `char.isupper()` | `Character.isUpperCase(char)` |
| String building | `result += char` | `StringBuilder.append(char)` |
| Modulo | `(x + shift) % 26` | `(x + shift) % 26` |
| String iteration | `for char in text:` | `for (char c : text.toCharArray()) {` |

---
**Previous**: Day 6 - Hangman Game | **Next**: Day 8 - Calculator App