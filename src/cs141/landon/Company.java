/*
Programmer Name: Landon Davidson
Section:
Program Name: RunCompany

Description: This class creates the object Company, which stores an array of Employee
objects as well as the company name. It takes [company]name and amountOfEmployees as
constructor arguments and creates an array of Employee objects based on amountOfEmployees.
There is also an addEmployee function, which assigns a new array to the employees variable
with all the original employees, plus one new one. Finally, there is a print function
which calls the printEmployee() method for each of the objects in its array.
*/

package cs141.landon;

import java.util.Scanner;

public class Company {
    private static final Scanner input = new Scanner(System.in);
    private Employee[] employees;
    private final String name;
    private int size;
    public Company(String name, int amountOfEmployees) {
        this.name = name;
        size = amountOfEmployees;
        employees = new Employee[size];
        System.out.println();
        for (int i = 0; i < size; i++) {
            employees[i] = new Employee(i + 1, name);
        }
        while (true) {
            System.out.format("Would you like to add another employee to %s (yes or no)? ", name);
            if (input.next().equalsIgnoreCase("yes")) {
                addEmployee();
            } else {
                break;
            }
        }
    }
    public void addEmployee() {
        Employee[] temp = new Employee[++size];
        for (int i = 0; i < employees.length; i++) {
            temp[i] = employees[i];
        }
        temp[temp.length - 1] = new Employee(size, name);
        employees = new Employee[size];
        for (int i = 0; i < size; i++) {
            employees[i] = temp[i];
        }
    }
    public void print() {
        System.out.format("----- Printing all %s Employees -----\n", name);
        System.out.println("Total number of employees: " + size);
        for (Employee employee : employees) {
            System.out.println();
            employee.printEmployee();
        }
    }
}
