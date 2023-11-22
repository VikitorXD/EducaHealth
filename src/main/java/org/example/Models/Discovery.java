package org.example.Models;

import java.time.LocalDate;

public class Discovery {

    private long IdDiscovery;
    private LocalDate DtDiscovey;
    private String NMdisease;
    private String NmDiscover;
    private  String DsDiscovery;


    public Discovery(long idDiscovery, LocalDate dtDiscovey, String NMdisease, String nmDiscover, String dsDiscovery) {
        IdDiscovery = idDiscovery;
        DtDiscovey = dtDiscovey;
        this.NMdisease = NMdisease;
        NmDiscover = nmDiscover;
        DsDiscovery = dsDiscovery;
    }

    public Discovery() {
    }

    public String getNMdisease() {
        return NMdisease;
    }

    public void setNMdisease(String NMdisease) {
        this.NMdisease = NMdisease;
    }

    public long getIdDiscovery() {
        return IdDiscovery;
    }

    public void setIdDiscovery(long idDiscovery) {
        IdDiscovery = idDiscovery;
    }

    public LocalDate getDtDiscovey() {
        return DtDiscovey;
    }

    public void setDtDiscovey(LocalDate dtDiscovey) {
        DtDiscovey = dtDiscovey;
    }

    public String getNmDiscover() {
        return NmDiscover;
    }

    public void setNmDiscover(String nmDiscover) {
        NmDiscover = nmDiscover;
    }

    public String getDsDiscovery() {
        return DsDiscovery;
    }

    public void setDsDiscovery(String dsDiscovery) {
        DsDiscovery = dsDiscovery;
    }
}
