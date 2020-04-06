package com.example.android_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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
                String name = nameEdx.getEditText().getText().toString();
                String age = ageEdx.getEditText().getText().toString();
                ageEdx.setError(getString(R.string.error_input_age));
                nameEdx.setError(getString(R.string.error_input_name));

                //issue
                nameEdx.setErrorEnabled(true);
                ageEdx.setErrorEnabled(true);
                if (name.equals("") || name.contains("\\d+")) {
                    ageEdx.setError("");
                } else if (age.equals("")) {
                    nameEdx.setError("");
                } else {
                    try {
                        Patient patient = new Patient(name, Integer.parseInt(age));
                        Toast.makeText(MainActivity.this, R.string.add_success, Toast.LENGTH_LONG).show();
                        nameEdx.setError("");
                        ageEdx.setError("");
                    } catch (Exception e) {

                    }
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
