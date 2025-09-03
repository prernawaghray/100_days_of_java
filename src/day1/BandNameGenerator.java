package day1; 
import java.util.Scanner;

public class BandNameGenerator {
    public static void main(String[] args) {
    String message = """
    Welcome to the Band Name Generator!
    Let's create something awesome!
    """;
    System.out.println(message);
    String firstName, lastName;
    try (Scanner scanner = new Scanner(System.in)) {
        System.out.print("What's the name of the city you grew up in? ");
        firstName = scanner.nextLine();
        System.out.print("What's your pet's name? ");
        lastName = scanner.nextLine();
    } // Automatically closes scanner
    String bandName = "Your band name could be %s %s!".formatted(firstName, lastName);
    System.out.println(bandName);
    } 
}

