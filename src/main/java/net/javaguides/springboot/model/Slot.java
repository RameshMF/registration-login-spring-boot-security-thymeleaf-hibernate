package net.javaguides.springboot.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Slot implements Serializable {

      private String sport;

//    @DateTimeFormat(pattern = "yyyy-MM-dd")
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date birthDate;

    public Slot(String sport, Date birthdate) {
        this.sport = sport;
        this.birthDate = birthdate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthdate) {
        this.birthDate = birthdate;
    }

    public Slot() {
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}
