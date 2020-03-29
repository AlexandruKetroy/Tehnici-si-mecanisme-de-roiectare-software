package com.utm.tmps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Documented;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chequing implements Account{
    private long id;

    private double balance;

    @Override
    public double balance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public void transfer(Account account, double amount) {
        withdraw(amount);
        account.deposit(amount);
    }

    @Override
    public long getAccountId() {
        return id;
    }

}
