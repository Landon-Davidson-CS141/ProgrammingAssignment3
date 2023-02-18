package cs141.landon;

import java.util.Random;
import java.util.Scanner;

public class Employee {
    private static final Random rand = new Random();
    private final Scanner input;
    private final int ID = rand.nextInt(1000);
    private int count;
    private String name;
    private String gender;
    private String jobTitle;
    private final String employer;
    private String birthday;
    public Employee(Scanner input, String employer, int count) {
        this.input = input;
        this.employer = employer;
        this.count = count;

        System.out.println();
        setName();
        setGender();
        setJobTitle();
        setBirthday();
    }
    public void printEmployee() {
        System.out.println("\n---------------------");
        System.out.println(employer + " Employee number " + count + "'s information:");
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Job Title: " + jobTitle);
        System.out.println("Employer: " + employer);
        System.out.println("Birthday: " + birthday);
        System.out.println("---------------------");
    }
    public String getName() {
        return name;
    }

    public void setName() {
        System.out.print("Enter " + employer + " Employee " + count + "'s name: ");
        name = input.next();
    }

    public String getGender() {
        return gender;
    }

    // To-Do: Add Error detection to setGender()
    public void setGender() {
        while (true) {
            System.out.print("Enter " + employer + " Employee " + count + "'s gender (Male, Female, or Non-binary: ");
            gender = input.next();
            if (gender.equals("Male") || gender.equals("Female") || gender.equals("Non-binary")) {
                return;
            }
            System.out.println("Please enter either Male, Female, or Non-binary");
        }
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle() {
        System.out.print("Enter " + employer + " Employee " + count + "'s job title: ");
        jobTitle = input.next();
    }

    public int getID() {
        return ID;
    }

    public String getBirthday() {
        return birthday;
    }

    // To-Do Add error detection to setBirthday()
    public void setBirthday() {
        do {
            System.out.print("Enter " + employer + " Employee " + count + "'s birthday (MM/DD/YYYY format): ");
            birthday = input.next();
        } while (!askValidBirthday());
    }
    private boolean askValidBirthday() {
        if (birthday.length() != 10) {
            System.out.println("Please enter birthday in MM/DD/YYYY format");
            return false;
        }
        for (int i = 0; i < birthday.length(); i++) {
            if (i == 2 || i == 5) {
                if (birthday.charAt(i) != '/') {
                    System.out.println("Please enter birthday in MM/DD/YYYY format");
                    return false;
                }
            } else {
                if (!Character.isDigit(birthday.charAt(i))) {
                    System.out.println("Please enter birthday in MM/DD/YYYY format");
                    return false;
                }
            }
        }
        return true;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
}
