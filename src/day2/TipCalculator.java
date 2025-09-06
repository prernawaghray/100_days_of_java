package day2;
import java.util.Scanner;


public class TipCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Tip Calculator!");
        System.out.println("Enter your bill amount in $");
        String billStr = scanner.nextLine();
        float bill = Float.parseFloat(billStr);
        System.out.println("Enter the tip percentage (15%, 18%, 20%, or custom): [Only mention numbers]");
        String tipStr = scanner.nextLine();
        float tip = Float.parseFloat(tipStr); // float will do just fine as double is more memory intensive, a bit of an overkill for a small project
        System.out.println("Enter the number of people paying the bill:");
        String peopleStr = scanner.nextLine();
        int people = Integer.parseInt(peopleStr);
        float tipAmount = bill * tip / 100;
        float totalBill = bill + tipAmount;
        float billPerPerson = totalBill / people;
        System.out.println("The tip amount is $" + tipAmount);
        System.out.println("The total bill is $" + totalBill);
        System.out.println("The bill per person is $%.2f".formatted(billPerPerson));
        scanner.close();
    }
}
