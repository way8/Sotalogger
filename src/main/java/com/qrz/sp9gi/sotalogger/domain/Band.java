package com.qrz.sp9gi.sotalogger.domain;

import javax.persistence.*;

@Entity
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bandName;

    @ManyToOne
    private Activation activation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public Activation getActivation() {
        return activation;
    }

    public void setActivation(Activation activation) {
        this.activation = activation;
    }

//    public Band(String bandName, Activation activation) {
//        this.bandName = bandName;
//        this.activation = activation;
//    }
//
//    public Band(String bandName) {
//        this.bandName = bandName;
//       }
}
