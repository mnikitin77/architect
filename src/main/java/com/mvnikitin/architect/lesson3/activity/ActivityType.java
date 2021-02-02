package com.mvnikitin.architect.lesson3.activity;

public enum ActivityType {
    CALL ("Call"),
    EMAIL ("Email"),
    SMS ("SMS"),
    CHAT ("Chat"),
    VISIT ("Visit");

    private final String text;

    ActivityType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
