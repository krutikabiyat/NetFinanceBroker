
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

import dao.AccountsRepository;
import domain.Account;
import operations.NetFinOperations;

/**
 * @author Krutika Mohanty
 * Dashboard module for NetFin, user is provided with multiple options.
 */
public class Dashboard {
    public static void main(String[] args) {
        /**
         * Preload data.
         */
        AccountsRepository repository = new AccountsRepository();
        repository.initialize();

        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        /**
         * Print Banner
         */
        try (BufferedReader br = new BufferedReader(new FileReader("resources/banner.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * Welcome Message
         */
        System.out.println("Welcome to NetFin Banking.");
        boolean exitFlag = false;
        int counter = 0;
        /**
         * Authentication
         */
        do {
            System.out.println("Please enter your account number: ");
            String accountNumber = scanner.next();
            System.out.println("Please enter your user name: ");
            String userName = scanner.next();
            System.out.println("Please enter your password: ");
            String password = scanner.next();
            Account account = repository.validateAccount(accountNumber, userName, password);
            
            if (account != null) {
                /**
                 * This is a valid user.
                 */
                NetFinOperations operation = new NetFinOperations();
                System.out.println("Welcome " + account.getCustomerName() + "!");
                System.out.println("A. Check Balance");
                System.out.println("B. Deposit");
                System.out.println("C. Withdraw");
                System.out.println("D. Previous Transaction");
                System.out.println("E. Exit");
                do {
                    /**
                     * User will enter once and will continue until chooses to logout.
                     */
                    System.out.println("Choose trasaction type, enter A, B, C, D or E ");
                    option = scanner.next().charAt(0);
                    System.out.println("\n");

                    switch (option) {
                        /**
                         * Balance View
                         */
                        case 'A':
                            System.out.println("Balance: $" + account.getBalance());
                            System.out.println("\n");
                            break;
                        /**
                         * Deposit module
                         */
                        case 'B':
                            System.out.println("Enter amount to deposit ");
                            int depositAmount = scanner.nextInt();
                            operation.deposit(account, depositAmount);
                            System.out.println("Successfully deposited $" + depositAmount);
                            break;
                        /**
                         * Withdraw module
                         */
                        case 'C':
                            System.out.println("Enter amount to withdraw ");
                            int withdrawAmount = scanner.nextInt();
                            operation.withdraw(account, withdrawAmount);
                            System.out.println("Successfully deposited $" + withdrawAmount);
                            break;
                        case 'D':
                        /**
                         * View Last few transactions
                         */
                            System.out
                                    .println("Previous transaction amount: $" + account.getPreviousTransactionAmount());
                            System.out.println("\n");
                            break;
                        /**
                         * Exit
                         */
                        case 'E':
                            System.out.println("Thank you for using our service, exiting...");
                            System.out.println("\n");
                            exitFlag = true;
                            break;
                    }
                } while (!exitFlag);

            } else {
                /**
                 * User has failed to authenticate, give few more chances before exiting.
                 */
                System.out.println("Invalid Account, try again...");
                counter++;
                if (counter == 3) {
                    exitFlag = true;
                    System.out.println("You have exceeded your limit. Exiting...");
                }
            }

        } while (!exitFlag);
        scanner.close();

    }
}
