package com.qrz.sp9gi.sotalogger.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RadioHam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String callsign;
    private String qth;

    @ManyToMany(mappedBy = "radioHams")
    private Set<Band> bands;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getQth() {
        return qth;
    }

    public void setQth(String qth) {
        this.qth = qth;
    }

    public Set<Band> getBands() {
        return bands;
    }

    public void setBands(Set<Band> bands) {
        this.bands = bands;
    }
}
