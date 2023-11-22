package org.example.Models;

public class Symptom {
    private long idSymptom;
    private String NMdisease;
    private String DsSymptom;


    public Symptom(long idSymptom, String NMdisease, String dsSymptom) {
        this.idSymptom = idSymptom;
        this.NMdisease = NMdisease;
        DsSymptom = dsSymptom;
    }

    public Symptom() {
    }

    public String getNMdisease() {
        return NMdisease;
    }

    public void setNMdisease(String NMdisease) {
        this.NMdisease = NMdisease;
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
