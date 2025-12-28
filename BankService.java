import java.util.HashMap;
import java.util.Map;

public class BankService {

    private Map<Integer, Account> accounts = new HashMap<>();
    private int nextAccountNumber = 1001;

    public void createAccount(String name, double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative.");
            return;
        }
        Account account = new Account(nextAccountNumber, name, initialBalance);
        accounts.put(nextAccountNumber, account);
        System.out.println("Account created successfully.");
        System.out.println("Your Account Number: " + nextAccountNumber);
        nextAccountNumber++;
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void transfer(int fromAcc, int toAcc, double amount) {
        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number.");
            return;
        }

        if (sender.withdraw(amount)) {
            receiver.deposit(amount);
            System.out.println("Transfer successful.");
        }
    }
}
