package com.jjprada.mybank;

/**
 * Created by Dr4ckO on 23/02/2015.
 */
public class BankAccount {
    private double balance;
    public static double overdraftFee = 30;

    public void withdraw (double amount){
        balance -= amount;
    }

    public void deposit (double amount){
        balance += amount;
    }

    public double getBalance(){
        return balance;
    }
}
