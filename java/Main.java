import java.util.Scanner;

class Employee {
    int empNo;
    String empName;
    char desigCode;
    double basic;
    double hra;
    double it;

    public Employee(int empNo, String empName, char desigCode, double basic, double hra, double it) {
        this.empNo = empNo;
        this.empName = empName;
        this.desigCode = desigCode;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }

    public double calculateSalary() {
        double da;
        switch (desigCode) {
            case 'e':
                da = 20000;
                break;
            case 'c':
                da = 32000;
                break;
            case 'k':
                da = 12000;
                break;
            case 'r':
                da = 15000;
                break;
            case 'm':
                da = 40000;
                break;
            default:
                da = 0;
                break;
        }
        return basic + hra + da - it;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Employee details
        System.out.println("Enter employee details:");
        System.out.print("Employee Number: ");
        int empNo = scanner.nextInt();
        System.out.print("Employee Name: ");
        String empName = scanner.next();
        System.out.print("Designation Code: ");
        char desigCode = scanner.next().charAt(0);
        System.out.print("Basic Salary: ");
        double basic = scanner.nextDouble();
        System.out.print("HRA: ");
        double hra = scanner.nextDouble();
        System.out.print("IT: ");
        double it = scanner.nextDouble();

        // Create employee object
        Employee employee = new Employee(empNo, empName, desigCode, basic, hra, it);

        // Calculate and print salary
        double salary = employee.calculateSalary();
        System.out.println("Salary of " + empName + " is: " + salary);

        scanner.close();
    }
}
