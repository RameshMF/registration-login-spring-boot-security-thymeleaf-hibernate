package net.javaguides.springboot.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Slot implements Serializable {

     @Id
     @GeneratedValue
     private Long slotId;
      private String sport;

     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date birthDate;

    @ElementCollection
    @CollectionTable(name = "my_strings")
     private Set<String> options;

     private boolean booked = false;

     @OneToOne(cascade = CascadeType.ALL)
     private Person person;

     private String selectedOption;

    @ElementCollection
    @CollectionTable(name = "availableSlots")
     private Set<String> availableSlots;

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public Set<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(Set<String> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public Set<String> getOptions() {
        return options;
    }

    public void setOptions(Set<String> options) {
        this.options = options;
    }

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
