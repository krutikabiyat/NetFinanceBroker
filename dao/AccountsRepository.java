package dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import domain.Account;
import domain.Authentication;

/**
 * @author Krutika Mohanty
 * Data store for NetFin
 */
public class AccountsRepository {
    ArrayList<Account> accounts=new ArrayList<Account>();
    /**
     * Load data
     */
    public void initialize(){
        Account account = null;
        account = new Account("111111"," Mark Peter");
        Map<String, Authentication> map = new HashMap<String, Authentication>();
        map.put("111111", new Authentication("mark","mark123"));
        account.setAuthentication(map);
        accounts.add(account);
        account = new Account("222222","John Doss");
        map = new HashMap<String, Authentication>();
        map.put("222222", new Authentication("john","john123"));
        account.setAuthentication(map);
        accounts.add(account);
        account = new Account("333333","Jill Knepp");
        map = new HashMap<String, Authentication>();
        map.put("333333", new Authentication("jill","jill123"));
        account.setAuthentication(map);
        accounts.add(account);
    }

    /**
     * Customer Service: Login by Account
     * @param accountNumber
     * @return
     */
    public Account validateAccount(String accountNumber){
        Account validAccount = null;
        for(Account account:accounts){
            if(account.getAccountNumber().equals(accountNumber)){
                validAccount = account;
            }
        }
        return validAccount;
    }

    /**
     * User: Login by account number, user and password.
     * @param accountNumber
     * @param userName
     * @param password
     * @return
     */
    public Account validateAccount(String accountNumber, String userName, String password){
        Account validAccount = null;
        for(Account account:accounts){
            if(account.getAccountNumber().equals(accountNumber)
            && account.getAuthentication().get(accountNumber).match(userName, password)
            ){
                validAccount = account;
            }
        }
        return validAccount;
    }

    /**
     * Main method for standalone testing.
     * @param args
     */
    public static void main(String[] args) {
        AccountsRepository repository = new AccountsRepository();
        repository.initialize();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Account Number: ");
        String accountNumber = scanner.next();
        if(repository.validateAccount(accountNumber)!=null)
            System.out.println("Valid Account");
        else
            System.out.println("Invalid Account");

        scanner.close();
    }
}
