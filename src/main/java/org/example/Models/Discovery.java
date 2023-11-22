package org.example.Models;

import java.time.LocalDate;

public class Discovery {

    private long IdDiscovery;
    private LocalDate DtDiscovey;
    private String NmDiscover;
    private  String DsDiscovery;

    public Discovery(long idDiscovery, LocalDate dtDiscovey, String nmDiscover, String dsDiscovery) {
        IdDiscovery = idDiscovery;
        DtDiscovey = dtDiscovey;
        NmDiscover = nmDiscover;
        DsDiscovery = dsDiscovery;
    }

    public Discovery() {
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
