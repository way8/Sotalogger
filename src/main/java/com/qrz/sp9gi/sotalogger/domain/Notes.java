package com.qrz.sp9gi.sotalogger.domain;

import javax.persistence.*;

@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String activationNotes;

    @OneToOne
    private Activation activation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivationNotes() {
        return activationNotes;
    }

    public void setActivationNotes(String activationNotes) {
        this.activationNotes = activationNotes;
    }

    public Activation getActivation() {
        return activation;
    }

    public void setActivation(Activation activation) {
        this.activation = activation;
    }
}
