package day1_5; 
import java.util.Scanner;

public class BandBudgetCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the Band Budget Calculator!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== BAND NAME GENERATION ===");
        System.out.print("What's the name of the city you grew up in? ");
        String city = scanner.nextLine();
        System.out.print("What's your pet's name? ");
        String pet = scanner.nextLine();
        String bandName = city + " " + pet;
        System.out.println("🎸 Your band name: \"" + bandName + "\" 🎸");
        System.out.println("=== BUDGET ANALYSIS ===");
        System.out.println("What's your monthly income? $");
        String incomeStr = scanner.nextLine();
        double income = Double.parseDouble(incomeStr);
        System.out.println("What are your monthly expenses? $");
        String monthlyExpensesStr = scanner.nextLine();
        double monthlyExpenses = Double.parseDouble(monthlyExpensesStr);
        System.out.println("How much do you estimate band startup costs? $");
        String startupCostsStr = scanner.nextLine();
        double startupCosts = Double.parseDouble(startupCostsStr);

        System.out.println("\uD83D\uDCB0 FINANCIAL REPORT \uD83D\uDCB0");
        System.out.println("Monthly surplus: $" + (income - monthlyExpenses));
        System.out.println("Months to save for band: %d months".formatted((int)(startupCosts/(income - monthlyExpenses))));
        System.out.println("Recommendation: You can start %s in %d months \uD83C\uDF89".formatted(bandName, (int)(startupCosts / (income - monthlyExpenses))));
        scanner.close();
    }
    
}
