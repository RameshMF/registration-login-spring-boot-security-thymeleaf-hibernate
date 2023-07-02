package net.javaguides.springboot.model;

public class FormModel {
    private String selectedOption;

    public String date;

    public FormModel() {
    }

    public String getRadioOption() {
        return selectedOption;
    }

    public void setRadioOption(String radioOption) {
        this.selectedOption = radioOption;
    }
}
