package cs141.landon;

import java.util.Scanner;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int numCompanies = 0;
        do {
            System.out.print("How many companies would you like to create? ");
            if (input.hasNextInt()) {
                numCompanies = input.nextInt();
            } else {
                System.out.println("Please enter an integer higher than 0");
            }
        } while (numCompanies < 1);

        System.out.println();
        Company[] companies = new Company[numCompanies];
        for (int i = 0; i < numCompanies; i++) {
            System.out.print("Enter the name of company " + (i + 1) + ": ");
            companies[i] = new Company(input.next(), input);
        }
    }
}
