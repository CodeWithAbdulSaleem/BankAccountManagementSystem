import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        BankService bank = new BankService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bank Account Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Transfer Money");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter account holder name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter initial balance: ");
                    double balance = sc.nextDouble();
                    bank.createAccount(name, balance);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depAcc = sc.nextInt();
                    System.out.print("Enter deposit amount: ");
                    double depAmt = sc.nextDouble();
                    Account depAccount = bank.getAccount(depAcc);
                    if (depAccount != null)
                        depAccount.deposit(depAmt);
                    else
                        System.out.println("Account not found.");
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int withAcc = sc.nextInt();
                    System.out.print("Enter withdrawal amount: ");
                    double withAmt = sc.nextDouble();
                    Account withAccount = bank.getAccount(withAcc);
                    if (withAccount != null)
                        withAccount.withdraw(withAmt);
                    else
                        System.out.println("Account not found.");
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    int balAcc = sc.nextInt();
                    Account balAccount = bank.getAccount(balAcc);
                    if (balAccount != null)
                        System.out.println("Current Balance: " + balAccount.getBalance());
                    else
                        System.out.println("Account not found.");
                    break;

                case 5:
                    System.out.print("Enter sender account number: ");
                    int from = sc.nextInt();
                    System.out.print("Enter receiver account number: ");
                    int to = sc.nextInt();
                    System.out.print("Enter transfer amount: ");
                    double amt = sc.nextDouble();
                    bank.transfer(from, to, amt);
                    break;

                case 6:
                    System.out.println("Thank you for using the system.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
