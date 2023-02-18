package cs141.landon;

import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    private final ArrayList<Employee> employees = new ArrayList<>();
    private final Scanner input;
    private final String companyName;
    private int companySize = 0;
    public Company(String companyName, Scanner input) {
        this.companyName = companyName;
        this.input = input;
    }
    public void addEmployee() {
        employees.add(new Employee(input, companyName, ++companySize));
        System.out.println();
    }
    public void removeEmployee(int index) {
        employees.remove(index);
        companySize--;
        for (int i = index; i < companySize; i++) {
            Employee temp = employees.get(i);
            temp.setCount(temp.getCount() - 1);
        }
    }
    public void printEmployee(int index) {
        employees.get(index).printEmployee();
    }
    public void printAllEmployees() {
        System.out.println("\nAll Employees in " + companyName + ":");
        for (Employee employee : employees) {
            employee.printEmployee();
        }
    }
    public void updateEmployee(int index) {
        Employee temp = employees.get(index);

        int editAction;
        do {
            System.out.println("\n1. Name: " + temp.getName());
            System.out.println("2. Gender: " + temp.getGender());
            System.out.println("3. Job Title: " + temp.getJobTitle());
            System.out.println("4. Birthday: " + temp.getBirthday());
            System.out.println("5. Return to menu");
            System.out.print("Which field would you like to edit? ");
            editAction = checkValidInput(input, 5);
        } while (editAction == -1);
        switch (editAction) {
            case 1 -> temp.setName();
            case 2 -> temp.setGender();
            case 3 -> temp.setJobTitle();
            case 4 -> temp.setBirthday();
        }

        printEmployee(index);
    }
    public static int checkValidInput(Scanner input, int max) {
        int userVal;
        if (input.hasNextInt()) {
            userVal = input.nextInt();
            if (userVal > 0 && userVal <= max) {
                return userVal;
            }
        } else {
            input.next();
        }
        System.out.println("Please enter a valid choice (between 1 and " + max + ")");
        return -1;
    }
    public String getCompanyName() {
        return companyName;
    }

    public int getCompanySize() {
        return companySize;
    }
}
