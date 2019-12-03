package com.qrz.sp9gi.sotalogger.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;
    private String regionName;

    @OneToOne
    private Activation activation;

    @OneToOne
    private Summit summit;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Activation getActivation() {
        return activation;
    }

    public void setActivation(Activation activation) {
        this.activation = activation;
    }

    public Summit getSummit() {
        return summit;
    }

    public void setSummit(Summit summit) {
        this.summit = summit;
    }
}
