package day3;
import java.util.Scanner;

public class AdventureGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Treasure Island.");
        System.out.println("Your mission is to find the treasure.");
        System.out.println("You're at a crossroad, where do you want to go?");
        System.out.println("Type \"left\" or \"right\".");
        String choice1 = scanner.nextLine();
        if ("left".equals(choice1)) { // this handles the null values
            System.out.println("""
                You've come to a lake.
                There is an island in the middle of the lake.
                Type "wait" to wait for a boat.
                Type "swim" to swim across.""");
            String choice2 = scanner.nextLine().toLowerCase();
            if ("wait".equals(choice2)) {
                System.out.println("""
                    You arrive at the island unharmed.
                    There is a house with 3 doors. One red,
                    one yellow and one blue.
                    Which colour do you choose?""");
                String choice3 = scanner.nextLine().toLowerCase();
                if ("red".equals(choice3)) {
                    System.out.println("It's a room full of fire. Game Over! 🔥");
                } else if ("yellow".equals(choice3)) {
                    System.out.println("You found the treasure! You Win! 🏆");
                } else if ("blue".equals(choice3)) {
                    System.out.println("You enter a room of beasts. Game Over! 🐺");
                } else {
                    System.out.println("You chose a door that doesn't exist. Game Over! 🚪");
                }
            } else {
                System.out.println("You got attacked by an angry trout. Game Over! 🐟");
            }
        } else {
            System.out.println("You fell into a hole. Game Over! 🕳️");
        }
        
        scanner.close();
    }
}