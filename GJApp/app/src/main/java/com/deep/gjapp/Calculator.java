package com.deep.gjapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class Calculator extends AppCompatActivity {
    boolean isNewOperator = true;
    EditText edt1;
    String operator = "+";
    String initialNumber = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_calculator);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        edt1 = findViewById(R.id.editText);
    }


    public void numberEvent(View view) {

        if(isNewOperator)
            edt1.setText("");
        isNewOperator = false;

        String number = edt1.getText().toString();

        if(view.getId() == R.id.btnOne){
            number += "1";
        }
        else if(view.getId() == R.id.btnTwo){
            number += "2";
        }
        else if(view.getId() == R.id.btnThree){
            number += "3";
        }
        else if(view.getId() == R.id.btnFour){
            number += "4";
        }
        else if(view.getId() == R.id.btnFive){
            number += "5";
        }
        else if(view.getId() == R.id.btnSix){
            number += "6";
        }
        else if(view.getId() == R.id.btnSeven){
            number += "7";
        }
        else if(view.getId() == R.id.btnEight){
            number += "8";
        }
        else if(view.getId() == R.id.btnNine){
            number += "9";
        }
        else if(view.getId() == R.id.btnZero){
            number += "0";
        }

        else if(view.getId() == R.id.btnDot){
            number += ".";
        }

        edt1.setText(number);

    }

    public void operatorEvent(View view) {

        isNewOperator =true;
        initialNumber = edt1.getText().toString();

        if(view.getId() == R.id.btnMultiply){
            operator = "*";}

        else if(view.getId() == R.id.btnMinus){
            operator = "-";}

        else if(view.getId() == R.id.btnDivide){
            operator = "/";}

        else if(view.getId() == R.id.btnPlus){
            operator = "+";
        }


    }

    public void equalEvent(View view) {
        String newNumber = edt1.getText().toString();
        double output = 0.0;

        if(operator == "+")
            output = Double.parseDouble(initialNumber) + Double.parseDouble(newNumber);

        if(operator == "/")
            output = Double.parseDouble(initialNumber) / Double.parseDouble(newNumber);

        if(operator == "*")
            output = Double.parseDouble(initialNumber) * Double.parseDouble(newNumber);

        if(operator == "-")
            output = Double.parseDouble(initialNumber) - Double.parseDouble(newNumber);

        edt1.setText(output+"");

    }


    public void clearEvent(View view) {
        edt1.setText("0");
        isNewOperator = true;
    }

    public void percentEvent(View view) {
        double num = Double.parseDouble(edt1.getText().toString())/100;
        edt1.setText(num+"");
        isNewOperator = true;

    }
}