package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

public class MainActivity extends AppCompatActivity {
    public EditText e1, e2, e3;
    TextView t1;
    double num1, num2, num3;


    public boolean getNumbers() {

        //checkAndClear();
        // defining the edit text 1 to e1
        e1 = (EditText) findViewById(R.id.num1);

        // defining the edit text 2 to e2
        e2 = (EditText) findViewById(R.id.num2);

        // defining the edit text 3 to e3
        e3 = (EditText) findViewById(R.id.num3);

        // defining the text view to t1
        t1 = (TextView) findViewById(R.id.result);

        // taking input from text box 1
        String s1 = e1.getText().toString();

        // taking input from text box 2
        String s2 = e2.getText().toString();

        // taking input from text box 3
        String s3 = e3.getText().toString();



        if(s1.equals(null)) {
            String result = "Please enter value 1";
            e1.setText(result);
            return false;
        }
        if(s2.equals(null)) {
            String result = "Please enter value 2";
            e2.setText(result);
            return false;
        }
        if(s3.equals(null)) {
            String result = "Please enter value 3";
            e3.setText(result);
            return false;
        }

        else {
            // converting string to int.
            num1 = Double.parseDouble(s1);

            // converting string to int.
            num2 = Double.parseDouble(s2);

            // converting string to int.
            num3 = Double.parseDouble(s3);
        }

        return true;
    }

    @SuppressLint("SetTextI18n")
    public void doMort(View v) {
        // get the input numbers
        if (getNumbers()) {
            double principal = num1;
            double annualInterestRate = num3 / 100.0; // Convert from percentage to decimal
            double monthlyInterestRate = annualInterestRate / 12.0; // Monthly interest rate
            double numberOfPayments = num2 * 12.0; // Convert years to months

            double monthlyPayment = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)) /
                    (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);

            t1.setText(String.format("$%.2f", monthlyPayment)); // Display the result with two decimal places
        } else {
            t1.setText("Error: Please enter required values.");
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.num1);
        e2 = (EditText) findViewById(R.id.num2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.result) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}