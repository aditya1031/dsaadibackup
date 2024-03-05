import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Employee {
    int empNo;
    String empName;
    Date joinDate;
    char desigCode;
    String department;
    double basic;
    double hra;
    double it;

    public Employee(int empNo, String empName, String joinDate, char desigCode, String department, double basic, double hra, double it) {
        this.empNo = empNo;
        this.empName = empName;
        try {
            this.joinDate = new SimpleDateFormat("dd/MM/yyyy").parse(joinDate);
        } catch (ParseException e) {
            System.out.println("Error parsing date for employee " + empNo + ". Using current date instead.");
            this.joinDate = new Date(); // Using current date as default
        }
        this.desigCode = desigCode;
        this.department = department;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }

    public double calculateSalary() {
        double da = getDA();
        return basic + hra + da - it;
    }

    public String getDesignation() {
        switch (desigCode) {
            case 'e':
                return "Engineer";
            case 'c':
                return "Consultant";
            case 'k':
                return "Clerk";
            case 'r':
                return "Receptionist";
            case 'm':
                return "Manager";
            default:
                return "Unknown";
        }
    }

    private double getDA() {
        switch (desigCode) {
            case 'e':
                return 20000;
            case 'c':
                return 32000;
            case 'k':
                return 12000;
            case 'r':
                return 15000;
            case 'm':
                return 40000;
            default:
                return 0;
        }
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[7];

        employees[0] = new Employee(1001, "Ashish", "01/04/2009", 'e', "R&D", 20000, 8000, 3000);
        employees[1] = new Employee(1002, "Shashi", "23/08/2012", 'c', "PM", 30000, 12000, 9000);
        employees[2] = new Employee(1003, "Rahul", "12/11/2008", 'k', "Acct", 10000, 8000, 1000);
        employees[3] = new Employee(1004, "Chahat", "29/01/2013", 'r', "Front Desk", 12000, 6000, 2000);
        employees[4] = new Employee(1005, "Ranjan", "16/07/2005", 'm', "Engg", 50000, 20000, 20000);
        employees[5] = new Employee(1006, "Suman", "01/01/2000", 'e', "Manufacturing", 23000, 9000, 4400);
        employees[6] = new Employee(1007, "Tanmay", "12/06/2006", 'c', "PM", 29000, 12000, 10000);

        // Display employee information
        System.out.println("Employee Information:");
        System.out.println("Emp No.\tEmp Name\tJoin Date\tDesignation\tDepartment\tSalary");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        for (Employee employee : employees) {
            System.out.printf("%d\t%s\t%s\t%s\t%s\t%.2f%n",
                    employee.empNo,
                    employee.empName,
                    dateFormat.format(employee.joinDate),
                    employee.getDesignation(),
                    employee.department,
                    employee.calculateSalary());
        }
    }
}
