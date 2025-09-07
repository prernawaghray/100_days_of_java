package day2;
import java.util.Scanner;

public class TipCalculatorExtended {

    public static void main(String[] args) {
        float bill, tip, tax;
        int people;
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Welcome to the Tip Calculator!");
            System.out.println("Enter your bill amount in $");
            String billStr = scanner.nextLine();
            bill = Float.parseFloat(billStr);
            System.out.println("Enter the number of people paying the bill:");
            String peopleStr = scanner.nextLine();
            people = Integer.parseInt(peopleStr);
            System.out.println("Enter the tax percentage (0 if no tax):");
            String taxStr = scanner.nextLine();
            tax = Float.parseFloat(taxStr);
        } catch (Exception e) {
            System.out.println("Enter valid values." + e.getMessage());
            scanner.close();
            return;
        }
        float taxAmount = bill * (tax / 100.0f);
        float tipAmount15 = bill * 0.15f;
        float tipAmount18 = bill * 0.18f;
        float tipAmount20 = bill * 0.20f;
        float totalBill15 = bill + tipAmount15 + taxAmount;
        float totalBill18 = bill + tipAmount18 + taxAmount;
        float totalBill20 = bill + tipAmount20 + taxAmount;
        float billPerPerson15 = totalBill15 / people;
        float billPerPerson18 = totalBill18 / people;
        float billPerPerson20 = totalBill20 / people;

        System.out.println("🧾 TIP OPTIONS:");
        System.out.println("----------------------------------------");
        System.out.println("                15%      18%      20%");
        System.out.println("Tip Amount:    $%.2f\t$%.2f\t$%.2f".formatted(tipAmount15, tipAmount18, tipAmount20));
        System.out.println("Total + Tax:   $%.2f\t$%.2f\t$%.2f".formatted(totalBill15, totalBill18, totalBill20));
        System.out.println("Per Person:    $%.2f\t$%.2f\t$%.2f".formatted(billPerPerson15, billPerPerson18, billPerPerson20));
        System.out.println("----------------------------------------");

        try{
            System.out.println("Which tip percentage would you like? (15%, 18%, 20%, or custom): [Only mention numbers]");
            String tipStr = scanner.nextLine();
            tip = Float.parseFloat(tipStr);
        } catch (Exception e) {
            System.out.println("Enter valid values." + e.getMessage());
            scanner.close();
            return;
        }
        //calculations 
        float tipAmount = bill * tip / 100.0f;
        float totalBill = bill + taxAmount + tipAmount;
        float billPerPerson = totalBill / people;

        System.out.println("📊 FINAL BILL BREAKDOWN:");
        System.out.println("=========================");
        System.out.println("Original Bill:\t$%.2f".formatted(bill));
        System.out.println("Tax (%.2f%%):\t$%.2f".formatted(tax, taxAmount));
        System.out.println("Subtotal:\t$%.2f".formatted(bill + taxAmount));
        System.out.println("Tip (%.2f%%):\t$%.2f".formatted(tip, tipAmount));
        System.out.println("------------------------");
        System.out.println("TOTAL:\t\t$%.2f".formatted(totalBill));
        System.out.println("Per Person:\t$%.2f".formatted(billPerPerson));
        System.out.println("=========================");
        scanner.close();
    }
}
