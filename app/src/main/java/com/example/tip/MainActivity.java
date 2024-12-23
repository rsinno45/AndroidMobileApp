package com.example.tip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button buttonAdd, buttonSub;
    TextView TotAns, TipAns;
    EditText editTextPer, editTextBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);

        TotAns = findViewById(R.id.TotAns);
        TipAns = findViewById(R.id.TipAns);

        editTextPer = findViewById(R.id.editTextPer);
        editTextBill = findViewById(R.id.editTextBill);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = editTextPer.getText().toString();
                int value = Integer.parseInt(currentValue);
                value++;
                editTextPer.setText(String.valueOf(value));
                calculate();
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String currentValue = editTextPer.getText().toString();
                int value = Integer.parseInt(currentValue);
                value--;
                editTextPer.setText(String.valueOf(value));
                calculate();
            }
        });

    }
    private void calculate() {
        double billValue = Double.parseDouble(editTextBill.getText().toString());
        double tipPerc = Double.parseDouble(editTextPer.getText().toString());
        double tipValue = billValue*tipPerc/100;
        double finalValue = billValue + tipValue;
        TipAns.setText(String.valueOf(tipValue));
        TotAns.setText(String.valueOf(finalValue));

    }

}