package com.qrz.sp9gi.sotalogger.domain;

import javax.persistence.*;

@Entity
public class Summit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String summitReference;
    private String summitName;
    private int summitPoints;

    @OneToOne
    private Activation activation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummitReference() {
        return summitReference;
    }

    public void setSummitReference(String summitReference) {
        this.summitReference = summitReference;
    }

    public String getSummitName() {
        return summitName;
    }

    public void setSummitName(String summitName) {
        this.summitName = summitName;
    }

    public int getSummitPoints() {
        return summitPoints;
    }

    public void setSummitPoints(int summitPoints) {
        this.summitPoints = summitPoints;
    }

    public Activation getActivation() {
        return activation;
    }

    public void setActivation(Activation activation) {
        this.activation = activation;
    }
}
