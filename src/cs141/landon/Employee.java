/*
Programmer Name: Landon Davidson
Section:
Program Name: RunCompany

Description: This class creates an Employee object, with the variables ID, name, gender,
jobTitle, employer, and birthday based off user inputs. It also has a printEmployee
method, which prints all of its stored variables to the terminal
*/

package cs141.landon;

import java.util.Random;
import java.util.Scanner;

public class Employee {
    private static final Random rand = new Random();
    private static final Scanner input = new Scanner(System.in);
    private final int ID = rand.nextInt(1000);
    private final String name;
    private final String gender;
    private final String jobTitle;
    private final String employer;
    private final String birthday;
    public Employee(int count, String employer) {
        this.employer = employer;
        System.out.print("Enter " + employer + " Employee " + count + "'s name: ");
        name = input.next();
        System.out.print("Enter " + employer + " Employee " + count + "'s gender: ");
        gender = input.next();
        System.out.print("Enter " + employer + " Employee " + count + "'s job title: ");
        jobTitle = input.next();
        System.out.print("Enter " + employer + " Employee " + count + "'s birthday (MM/DD/YYYY): ");
        birthday = input.next();
        System.out.println("\n---------------------");
    }
    public void printEmployee() {
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Employer: " + employer);
        System.out.println("Birthday: " + birthday);
        System.out.println("---------------------");
    }
}

