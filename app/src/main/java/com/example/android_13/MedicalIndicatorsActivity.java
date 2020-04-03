package com.example.android_13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MedicalIndicatorsActivity extends AppCompatActivity {
    private TextInputLayout topPressureEdx;
    private TextInputLayout lowPressureEdx;
    private Button goLifeBtn;
    private Button goMainBtn;
    private Button saveMedicBtn;
    private CheckBox tachycardiaChk;
    private Date enterDate ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_indicators);

        topPressureEdx = findViewById(R.id.enterTopPressureTxt);
        lowPressureEdx = findViewById(R.id.enterLowPressureTxt);
        goLifeBtn = findViewById(R.id.goLifeIndicatorsBtn);
        goMainBtn = findViewById(R.id.goMainBtn);
        saveMedicBtn = findViewById(R.id.saveBtnMedic);
        tachycardiaChk = findViewById(R.id.tacCheck);


        saveMedicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String topPressure = topPressureEdx.getEditText().toString();
                String lowPressure = lowPressureEdx.getEditText().toString();
                Boolean tachycardia = tachycardiaChk.isChecked();
                enterDate = new Date();
                if (topPressure.matches("\\D+") || lowPressure.matches("\\D+")) {
                    Toast.makeText(MedicalIndicatorsActivity.this, R.string.error_input_medic, Toast.LENGTH_LONG).show();
                } else {
                    MedicalIndicators medicalIndicators = new MedicalIndicators(Integer.valueOf(topPressure),
                            Integer.valueOf(lowPressure), tachycardia, enterDate);
                }
            }
        });

        goLifeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalIndicatorsActivity.this, LifeIndicatorsActivity.class);
                startActivity(intent);
            }
        });

        goMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicalIndicatorsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
