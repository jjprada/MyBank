package com.jjprada.mybank;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";

    EditText mAmountInput;
    Button mWithdrawButton;
    Button mDepositButton;
    TextView mBalanceDisplay;
    BankAccount mCurrentAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Hello");
        arrayList.add("World");

        Log.d(TAG, "Position 0 is " + arrayList.get(0));
        Log.d(TAG, "Size is " + arrayList.size());

        for (int i = 0; i < 3; i++){
            Log.d(TAG, "i is " + i);
        }

        for (int i = 0; i < arrayList.size(); i++){
            Log.d(TAG, "Position " + i + " is " + arrayList.get(i));
        }

        mCurrentAccount = new BankAccount(BankAccount.Type.SAVINGS);

        mAmountInput = (EditText)(findViewById(R.id.amount_input));
        mWithdrawButton = (Button)(findViewById(R.id.withdraw_button));
        mDepositButton = (Button)(findViewById(R.id.deposit_button));
        mBalanceDisplay = (TextView)(findViewById(R.id.balance_display));

        mWithdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = mAmountInput.getText().toString();
                mCurrentAccount.withdraw(Double.parseDouble(amount));
                mBalanceDisplay.setText("Balance is " + mCurrentAccount.getBalance());
            }
        });

        mDepositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = mAmountInput.getText().toString();
                mCurrentAccount.deposit(Double.parseDouble(amount));
                mBalanceDisplay.setText("Balance is " + mCurrentAccount.getBalance());
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
