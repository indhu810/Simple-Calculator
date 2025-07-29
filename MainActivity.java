package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonadd, buttonsub, buttonmul, buttondiv;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonadd = findViewById(R.id.btn_add);
        buttonsub = findViewById(R.id.btn_sub);
        buttonmul = findViewById(R.id.btn_mul);
        buttondiv = findViewById(R.id.btn_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonadd.setOnClickListener(this);
        buttonsub.setOnClickListener(this);
        buttonmul.setOnClickListener(this);
        buttondiv.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText) {
        String input = editText.getText().toString();
        if (input.equals("")) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Integer.parseInt(input);
        }
    }

    @Override
    public void onClick(View view) {
        num1 = getIntFromEditText(editTextN1);
        num2 = getIntFromEditText(editTextN2);

        switch (view.getId()) {
            case R.id.btn_add:
                textView.setText("Answer = " + (num1 + num2));
                break;
            case R.id.btn_sub:
                textView.setText("Answer = " + (num1 - num2));
                break;
            case R.id.btn_mul:
                textView.setText("Answer = " + (num1 * num2));
                break;
            case R.id.btn_div:
                if (num2 != 0)
                    textView.setText("Answer = " + (num1 / num2));
                else
                    textView.setText("Cannot divide by zero");
                break;
        }
    }
}
