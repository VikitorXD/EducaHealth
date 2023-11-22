package org.example.Models;

public class Symptom {
    private long idSymptom;
    private String DsSymptom;

    public Symptom(long idSymptom, String dsSymptom) {
        this.idSymptom = idSymptom;
        DsSymptom = dsSymptom;
    }

    public Symptom() {
    }

    public long getIdSymptom() {
        return idSymptom;
    }

    public void setIdSymptom(long idSymptom) {
        this.idSymptom = idSymptom;
    }

    public String getDsSymptom() {
        return DsSymptom;
    }

    public void setDsSymptom(String dsSymptom) {
        DsSymptom = dsSymptom;
    }
}
