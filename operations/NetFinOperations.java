package operations;
import domain.Account;

public class NetFinOperations {
    
    

    public void deposit(Account account, int depositAmount){
        if(depositAmount != 0){
            account.setBalance(account.getBalance() + depositAmount);
            account.setPreviousTransactionAmount(depositAmount);
        }
    }
    public void withdraw(Account account, int withdrawAmount){
        if(withdrawAmount != 0){
            account.setBalance(account.getBalance() - withdrawAmount);
            account.setPreviousTransactionAmount(-withdrawAmount);
        }
    }

    
}
