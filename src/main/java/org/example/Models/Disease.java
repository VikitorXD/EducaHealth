package org.example.Models;

public class Disease {

    private long idDisease;

    private String NMdisease;
    private String type;
    private String Recurrence;

    public Disease(long idDisease, String NMdisease, String type, String recurrence) {
        this.idDisease = idDisease;
        this.NMdisease = NMdisease;
        this.type = type;
        Recurrence = recurrence;
    }

    public long getIdDisease() {
        return idDisease;
    }

    public void setIdDisease(long idDisease) {
        this.idDisease = idDisease;
    }

    public Disease() {
    }

    public String getNMdisease() {
        return NMdisease;
    }

    public void setNMdisease(String NMdisease) {
        this.NMdisease = NMdisease;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRecurrence() {
        return Recurrence;
    }

    public void setRecurrence(String recurrence) {
        Recurrence = recurrence;
    }
}
