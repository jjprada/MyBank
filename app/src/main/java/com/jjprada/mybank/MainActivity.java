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


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "MainActivity";
    EditText amountInput;
    Button withdrawButton;
    Button depositButton;
    TextView balanceDisplay;
    BankAccount currentAccount;
    BankAccount currentAccount2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentAccount = new BankAccount();
        currentAccount2 = new BankAccount();

        Log.d("MainActivity", "1 BankAccount: Overdraft Fee is " + BankAccount.overdraftFee);
        Log.d("MainActivity", "1 CurrentAccount1: Overdraft Fee is " + currentAccount.overdraftFee);
        Log.d("MainActivity", "1 CurrentAccount1: Overdraft Fee is " + currentAccount2.overdraftFee);

        BankAccount.overdraftFee = 45;
        Log.d("MainActivity", "2 BankAccount: Overdraft Fee is " + BankAccount.overdraftFee);
        Log.d("MainActivity", "2 CurrentAccount1: Overdraft Fee is " + currentAccount.overdraftFee);
        Log.d("MainActivity", "2 CurrentAccount1: Overdraft Fee is " + currentAccount2.overdraftFee);

        currentAccount.overdraftFee = 60;
        Log.d("MainActivity", "3 BankAccount: Overdraft Fee is " + BankAccount.overdraftFee);
        Log.d("MainActivity", "3 CurrentAccount1: Overdraft Fee is " + currentAccount.overdraftFee);
        Log.d("MainActivity", "3 CurrentAccount1: Overdraft Fee is " + currentAccount2.overdraftFee);

        amountInput = (EditText)(findViewById(R.id.amount_input));
        withdrawButton = (Button)(findViewById(R.id.withdraw_button));
        depositButton = (Button)(findViewById(R.id.deposit_button));
        balanceDisplay = (TextView)(findViewById(R.id.balance_display));

        withdrawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = amountInput.getText().toString();
                currentAccount.withdraw(Double.parseDouble(amount));
                balanceDisplay.setText("Balance is " + currentAccount.getBalance());
            }
        });

        depositButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = amountInput.getText().toString();
                currentAccount.deposit(Double.parseDouble(amount));
                balanceDisplay.setText("Balance is " + currentAccount.getBalance());
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
