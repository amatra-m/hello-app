class BankAccount {
    String owner;
    int balance;
    String type;

    public BankAccount(String owner, int balance, String type) {
        this.owner = owner;
        this.balance = balance;
        this.type = type;
    }
}

class AccountSetup {
    BankAccount account;

    public AccountSetup(String owner, int balance, String type) {
        this.account = new BankAccount(owner, balance, type);
    }
}

class AccountViewer {
    BankAccount account;

    public AccountViewer(BankAccount account) {
        this.account = account;
    }

    public void display() {
        System.out.println("Owner: " + account.owner + 
                           ", Balance: " + account.balance + 
                           ", Type: " + account.type);
    }
}

class DepositTracker {
    BankAccount account;

    public DepositTracker(BankAccount account) {
        this.account = account;
    }

    public int getTotalDeposits(int[] deposits) {
        int total = 0;
        for (int i = 0; i < deposits.length; i++) {
            total += deposits[i];
        }
        return total;
    }
}

class OverdraftChecker {
    BankAccount account;

    public OverdraftChecker(BankAccount account) {
        this.account = account;
    }

    public boolean allSufficient(int[] withdrawals, int minBalance) {
        for (int i = 0; i < withdrawals.length; i++) {
            if (withdrawals[i] > minBalance) {
                return false;
            }
        }
        return true;
    }
}

class AccountTypeDesk {
    BankAccount account;

    public AccountTypeDesk(BankAccount account) {
        this.account = account;
    }

    public void checkType(String[] allowedTypes) {
        for (int i = 0; i < allowedTypes.length; i++) {
            if (account.type.equals(allowedTypes[i])) {
                System.out.println("Access granted for " + account.owner);
                return;
            }
        }
        System.out.println("Account type not supported.");
    }
}

class BankSummary {
    BankAccount account;
    int totalDeposits;
    boolean ok;

    public BankSummary(BankAccount account, int totalDeposits, boolean ok) {
        this.account = account;
        this.totalDeposits = totalDeposits;
        this.ok = ok;
    }

    public void printSummary() {
        System.out.println("Owner: " + account.owner);
        System.out.println("Total Deposits: " + totalDeposits);
        System.out.println("All withdrawals sufficient: " + ok);
    }
}

public class Main {
    public static void main(String[] args) {

        int[] deposits = {200, 500, 150};
        String[] allowedTypes = {"Savings", "Fixed"};

        AccountSetup a = new AccountSetup("Alice", 5000, "Savings");

        AccountViewer av = new AccountViewer(a.account);
        av.display();

        DepositTracker dt = new DepositTracker(a.account);
        int total = dt.getTotalDeposits(deposits);

        OverdraftChecker oc = new OverdraftChecker(a.account);
        boolean ok = oc.allSufficient(deposits, 100);

        AccountTypeDesk atd = new AccountTypeDesk(a.account);
        atd.checkType(allowedTypes);

        BankSummary bs = new BankSummary(a.account, total, ok);
        bs.printSummary();
    }
}