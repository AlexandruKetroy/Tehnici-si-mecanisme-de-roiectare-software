package com.utm.tmps;

public interface Account {
    void deposit(double amount);

    void withdraw(double amount);

    void transfer(Account account,double amount);

    long getAccountId();

    double balance();
}
