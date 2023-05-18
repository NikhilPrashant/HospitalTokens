package com.example.HospitalTokensGenerator.Functions;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

public class SlipGenerator {
    private static int currSlip;
    private static LocalDate localDate;

    public SlipGenerator() {
        currSlip = 0;
        localDate = LocalDate.now();
    }

    public static int getCurrSlip() {
        LocalDate currDate = LocalDate.now();
        if (!currDate.equals(localDate)) {
            dayChangeResetSlip();
        }
        currSlip += 1;
        return currSlip;
    }

    public static void dayChangeResetSlip() {
        currSlip = 0;
    }
}
