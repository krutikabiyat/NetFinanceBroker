package domain;
import java.util.HashMap;
import java.util.Map;

/**
 * Account PoJo to hold customer and account information.
 */
public class Account {
    private String customerName;
    private String accountNumber;
    private int balance;
    private int previousTransactionAmount;
    Map<String, Authentication> authentication = new HashMap<>();

    public Account(String accountNumber, String customerName){
        this.accountNumber = accountNumber;
        this.customerName = customerName;
    }

    Account(String accountNumber, Map<String, Authentication> authentication){
        this.accountNumber = accountNumber;
        this.authentication = authentication;
    }

    public void getPreviousTransaction(){
        if(this.previousTransactionAmount > 0){
            System.out.println("Deposited "+this.previousTransactionAmount);
        } else if(this.previousTransactionAmount<0){
            System.out.println("Withdrawn "+Math.abs(this.previousTransactionAmount));
        } else{
            System.out.println("No Transaction.");
        }
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int getPreviousTransactionAmount() {
        return previousTransactionAmount;
    }
    public void setPreviousTransactionAmount(int previousTransactionAmount) {
        this.previousTransactionAmount = previousTransactionAmount;
    }
    public Map<String, Authentication> getAuthentication() {
        return authentication;
    }
    public void setAuthentication(Map<String, Authentication> authentication) {
        this.authentication = authentication;
    }
    
    
    
}
