package day3;
import java.util.Scanner;
import java.util.Random;

// Cursor generated code for game prompts
public class AdventureGameAdvanced {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static int playerHealth = 100;
    private static int playerScore = 0;
    private static boolean hasKey = false;
    private static boolean hasSword = false;
    private static boolean hasPotion = false;
    
    public static void main(String[] args) {

        displayIntro();
        startAdventure();
        displayFinalScore();
        scanner.close();
    }
    
    public static void displayIntro() {
        System.out.println("🏰 Welcome to the Mystic Castle Adventure! 🏰");
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("You are a brave adventurer seeking the legendary Crystal of Power!");
        System.out.println("Your health: " + playerHealth + " | Your score: " + playerScore);
        System.out.println("═══════════════════════════════════════════════");
        System.out.println();
    }
    
    public static void startAdventure() {
        System.out.println("You stand before a mysterious castle with three paths:");
        System.out.println("1. Enter through the main gate (Brave approach)");
        System.out.println("2. Sneak around to the back entrance (Stealthy approach)");
        System.out.println("3. Climb the tower wall (Risky approach)");
        System.out.print("Your choice (1/2/3): ");
        
        String choice = getValidChoice("123");
        
        switch (choice) {
            case "1" -> mainGateEntrance();
            case "2" -> backEntranceRoute();
            case "3" -> towerWallClimb();
        }
    }
    
    public static void mainGateEntrance() {
        System.out.println("\n⚔️ MAIN GATE ENTRANCE ⚔️");
        System.out.println("You boldly approach the main gate. A massive stone guardian blocks your path!");
        System.out.println("The guardian speaks: 'Answer my riddle or face my wrath!'");
        System.out.println();
        System.out.println("Riddle: 'I am not alive, but I grow; I don't have lungs, but I need air. What am I?'");
        System.out.print("Your answer: ");
        
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("fire") || answer.equals("flame")) {
            System.out.println("🎉 'Correct!' booms the guardian. 'You may pass, wise one!'");
            playerScore += 20;
            System.out.println("The guardian steps aside and hands you a golden key!");
            hasKey = true;
            castleCourtyard();
        } else {
            System.out.println("💥 'WRONG!' The guardian attacks!");
            if (battleGuardian()) {
                System.out.println("You defeated the guardian but you're wounded!");
                playerHealth -= 30;
                playerScore += 10;
                castleCourtyard();
            } else {
                gameOver("The stone guardian was too powerful for you!");
            }
        }
    }
    
    public static void backEntranceRoute() {
        System.out.println("\n🌙 BACK ENTRANCE ROUTE 🌙");
        System.out.println("You sneak around to the back entrance...");
        System.out.println("You find a locked door with a riddle carved into it:");
        System.out.println("'I have keys but no locks. I have space but no room. What am I?'");
        System.out.print("Your answer: ");
        
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("keyboard")) {
            System.out.println("🎉 Correct! The door creaks open...");
            playerScore += 15;
            kitchenArea();
        } else {
            System.out.println("🚨 Incorrect! But you notice a window above...");
            System.out.println("1. Try to climb through the window");
            System.out.println("2. Look for another way in");
            System.out.print("Your choice (1/2): ");
            
            String choice = getValidChoice("12");
            if (choice.equals("1")) {
                if (random.nextBoolean()) {
                    System.out.println("You successfully climb through the window!");
                    playerScore += 5;
                    kitchenArea();
                } else {
                    System.out.println("You fall and hurt yourself!");
                    playerHealth -= 20;
                    System.out.println("But you manage to find a side door...");
                    kitchenArea();
                }
            } else {
                System.out.println("You find a servant's entrance and slip inside quietly.");
                playerScore += 10;
                kitchenArea();
            }
        }
    }
    
    public static void towerWallClimb() {
        System.out.println("\n🧗 TOWER WALL CLIMB 🧗");
        System.out.println("You begin climbing the treacherous tower wall...");
        
        int climbChance = random.nextInt(100);
        
        if (climbChance < 30) {
            System.out.println("💀 You lose your grip and fall! The adventure ends here...");
            gameOver("Your climbing skills weren't enough for the tower wall!");
        } else if (climbChance < 70) {
            System.out.println("⚠️ You slip but manage to grab a ledge! You're hurt but alive.");
            playerHealth -= 25;
            System.out.println("You find a window and climb into the tower room.");
            towerRoom();
        } else {
            System.out.println("🎉 Amazing! You climb like a spider and reach the tower window!");
            playerScore += 25;
            System.out.println("You discover a secret room with treasure!");
            towerRoom();
        }
    }
    
    public static void kitchenArea() {
        System.out.println("\n🍳 CASTLE KITCHEN 🍳");
        System.out.println("You're in the castle kitchen. You see:");
        System.out.println("A) A glowing potion on the table");
        System.out.println("B) Stairs leading to the dungeon");
        System.out.println("C) A door to the throne room");
        System.out.print("Your choice (A/B/C): ");
        
        String choice = getValidChoice("ABC").toUpperCase();
        
        switch (choice) {
            case "A" -> {
                System.out.println("You examine the glowing potion...");
                System.out.println("1. Drink it immediately");
                System.out.println("2. Smell it first");
                System.out.println("3. Take it with you");
                System.out.print("Your choice (1/2/3): ");
                
                String potionChoice = getValidChoice("123");
                switch (potionChoice) {
                    case "1" -> {
                        if (random.nextBoolean()) {
                            System.out.println("🎉 It's a healing potion! You feel refreshed!");
                            playerHealth = Math.min(100, playerHealth + 30);
                            playerScore += 10;
                        } else {
                            System.out.println("💀 It was poison! You feel weak...");
                            playerHealth -= 40;
                            if (playerHealth <= 0) {
                                gameOver("The mysterious potion was your downfall!");
                                return;
                            }
                        }
                    }
                    case "2" -> {
                        System.out.println("Smart! It smells like healing herbs. You drink it safely.");
                        playerHealth = Math.min(100, playerHealth + 20);
                        playerScore += 15;
                    }
                    case "3" -> {
                        System.out.println("Wise choice! You pocket the potion for later.");
                        hasPotion = true;
                        playerScore += 5;
                    }
                }
                throneRoom();
            }
            case "B" -> dungeonArea();
            case "C" -> throneRoom();
        }
    }
    
    public static void towerRoom() {
        System.out.println("\n🗼 TOWER ROOM 🗼");
        System.out.println("You're in a mysterious tower room filled with ancient books and artifacts.");
        
        if (random.nextBoolean()) {
            System.out.println("You find an enchanted sword glowing with magical energy!");
            hasSword = true;
            playerScore += 20;
            System.out.println("⚔️ You now have a magical sword!");
        } else {
            System.out.println("You find a dusty spellbook with a teleportation spell!");
            System.out.println("1. Cast the spell immediately");
            System.out.println("2. Study it carefully first");
            System.out.print("Your choice (1/2): ");
            
            String choice = getValidChoice("12");
            if (choice.equals("1")) {
                System.out.println("✨ The spell works! You teleport to the throne room!");
                playerScore += 15;
                throneRoom();
                return;
            } else {
                System.out.println("Good thinking! You learn the spell properly and gain wisdom.");
                playerScore += 10;
            }
        }
        
        System.out.println("You find stairs leading down to the main castle.");
        castleCourtyard();
    }
    
    public static void castleCourtyard() {
        System.out.println("\n🏰 CASTLE COURTYARD 🏰");
        System.out.println("You're in the main courtyard. Ancient statues watch your every move.");
        System.out.println("You see three paths:");
        System.out.println("1. Grand staircase to the throne room");
        System.out.println("2. Dark passage to the dungeon");
        System.out.println("3. Mysterious door (requires a key)");
        System.out.print("Your choice (1/2/3): ");
        
        String choice = getValidChoice("123");
        
        switch (choice) {
            case "1" -> throneRoom();
            case "2" -> dungeonArea();
            case "3" -> {
                if (hasKey) {
                    System.out.println("🗝️ Your golden key fits perfectly!");
                    secretChamber();
                } else {
                    System.out.println("🚫 The door is locked. You need a key!");
                    System.out.println("You must choose another path...");
                    castleCourtyard();
                }
            }
        }
    }
    
    public static void dungeonArea() {
        System.out.println("\n⛓️ CASTLE DUNGEON ⛓️");
        System.out.println("You descend into the dark, damp dungeon...");
        System.out.println("You hear a growling sound echoing from the shadows!");
        
        if (random.nextInt(100) < 60) {
            System.out.println("🐺 A fierce dungeon wolf appears!");
            if (battleWolf()) {
                System.out.println("You defeated the wolf and found a treasure chest!");
                playerScore += 25;
                System.out.println("Inside the chest, you find the Crystal of Power!");
                victoryEnding("dungeon");
            } else {
                gameOver("The dungeon wolf proved too fierce!");
            }
        } else {
            System.out.println("The dungeon is empty, but you find ancient prison cells...");
            System.out.println("In one cell, you discover a skeleton holding a map!");
            System.out.println("The map shows the location of the Crystal of Power in the throne room!");
            playerScore += 15;
            throneRoom();
        }
    }
    
    public static void throneRoom() {
        System.out.println("\n👑 THRONE ROOM 👑");
        System.out.println("You enter the magnificent throne room...");
        System.out.println("On the throne sits an ancient king, but he appears to be sleeping...");
        System.out.println("Behind the throne, you see the Crystal of Power glowing brightly!");
        
        System.out.println("1. Sneak past the sleeping king");
        System.out.println("2. Wake the king and speak to him");
        System.out.println("3. Try to grab the crystal quickly");
        System.out.print("Your choice (1/2/3): ");
        
        String choice = getValidChoice("123");
        
        switch (choice) {
            case "1" -> {
                if (random.nextInt(100) < 70) {
                    System.out.println("🤫 You successfully sneak past the king!");
                    System.out.println("You reach the Crystal of Power!");
                    victoryEnding("stealth");
                } else {
                    System.out.println("💥 You accidentally knock over a vase! The king awakens!");
                    kingBattle();
                }
            }
            case "2" -> {
                System.out.println("You gently wake the ancient king...");
                System.out.println("King: 'Ah, a brave adventurer! I have been waiting for someone worthy.'");
                System.out.println("King: 'Answer my final riddle to prove your worth!'");
                finalRiddle();
            }
            case "3" -> {
                System.out.println("You rush toward the crystal!");
                System.out.println("💥 The king awakens and is angry at your rudeness!");
                kingBattle();
            }
        }
    }
    
    public static void secretChamber() {
        System.out.println("\n💎 SECRET CHAMBER 💎");
        System.out.println("You unlock the mysterious door and enter a hidden chamber!");
        System.out.println("The room is filled with ancient treasures and magical artifacts!");
        System.out.println("In the center, the Crystal of Power floats in a beam of light!");
        
        System.out.println("But wait! A magical guardian spirit appears!");
        System.out.println("Spirit: 'You have shown wisdom by finding the key. The crystal is yours!'");
        
        playerScore += 50;
        victoryEnding("secret");
    }
    
    public static void finalRiddle() {
        System.out.println("\n🧩 FINAL RIDDLE 🧩");
        System.out.println("King: 'What gets wetter the more it dries?'");
        System.out.print("Your answer: ");
        
        String answer = scanner.nextLine().toLowerCase();
        
        if (answer.equals("towel") || answer.equals("a towel")) {
            System.out.println("👑 'Excellent!' says the king. 'You are truly wise!'");
            System.out.println("The king hands you the Crystal of Power personally!");
            playerScore += 40;
            victoryEnding("wisdom");
        } else {
            System.out.println("👑 'Incorrect, but your courage brought you this far.'");
            System.out.println("'I will give you one more chance to prove yourself in combat!'");
            kingBattle();
        }
    }
    
    public static boolean battleGuardian() {
        System.out.println("\n⚔️ BATTLE: Stone Guardian ⚔️");
        return battle(80, "Stone Guardian");
    }
    
    public static boolean battleWolf() {
        System.out.println("\n⚔️ BATTLE: Dungeon Wolf ⚔️");
        return battle(60, "Dungeon Wolf");
    }
    
    public static void kingBattle() {
        System.out.println("\n⚔️ BATTLE: Ancient King ⚔️");
        if (battle(100, "Ancient King")) {
            System.out.println("You have defeated the ancient king in honorable combat!");
            System.out.println("With his last breath, he grants you the Crystal of Power!");
            victoryEnding("combat");
        } else {
            gameOver("The ancient king's power was beyond your abilities!");
        }
    }
    
    public static boolean battle(int enemyHealth, String enemyName) {
        System.out.println("Battle begins against " + enemyName + "!");
        
        while (enemyHealth > 0 && playerHealth > 0) {
            System.out.println("\nYour health: " + playerHealth + " | " + enemyName + " health: " + enemyHealth);
            System.out.println("1. Attack with weapon");
            System.out.println("2. Defend");
            if (hasPotion) {
                System.out.println("3. Use healing potion");
            }
            System.out.print("Your choice: ");
            
            String choice = hasPotion ? getValidChoice("123") : getValidChoice("12");
            
            switch (choice) {
                case "1" -> {
                    int damage = hasSword ? random.nextInt(30) + 20 : random.nextInt(20) + 10;
                    enemyHealth -= damage;
                    System.out.println("You deal " + damage + " damage!");
                }
                case "2" -> {
                    System.out.println("You defend and reduce incoming damage!");
                    int enemyDamage = random.nextInt(15) + 5;
                    playerHealth -= enemyDamage;
                    System.out.println(enemyName + " deals " + enemyDamage + " damage!");
                    continue; // Skip enemy attack since we already took reduced damage
                }
                case "3" -> {
                    if (hasPotion) {
                        playerHealth = Math.min(100, playerHealth + 40);
                        hasPotion = false;
                        System.out.println("You use your healing potion and restore 40 health!");
                    }
                }
            }
            
            // Enemy attack (if player didn't defend)
            if (!choice.equals("2") && enemyHealth > 0) {
                int enemyDamage = random.nextInt(25) + 10;
                playerHealth -= enemyDamage;
                System.out.println(enemyName + " deals " + enemyDamage + " damage to you!");
            }
        }
        
        return playerHealth > 0;
    }
    
    public static void victoryEnding(String endingType) {
        System.out.println("\n🎉 VICTORY! 🎉");
        System.out.println("═══════════════════════════════════════");
        
        switch (endingType) {
            case "stealth" -> {
                System.out.println("🥷 STEALTH MASTER ENDING");
                System.out.println("You successfully obtained the Crystal of Power through cunning and stealth!");
                playerScore += 30;
            }
            case "wisdom" -> {
                System.out.println("🧠 WISDOM MASTER ENDING");
                System.out.println("Your intelligence and wisdom impressed the ancient king!");
                playerScore += 40;
            }
            case "combat" -> {
                System.out.println("⚔️ WARRIOR ENDING");
                System.out.println("You proved your strength in honorable combat!");
                playerScore += 35;
            }
            case "secret" -> {
                System.out.println("🗝️ SECRET MASTER ENDING");
                System.out.println("You discovered the hidden path and earned the crystal through exploration!");
                playerScore += 50;
            }
            case "dungeon" -> {
                System.out.println("🐺 DUNGEON EXPLORER ENDING");
                System.out.println("You braved the dangerous dungeon and claimed your reward!");
                playerScore += 25;
            }
        }
        
        System.out.println("The Crystal of Power is yours! You have saved the kingdom!");
        System.out.println("═══════════════════════════════════════");
    }
    
    public static void gameOver(String reason) {
        System.out.println("\n💀 GAME OVER 💀");
        System.out.println("═══════════════════════════════════════");
        System.out.println(reason);
        System.out.println("Your adventure ends here...");
        System.out.println("═══════════════════════════════════════");
    }
    
    public static void displayFinalScore() {
        System.out.println("\n📊 FINAL STATISTICS 📊");
        System.out.println("═══════════════════════════════════════");
        System.out.println("Final Score: " + playerScore);
        System.out.println("Final Health: " + Math.max(0, playerHealth));
        System.out.println("Items Collected:");
        System.out.println("  🗝️ Golden Key: " + (hasKey ? "Yes" : "No"));
        System.out.println("  ⚔️ Magic Sword: " + (hasSword ? "Yes" : "No"));
        System.out.println("  🧪 Healing Potion: " + (hasPotion ? "Yes" : "No"));
        
        if (playerScore >= 100) {
            System.out.println("🏆 LEGENDARY ADVENTURER! 🏆");
        } else if (playerScore >= 75) {
            System.out.println("🥇 MASTER ADVENTURER!");
        } else if (playerScore >= 50) {
            System.out.println("🥈 SKILLED ADVENTURER!");
        } else if (playerScore >= 25) {
            System.out.println("🥉 BRAVE ADVENTURER!");
        } else {
            System.out.println("📖 NOVICE ADVENTURER - Keep practicing!");
        }
        System.out.println("═══════════════════════════════════════");
        
        System.out.print("Would you like to play again? (y/n): ");
        String playAgain = scanner.nextLine().toLowerCase();
        if (playAgain.equals("y") || playAgain.equals("yes")) {
            // Reset game state
            playerHealth = 100;
            playerScore = 0;
            hasKey = false;
            hasSword = false;
            hasPotion = false;
            System.out.println("\n" + "=".repeat(50));
            main(new String[0]); // Restart the game
        } else {
            System.out.println("Thanks for playing! Farewell, adventurer! 👋");
        }
    }
    
    public static String getValidChoice(String validOptions) {
        String choice;
        do {
            choice = scanner.nextLine().trim();
            if (validOptions.contains(choice.toUpperCase())) {
                return choice;
            }
            System.out.print("Invalid choice! Please enter one of (" + validOptions + "): ");
        } while (true);
    }
    
}
