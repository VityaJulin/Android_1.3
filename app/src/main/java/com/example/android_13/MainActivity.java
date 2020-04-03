package com.example.android_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout nameEdx;
    private TextInputLayout ageEdx;
    private Button saveBtn;
    private Button goMedicalBtn;
    private Button goLifeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdx = findViewById(R.id.enterNameTxt);
        ageEdx = findViewById(R.id.enterAgeTxt);
        saveBtn = findViewById(R.id.saveBtn);
        goMedicalBtn = findViewById(R.id.goMedicalIndicatorsBtn);
        goLifeBtn = findViewById(R.id.goLifeIndicatorsBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdx.getEditText().toString();
                String age = ageEdx.getEditText().toString();
                if (name.equals("") || name.matches("\\d+") || age.matches("\\D+")) {
                    Toast.makeText(MainActivity.this, R.string.error_input_main, Toast.LENGTH_LONG).show();
                } else {
                    Patient patient = new Patient(name, Integer.valueOf(age));
                    Toast.makeText(MainActivity.this, R.string.add_success, Toast.LENGTH_LONG).show();
                }
            }
        });

        goMedicalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MedicalIndicatorsActivity.class);
                startActivity(intent);
            }
        });

        goLifeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LifeIndicatorsActivity.class);
                startActivity(intent);
            }
        });
    }
}
