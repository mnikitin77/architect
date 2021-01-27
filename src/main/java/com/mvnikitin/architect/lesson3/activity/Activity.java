package com.mvnikitin.architect.lesson3.activity;

import com.mvnikitin.architect.lesson3.dosmth.DoSmth;

import java.time.LocalDateTime;

public abstract class Activity {

    protected int id;
    protected String name;
    protected LocalDateTime start;
    protected LocalDateTime end;
    protected boolean isIncoming;
    protected String notes;
    protected String company;
    protected String person;

    private DoSmth doSmth;

    public Activity() {
        start = LocalDateTime.now();
        doSmth = createDoSmth();
    }

    public abstract ActivityType getType();

    public abstract DoSmth createDoSmth();

    public void doSmth() {
        doSmth.doSmth();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public boolean isIncoming() {
        return isIncoming;
    }

    public void setIncoming(boolean incoming) {
        isIncoming = incoming;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }
}
