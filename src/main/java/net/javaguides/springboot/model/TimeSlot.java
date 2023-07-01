package net.javaguides.springboot.model;


import java.io.Serializable;
import java.util.Date;

public class TimeSlot implements Serializable {

    private String sport;


    public TimeSlot(String sport, Date birthdate) {
        this.sport = sport;
    }
    public TimeSlot() {
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}