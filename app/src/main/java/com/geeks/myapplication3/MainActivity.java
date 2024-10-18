package com.geeks.myapplication3;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Double firstValue, secondValue, result;
    private Boolean isOperationClick;
    private String operator;
    private Boolean clickedPerc = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
    }


    public void onNumberClick(View view) {
        clickedPerc = false;
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
            firstValue = 0.0;
            secondValue = 0.0;
        } else if (text.equals(".")) {
            textView.append(text);
        } else if (text.equals("+/-")) {
            displayResult(Double.valueOf(textView.getText().toString()) * -1);
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        String textButton = ((Button) view).getText().toString();
        switch (textButton) {
            case "+":
                firstValue = Double.valueOf(textView.getText().toString());
                operator = "+";
                break;
            case "-":
                firstValue = Double.valueOf(textView.getText().toString());
                operator = "-";
                break;
            case "x":
                firstValue = Double.valueOf(textView.getText().toString());
                operator = "x";
                break;
            case "/":
                firstValue = Double.valueOf(textView.getText().toString());
                operator = "/";
                break;
            case "%":
                clickedPerc = true;
                break;
            case "=":
                secondValue = Double.valueOf(textView.getText().toString());
                switch (operator) {
                    case "+":
                        if (clickedPerc) {
                            secondValue = firstValue / 100 * secondValue;
                        }
                        result = firstValue + secondValue;
                        displayResult(result);
                        break;
                    case "-":
                        if (clickedPerc) {
                            secondValue = firstValue / 100 * secondValue;
                        }
                        result = firstValue - secondValue;
                        Log.e("ololo", "onOperationClick: = " + firstValue + " " + secondValue);
                        displayResult(result);
                        break;
                    case "x":
                        if (clickedPerc) {
                            secondValue = secondValue / 100;
                        }
                        result = firstValue * secondValue;
                        displayResult(result);
                        break;
                    case "/":
                        if (clickedPerc) {
                            secondValue = secondValue / 100;
                        }
                        if (secondValue != 0) {
                            result = firstValue / secondValue;
                            displayResult(result);
                        } else {
                            textView.setText("На ноль делить нельзя");
                        }
                        break;
                }
                break;
        }
        isOperationClick = true;

    }

    private void displayResult(double result) {
        if (result == (int) result) {
            textView.setText(String.valueOf((int) result));
        } else {
            textView.setText(String.valueOf(result));
        }
    }
}
