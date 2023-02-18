package cs141.landon;

import java.util.ArrayList;
import java.util.Scanner;

public class Company {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Company company = new Company("Google", input);
        company.addEmployee();
        company.addEmployee();
        company.updateEmployee(1);
        company.printEmployee(1);
        company.removeEmployee(0);
        company.printAllEmployees();
    }
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
        if (employees.size() != 0) {
            employees.remove(index);
            companySize--;
            for (int i = index; i < companySize; i++) {
                Employee temp = employees.get(i);
                temp.setCount(temp.getCount() - 1);
            }
        } else {
            System.out.println("\n" + companyName + " already has zero employees");
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
        System.out.println("1. Name: " + temp.getName());
        System.out.println("2. Gender: " + temp.getGender());
        System.out.println("3. Job Title: " + temp.getJobTitle());
        System.out.println("4. Birthday: " + temp.getBirthday());
        System.out.println("5. Return to menu");
        System.out.print("Which field would you like to edit? ");

        int editAction;
        do {
            editAction = checkValidInput(input, 5);
        } while (editAction == -1);
        switch (editAction) {
            case 1 -> temp.setName();
            case 2 -> temp.setGender();
            case 3 -> temp.setJobTitle();
            case 4 -> temp.setBirthday();
        }
    }
    public static int checkValidInput(Scanner input, int max) {
        int userVal;
        if (input.hasNextInt()) {
            userVal = input.nextInt();
            if (userVal > 0 && userVal <= max) {
                return userVal;
            }
        }
        System.out.println("Please enter a valid choice (between 1 and " + max);
        return -1;
    }
    public String getCompanyName() {
        return companyName;
    }

    public int getCompanySize() {
        return companySize;
    }
}
