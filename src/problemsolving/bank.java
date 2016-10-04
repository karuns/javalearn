package problemsolving;

import java.util.HashMap;

/*
Implement a ‘bank’ class. The bank should keep track of the account balances for different accounts designated by numeric identifiers. It should support the following operations: deposit/withdraw to a single account, transfer between two accounts, and calculate the total amount of money in the bank. Opening a new account can be done by depositing or transferring money to an account ID that isn’t previously in the system.  Accounts can not have negative balances. Regulations also state that no account may hold more than $100M.
*/

class bank {
    private static HashMap<Integer, Integer> accounts = new HashMap();
    private final int MAX_LIMIT = 1000000000;
    private final int MIN_LIMIT = 0;
   
    bank () {
    } 
    
    public int deposit (int amount, int accountNum) { 
      if(checkAccountWithinRange(accountNum, amount,1)){
           return addToAccount(accountNum,amount);
      }
	return accountNum;  
    }
    
    public int withdraw(int accountNum, int amount) {
        if(checkAccountWithinRange(accountNum, amount, -1)){
           return withdrawFromAccount(accountNum,amount);
      }
		return amount; 
    }
    
    
    public int totalBankBalance() {
        int temp = 0;
        for(int i = 0 ; i<accounts.size() ; i++) {
            temp+= accounts.get(i); 
        }
        return temp;
    }
    
    public int transfer(int from, int to, int amount) {
        if(accountExist(from)) {
            if(checkAccountWithinRange(from,amount,-1)){
                withdraw(from,amount);
                deposit(to,amount);
            }
        }
        else {
            //print("account doesn't exist");
            return -1;
        }
		return amount;
    }
    
    private boolean checkAccountWithinRange(int accountNum, int amount,int i) {
        int temp;
            
        if(i>0) {
            if(accountExist(accountNum)){
               temp = accounts.get(accountNum)+amount ;
            }
            else {
                temp =0;
            }
        }
        else {
        	if(accountExist(accountNum)){
        		temp = accounts.get(accountNum)-amount ;
            }
            else {
            	temp =0;
            }
        }
        
        if(temp <= MAX_LIMIT  && temp >=MIN_LIMIT) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean accountExist(int accountNum) {
        if(accounts.containsKey(accountNum)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private int addToAccount (int accountNum, int amount){
        if(accountExist(accountNum)){
           accounts.put(accountNum,accounts.get(accountNum)+amount);
        }
        else {
            accounts.put(12345,amount);
        }
        return accounts.get(accountNum);
    }
    
    private int withdrawFromAccount (int accountNum, int amount){
        if(accountExist(accountNum)){
           accounts.put(accountNum, accounts.get(accountNum)-amount);
           return accounts.get(accountNum);
        }
        else {
            System.out.println("trying to withdraw from acount doesn't exist");
            return -1;
        }  
    }
}
