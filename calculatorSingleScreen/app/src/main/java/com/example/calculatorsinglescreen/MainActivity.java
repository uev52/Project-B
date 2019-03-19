package com.example.calculatorsinglescreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView answer;
    public EditText txtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        answer = (TextView)findViewById(R.id.txtAnswer);
        txtInput = (EditText) findViewById(R.id.txtInput);




    }

    public void addNum(View v){
        // if Input is empty stop.
        if (txtInput.getText().toString().trim().isEmpty()) return;

        double num1 = Double.parseDouble(answer.getText().toString());
        double num2 = Double.parseDouble(txtInput.getText().toString());
        answer.setText( Double.toString(num1 + num2));
    }

    public void subNum(View v){
        // if Input is empty stop.
        if (txtInput.getText().toString().trim().isEmpty()) return;

        double num1 = Double.parseDouble(answer.getText().toString());
        double num2 = Double.parseDouble(txtInput.getText().toString());
        answer.setText( Double.toString(num1 - num2));
    }

    public void mulNum(View v){
        // if Input is empty stop.
        if (txtInput.getText().toString().trim().isEmpty()) return;

        double num1 = Double.parseDouble(answer.getText().toString());
        double num2 = Double.parseDouble(txtInput.getText().toString());
        answer.setText( Double.toString(num1 * num2));
    }

    public void divNum(View v){
        // if Input is empty stop.
        if (txtInput.getText().toString().trim().isEmpty()) return;

        double num1 = Double.parseDouble(answer.getText().toString());
        double num2 = Double.parseDouble(txtInput.getText().toString());

        // can't divide by 0
        if (num2 == 0) return;

        answer.setText( Double.toString(num1 / num2));
    }


}
