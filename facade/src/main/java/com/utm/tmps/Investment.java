package com.utm.tmps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Investment implements Account {
    private long id;
    private double balance;

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

    @Override
    public double balance() {
        return balance;
    }
}
