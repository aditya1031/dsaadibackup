import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private String name;
    private int id;
    private int age;
    private double salary;

    public Employee(String name, int id, int age, double salary) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    private int nextId = 1;

    public void addEmployee(String name, int age, double salary) {
        employees.add(new Employee(name, nextId++, age, salary));
        System.out.println("Employee added successfully.");
    }

    public void displayAllEmployees() {
        System.out.println("Employee List:");
        for (Employee emp : employees) {
            System.out.println("ID: " + emp.getId() + ", Name: " + emp.getName() + ", Age: " + emp.getAge()
                    + ", Salary: ₹" + emp.getSalary());
        }
    }

    public void deleteEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee deleted successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }

    public void editEmployee(int id, String name, int age, double salary) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(name);
                emp.setAge(age);
                emp.setSalary(salary);
                System.out.println("Employee details updated successfully.");
                return;
            }
        }
        System.out.println("Employee not found.");
    }
}

public class Emp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        while (true) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Delete Employee");
            System.out.println("4. Edit Employee Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter employee age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    ems.addEmployee(name, age, salary);
                    break;
                case 2:
                    ems.displayAllEmployees();
                    break;
                case 3:
                    System.out.print("Enter employee ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    ems.deleteEmployee(idToDelete);
                    break;
                case 4:
                    System.out.print("Enter employee ID to edit: ");
                    int idToEdit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    ems.editEmployee(idToEdit, newName, newAge, newSalary);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}
