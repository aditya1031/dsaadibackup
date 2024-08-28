import java.util.Scanner;

class Deposit {
    double principal;
    double rate;
    double time;

    public Deposit(double principal, double rate, double time) {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    public double calculateInterest() {
        return 0.0;
    }
}






class FixedDeposit extends Deposit {
    public FixedDeposit(double principal, double rate, double time) {
        super(principal, rate, time);
    }

    public double calculateInterest() {
        return (principal * rate * time) / 100;
    }
}





class RecurringDeposit extends Deposit {
    private double monthlyDeposit;

    public RecurringDeposit(double principal, double rate, double time, double monthlyDeposit) {
        super(principal, rate, time);
        this.monthlyDeposit = monthlyDeposit;
    }

    public double calculateInterest() {
        double totalPrincipal = principal + (monthlyDeposit * time);
        return (totalPrincipal * rate * time) / 100;
    }
    
}






public class mst {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the deposit type (1 for Fixed Deposit, 2 for Recurring Deposit): ");
        int depositType = scanner.nextInt();

        double principal, rate, time, monthlyDeposit;
        System.out.println("Enter principal amount: ");
        principal = scanner.nextDouble();
        System.out.println("Enter interest rate: ");
        rate = scanner.nextDouble();
        System.out.println("Enter time period (in years): ");
        time = scanner.nextDouble();



        Deposit deposit;


        switch (depositType) {
            case 1:
                deposit = new FixedDeposit(principal, rate, time);
                break;
            case 2:
                System.out.println("Enter monthly deposit amount for Recurring Deposit: ");
                monthlyDeposit = scanner.nextDouble();
                deposit = new RecurringDeposit(principal, rate, time, monthlyDeposit);
                break;
            default:
                System.out.println("Invalid deposit type.");
                return;
        }



        double interest = deposit.calculateInterest();
        System.out.println("the total Interest is : " + interest);

        scanner.close();
    }
}
