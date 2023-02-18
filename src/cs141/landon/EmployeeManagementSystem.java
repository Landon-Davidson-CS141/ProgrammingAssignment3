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

        int userAction;
        do {
            do {
                System.out.println("\n---------------------");
                System.out.println("1. Add Employee");
                System.out.println("2. Remove Employee");
                System.out.println("3. Update Employee");
                System.out.println("4. Print Number of Employees in Company");
                System.out.println("5. Print Employee Information");
                System.out.println("6. Exit");
                System.out.print("Please enter an option from above: ");

                userAction = Company.checkValidInput(input, 6);
            } while (userAction == -1);

            System.out.println();
            switch (userAction) {
                case 1 -> addEmployee(companies, input);
                case 2 -> removeEmployee(companies, input);
                case 3 -> updateEmployee(companies, input);

            }
        } while (userAction != 6);
    }
    public static void addEmployee(Company[] companies, Scanner input) {
        for (int i = 0; i < companies.length; i++) {
            System.out.println(i + 1 + ". " + companies[i].getCompanyName());
        }

        int userCompany;
        do {
            System.out.print("Which company would you like to add an employee to? ");
            userCompany = Company.checkValidInput(input, companies.length);
        } while (userCompany == -1);
        userCompany--;

        companies[userCompany].addEmployee();
    }
    public static void removeEmployee(Company[] companies, Scanner input) {
        for (int i = 0; i < companies.length; i++) {
            System.out.println(i + 1 + ". " + companies[i].getCompanyName());
        }

        int userCompany;
        do {
            System.out.print("Which company would you like to remove an employee from? ");
            userCompany = Company.checkValidInput(input, companies.length);
        } while (userCompany == -1);
        userCompany--;

        if (companies[userCompany].getCompanySize() == 0) {
            System.out.println("\n" + companies[userCompany].getCompanyName() + " has zero employees");
            return;
        }

        int userEmployee;
        do {
            companies[userCompany].printAllEmployees();
            System.out.print("Which employee would you like to remove? ");
            userEmployee = Company.checkValidInput(input, companies[userCompany].getCompanySize());
        } while (userEmployee == -1);
        userEmployee--;

        companies[userCompany].removeEmployee(userEmployee);
    }
    public static void updateEmployee(Company[] companies, Scanner input) {
        for (int i = 0; i < companies.length; i++) {
            System.out.println(i + 1 + ". " + companies[i].getCompanyName());
        }

        int userCompany;
        do {
            System.out.print("Which company would you like to update an employee from? ");
            userCompany = Company.checkValidInput(input, companies.length);
        } while (userCompany == -1);
        userCompany--;

        if (companies[userCompany].getCompanySize() == 0) {
            System.out.println("\n" + companies[userCompany].getCompanyName() + " has zero employees");
            return;
        }

        int userEmployee;
        do {
            companies[userCompany].printAllEmployees();
            System.out.print("Which employee would you like to update? ");
            userEmployee = Company.checkValidInput(input, companies[userCompany].getCompanySize());
        } while (userEmployee == -1);
        userEmployee--;

        companies[userCompany].updateEmployee(userEmployee);
    }
}
