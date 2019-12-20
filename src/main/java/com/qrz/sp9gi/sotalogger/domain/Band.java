package com.qrz.sp9gi.sotalogger.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String band;

    @ManyToOne
    private Activation activation;

    @ManyToMany
    @JoinTable(name = "band_radio_ham", joinColumns = @JoinColumn(name = "band_id"),
            inverseJoinColumns = @JoinColumn(name ="radio_ham_id" ))
    private Set<RadioHam> radioHams = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public Activation getActivation() {
        return activation;
    }

    public void setActivation(Activation activation) {
        this.activation = activation;
    }

    public Set<RadioHam> getRadioHams() {
        return radioHams;
    }

    public void setRadioHams(Set<RadioHam> radioHams) {
        this.radioHams = radioHams;
    }
}
