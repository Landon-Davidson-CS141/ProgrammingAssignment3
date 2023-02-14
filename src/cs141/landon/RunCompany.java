/*
Programmer Name: Landon Davidson
Section:
Program Name: RunCompany

Description: This program asks the user how many companies they want to make and stores
it in amountOfCompanies. It then loops amountOfCompanies times, asking the user for
a company name and amount of employees each time, then creating a Company object with the
user provided variables. It then runs the print() method for each Company class
 */

package cs141.landon;

import java.util.Scanner;

public class RunCompany {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter how many companies you want to create: ");
        int amountOfCompanies = input.nextInt();
        System.out.println();
        Company[] companies = new Company[amountOfCompanies];
        String companyName;
        int amountOfEmployees;
        for (int i = 0; i < amountOfCompanies; i++) {
            System.out.format("What is the name of company %d? ", i + 1);
            companyName = input.next();
            System.out.format("How many employees does %s have? ", companyName);
            amountOfEmployees = input.nextInt();
            companies[i] = new Company(companyName, amountOfEmployees);
        }
        System.out.println();
        for (Company company : companies) {
            company.print();
        }
    }
}
