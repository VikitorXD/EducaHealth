package org.example.Models;

public class Tratament {

    private long IdTreatment;
    private String RrMedication;
    private String Fquse;
    private String DsTratament;

    public Tratament(long idTreatment, String rrMedication, String fquse, String dsTratament) {
        IdTreatment = idTreatment;
        RrMedication = rrMedication;
        Fquse = fquse;
        DsTratament = dsTratament;
    }

    public Tratament() {
    }

    public long getIdTreatment() {
        return IdTreatment;
    }

    public void setIdTreatment(long idTreatment) {
        IdTreatment = idTreatment;
    }

    public String getRrMedication() {
        return RrMedication;
    }

    public void setRrMedication(String rrMedication) {
        RrMedication = rrMedication;
    }

    public String getFquse() {
        return Fquse;
    }

    public void setFquse(String fquse) {
        Fquse = fquse;
    }

    public String getDsTratament() {
        return DsTratament;
    }

    public void setDsTratament(String dsTratament) {
        DsTratament = dsTratament;
    }
}
