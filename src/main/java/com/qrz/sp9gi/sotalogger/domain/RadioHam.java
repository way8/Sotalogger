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
    private Set<Activation> activations;

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

    public Set<Activation> getActivations() {
        return activations;
    }

    public void setActivations(Set<Activation> activations) {
        this.activations = activations;
    }
}
