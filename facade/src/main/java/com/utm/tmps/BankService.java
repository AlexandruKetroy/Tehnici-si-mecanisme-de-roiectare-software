package com.utm.tmps;

import java.util.HashMap;
import java.util.Objects;

public class BankService {

    private HashMap<Long, Account> bankAccounts;

    public BankService() {
        this.bankAccounts = new HashMap<>();
    }

    public long createNewAccount(String type, long id, double balance) {
        Account newAccount = null;
        switch (type) {
            case "chequing":
                newAccount = new Chequing(id,balance);
                break;
            case "saving":
                newAccount = new Saving(id,balance);
                break;
            case "investment":
                newAccount = new Investment(id,balance);
                break;
            default:
                System.out.println("Invalid account type");
                break;
        }
        if(Objects.nonNull(newAccount)) {
            this.bankAccounts.put(newAccount.getAccountId(), newAccount);
            return newAccount.getAccountId();
        }
        throw new InvalidAccountException("Invalid Account Id");
    }

    public void transferMooney(long to, long from, double amount) {
        Account toAccount = this.bankAccounts.get(to);
        Account fromAccount = this.bankAccounts.get(from);
        fromAccount.transfer(toAccount,amount);
        System.out.println("From account balance: " + fromAccount.balance());
        System.out.println("To account balance: " + toAccount.balance());
    }
}
