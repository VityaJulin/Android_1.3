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
        nameEdx.setHint("Name");
        ageEdx.setHint("Age");

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdx.getEditText().getText().toString();
                String age = ageEdx.getEditText().getText().toString();
                nameEdx.setError(null);
                ageEdx.setError(null);

                if (name.isEmpty() || containsDigit(name)) {
                    nameEdx.setError(getString(R.string.error_input_name));
                }
                if (age.isEmpty() || containsNotDigit(age)) {
                    ageEdx.setError(getString(R.string.error_input_age));
                }

                if (!age.isEmpty() && !name.isEmpty() && !containsDigit(name) && !containsNotDigit(age)) {
                    try {
                        Patient patient = new Patient(name, Integer.parseInt(age));
                        nameEdx.getEditText().setText(null);
                        ageEdx.getEditText().setText(null);
                        Toast.makeText(MainActivity.this, R.string.add_success, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        ageEdx.setError(getString(R.string.error_input_age));
                    }
                }
            }


            private boolean containsDigit(String s) {
                boolean containsDigit = false;
                if (s != null && !s.isEmpty()) {
                    for (char c : s.toCharArray()) {
                        if (containsDigit = Character.isDigit(c)) {
                            break;
                        }
                    }
                }
                return containsDigit;
            }

            private boolean containsNotDigit(String s) {
                boolean containsNotDigit = false;
                if (s != null && !s.isEmpty()) {
                    for (char c : s.toCharArray()) {
                        if (containsNotDigit = !Character.isDigit(c)) {
                            break;
                        }
                    }
                }
                return containsNotDigit;
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
