package com.jjprada.mybank;

import android.util.Log;

/**
 * Created by Dr4ckO on 26/02/2015.
 */
public class SavingsAccount extends BankAccount {
    private static final String TAG = "SavingsAccount";

    @Override
    public void withdraw(double amount) {
        if (numberOfWithdrawals() >= 3){
            return;
        }

        super.withdraw(amount);

        Log.d(TAG, "Withdraw from savings");
    }
}
