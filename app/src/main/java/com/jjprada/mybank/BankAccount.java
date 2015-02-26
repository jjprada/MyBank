package com.jjprada.mybank;

import java.util.ArrayList;

/**
 * Created by Dr4ckO on 23/02/2015.
 */
public class BankAccount {
    private static final String TAG = "BankAccount";

    private ArrayList<Double> mTransactions;
    private double mBalance;
    public static double OVERDRAFT_FEE = 30;

    public enum Type{
        CHECKING, SAVINGS;
    }

    private Type mType;

    BankAccount(Type accountType){
        mTransactions = new ArrayList<Double>();
        mType = accountType;
    }

    public void deposit (double amount){
        mTransactions.add(amount);
    }

    public void withdraw (double amount) {
        if (mType == Type.SAVINGS){
            if(numberOfWithdraws() >= 3){       // El banco solo permite retirar dinero 3 veces
                return;
            }
        }

        mTransactions.add(-amount);

        if (getBalance() < 0) {
            mTransactions.add(-OVERDRAFT_FEE);
        }
    }

    // Comprueba cuantas veces se ha retirado dinero
    private int numberOfWithdraws(){
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
