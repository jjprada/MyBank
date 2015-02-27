package com.jjprada.accounts;

import java.util.ArrayList;

/**
 * Created by Dr4ckO on 23/02/2015.
 */
public abstract class BankAccount {
    private static final String TAG = "BankAccount";
    private ArrayList<Double> mTransactions;
    public static double OVERDRAFT_FEE = 30;

    protected BankAccount(){
        mTransactions = new ArrayList<Double>();
    }

    public void deposit (double amount){
        mTransactions.add(amount);
    }

    public void withdraw (double amount) {
        mTransactions.add(-amount);

        if (getBalance() < 0) {
            mTransactions.add(-OVERDRAFT_FEE);
        }
    }

    protected int numberOfWithdrawals(){
        int count = 0;
        for (int i = 0; i < mTransactions.size(); i++) {
            if (mTransactions.get(i) < 0){
                count++;
            }
        }
        return count;
    }

    public double getBalance(){
        double total = 0;
        for (int i = 0; i < mTransactions.size(); i++){
            total += mTransactions.get(i);
        }
        return total;
    }
}
