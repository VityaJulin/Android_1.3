package com.example.android_13;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MedicalIndicators {
    private int topPressure;
    private int lowerPressure;
    private boolean tachycardia;
    private Date enterDate;

    public MedicalIndicators(int topPressure, int lowerPressure, boolean tachycardia, Date enterDate) {
        this.topPressure = topPressure;
        this.lowerPressure = lowerPressure;
        this.tachycardia = tachycardia;
        this.enterDate = enterDate;
    }
}
