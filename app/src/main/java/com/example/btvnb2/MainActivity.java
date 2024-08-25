package com.example.btvnb2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


        private EditText etNumber1, etNumber2;
        private TextView tvResult;
        private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnModulus;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            etNumber1 = findViewById(R.id.etNumber1);
            etNumber2 = findViewById(R.id.etNumber2);
            tvResult = findViewById(R.id.tvResult);
            btnAdd = findViewById(R.id.btnAdd);
            btnSubtract = findViewById(R.id.btnSubtract);
            btnMultiply = findViewById(R.id.btnMultiply);
            btnDivide = findViewById(R.id.btnDivide);
            btnModulus = findViewById(R.id.btnModulus);

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculate('+');
                }
            });

            btnSubtract.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculate('-');
                }
            });

            btnMultiply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculate('*');
                }
            });

            btnDivide.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculate('/');
                }
            });

            btnModulus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculate('%');
                }
            });
        }

        private void calculate(char operator) {
            double num1 = Double.parseDouble(etNumber1.getText().toString());
            double num2 = Double.parseDouble(etNumber2.getText().toString());
            double result = 0;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0)
                        result = num1 / num2;
                    else
                        tvResult.setText("Error: Division by zero");
                    return;
                case '%':
                    if (num2 != 0)
                        result = num1 % num2;
                    else
                        tvResult.setText("Error: Division by zero");
                    return;
            }

            tvResult.setText("Result: " + result);
        }


}