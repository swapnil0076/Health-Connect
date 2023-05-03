package com.app.model;

public enum Slot {

    SLOT1("10:00 AM - 11:00 AM"),
    SLOT2("11:00 AM - 12:00 PM"),
    SLOT3("12:00 PM - 01:00 PM"),
    SLOT4("01:00 PM - 02:00 PM"),
    SLOT5("10:00 AM - 11:00 AM"),
    SLOT6("11:00 AM - 12:00 PM"),
    SLOT7("12:00 PM - 01:00 PM"),
    SLOT8("01:00 PM - 02:00 PM"),
    SLOT9("10:00 AM - 11:00 AM"),
    SLOT10("11:00 AM - 12:00 PM"),
    SLOT11("12:00 PM - 01:00 PM"),
    SLOT12("01:00 PM - 02:00 PM");

    private String time;

    Slot(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

}
