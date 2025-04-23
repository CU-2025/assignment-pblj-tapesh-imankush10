class Account {
    double amount;
    String accountType;
    int age;

    public Account(double amount, String accountType, int age) {
        this.amount = amount;
        this.accountType = accountType;
        this.age = age;
    }

    public double calculateInterest() {
        return 0;
    }
}

class FDAccount extends Account {
    int days;

    public FDAccount(double amount, String accountType, int age, int days) {
        super(amount, accountType, age);
        this.days = days;
    }

    @Override
    public double calculateInterest() {
        double rate = determineInterestRate();
        return (amount * rate * days) / 365;
    }

    private double determineInterestRate() {
        double rate = 0.0;
        if ("Senior".equals(accountType) && age >= 60) {
            rate += 0.5;
        }
        if (amount > 1_00_00_000) {
            rate += 1.0;
        } else {
            rate += 0.5;
        }
        return rate;
    }
}

class RDAccount extends Account {
    int months;

    public RDAccount(double amount, String accountType, int age, int months) {
        super(amount, accountType, age);
        this.months = months;
    }

    @Override
    public double calculateInterest() {
        double rate = determineInterestRate();
        return (amount * rate * months) / 12;
    }

    private double determineInterestRate() {
        double rate = 0.0;
        if ("Senior".equals(accountType) && age >= 60) {
            rate += 0.5;
        }
        if (amount > 1_00_00_000) {
            rate += 1.0;
        } else {
            rate += 0.5;
        }
        return rate;
    }
}

public class Exp3 {
    public static void main(String[] args) {
        Account fd = new FDAccount(3_00_000, "Senior", 65, 365);
        Account rd = new RDAccount(50_000, "General", 40, 12);

        System.out.println("FD Account Interest: " + fd.calculateInterest());
        System.out.println("RD Account Interest: " + rd.calculateInterest());
    }
}
