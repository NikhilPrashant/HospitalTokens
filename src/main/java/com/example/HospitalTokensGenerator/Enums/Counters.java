package com.example.HospitalTokensGenerator.Enums;

public enum Counters {
    COUNTER_1("C1"), COUNTER_2("C2"), COUNTER_3("C3");

    String id;
    Counters(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
