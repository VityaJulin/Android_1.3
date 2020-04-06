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

public class LifeIndicatorsActivity extends AppCompatActivity {
    private TextInputLayout weightEtx;
    private TextInputLayout stepsEtx;
    private Button saveLifeBtn;
    private Button goMainBtn;
    private Button goMedicalBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_indicators_add);

        weightEtx = findViewById(R.id.enterWeightTxt);
        stepsEtx = findViewById(R.id.enterStepsTxt);
        saveLifeBtn = findViewById(R.id.saveLifeBtn);
        goMainBtn = findViewById(R.id.goMainBtn);
        goMedicalBtn = findViewById(R.id.goMedicalIndicatorsBtn);

        saveLifeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight = weightEtx.getEditText().getText().toString();
                String steps = stepsEtx.getEditText().getText().toString();
                if (weight.equals("") || weight.matches("\\D+")
                        || steps.matches("\\D+") || steps.equals("")) {
                    Toast.makeText(LifeIndicatorsActivity.this, R.string.error_input_life,
                            Toast.LENGTH_LONG).show();
                } else {
                    try {
                        LifeIndicators lifeIndicators = new LifeIndicators(Integer.parseInt(weight), Integer.parseInt(steps));
                        Toast.makeText(LifeIndicatorsActivity.this, R.string.add_success, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(LifeIndicatorsActivity.this, R.string.error_input_life,
                                Toast.LENGTH_LONG).show();

                    }
                }
            }
        });

        goMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeIndicatorsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        goMedicalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LifeIndicatorsActivity.this, MedicalIndicatorsActivity.class);
                startActivity(intent);
            }
        });
    }
}
