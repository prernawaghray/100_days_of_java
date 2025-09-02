/* 
1. **Challenge 1**: Add more inputs (favorite color, birth month) for more creative names
2. **Challenge 2**: Make the program ask if the user wants to generate another name
3. **Challenge 3**: Add some random adjectives to make the names more interesting
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BandNameGeneratorExtended {

    public static void main(String[] args) {
    String message = """
    Welcome to the Band Name Generator!
    Let's create something awesome!
    """;
    String answer, adjective;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    do { System.out.println(message);
    String firstName, lastName, city, petName, favoriteColor, birthMonth;
    System.out.print("What's the name of the city you grew up in? ");
    city = scanner.nextLine();
    System.out.print("What's your pet's name? ");
    petName = scanner.nextLine();
    System.out.print("What's your favorite color? ");
    favoriteColor = scanner.nextLine();
    System.out.print("What's your birth month? ");
    birthMonth = scanner.nextLine();

    List<String> names = new ArrayList<>();
    names.add(city);
    names.add(petName);
    names.add(favoriteColor);
    names.add(birthMonth);
    Collections.shuffle(names);
   
    List<String> adjectivesList = new ArrayList<>();
    adjectivesList.add("Beautiful");
    adjectivesList.add("Serene");
    adjectivesList.add("Elegant");
    adjectivesList.add("Enchanting");
    adjectivesList.add("Mystical");
    adjectivesList.add("Magical");
    adjectivesList.add("Whimsical");
    adjectivesList.add("Charming");
    adjectivesList.add("Enigmatic");
    // Collections.shuffle(adjectivesList);
    adjective = adjectivesList.get(random.nextInt(adjectivesList.size()));
    // adjective = adjectivesList.get(0);

    firstName = names.get(0);
    lastName = names.get(1);
    // firstName = names.get(random.nextInt(names.size())); this may end up with the same name twice
    // lastName = names.get(random.nextInt(names.size()));

    String bandName = "Your band name could be %s %s %s!".formatted(adjective, firstName, lastName);
    System.out.println(bandName);
    System.out.println("Do you want to generate another name? (y/n)");
    answer = scanner.nextLine();
    } while (answer.equalsIgnoreCase("y")); 
    scanner.close();
    System.out.println("Thank you for using the Band Name Generator!");
    }

}
