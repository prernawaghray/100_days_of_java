package src.day1_5; 
import java.util.Scanner;
import src.day1.BandNameGenerator;

public class BandBudgetCalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to the Band Budget Calculator!");
        BandNameGenerator bandName = new BandNameGenerator();
        Scanner scanner = new Scanner(System.in);
        /*
         * === BAND NAME GENERATION ===
What's your hometown? Seattle
What's your favorite animal? Wolf
🎸 Your band name: "Seattle Wolf" 🎸

=== BUDGET ANALYSIS ===
What's your monthly income? $3500
What are your monthly expenses? $2800
How much do you estimate band startup costs? $5000

💰 FINANCIAL REPORT 💰
Monthly surplus: $700.00
Months to save for band: 8 months
Recommendation: You can start "Seattle Wolf" in 8 months! 🎉
         */
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
        System.out.println("Months to save for band: %d months".formatted(startupCosts/(income - monthlyExpenses)));
        System.out.println("Recommendation: You can start %s in %d months \uD83C\uDF89".formatted(bandName, (int)(startupCosts / (income - monthlyExpenses)));
    }
    
}
