package com.qrz.sp9gi.sotalogger.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Activation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String activatorCallsign;
    private Date Date;

    //Cascade: przy skasowaniu aktywacji kasuje również notatkę, podobnie przy zapisie - zapisując aktywacje zapisuejmy też notatkę
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    @OneToOne(cascade = CascadeType.ALL)
    private Summit summit;

    @OneToMany(mappedBy = "activation")
    private Set<Band> bands = new HashSet<>();


    //setters and getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActivatorCallsign() {
        return activatorCallsign;
    }

    public void setActivatorCallsign(String activatorCallsign) {
        this.activatorCallsign = activatorCallsign;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
            //przypisuje activation_ID do notatki
            notes.setActivation(this);
        }
    }

    public Summit getSummit() {
        return summit;
    }

    public void setSummit(Summit summit) {
        this.summit = summit;
    }

    public Set<Band> getBands() {
        return bands;
    }

    public void setBands(Set<Band> bands) {
        this.bands = bands;
    }
}
