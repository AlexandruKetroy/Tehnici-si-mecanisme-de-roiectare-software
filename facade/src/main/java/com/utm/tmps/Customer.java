package com.utm.tmps;

public class Customer {

    public static void main(String[] args) {

        BankService bankService = new BankService();

        long fromAccount = bankService.createNewAccount("saving", 1, 500.00);

        long toAccount = bankService.createNewAccount("investment", 2, 1000.00);

        bankService.transferMooney(toAccount,fromAccount,200);
    }

}
