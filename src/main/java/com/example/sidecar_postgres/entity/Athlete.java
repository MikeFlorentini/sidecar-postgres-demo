/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sidecar_postgres.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author mike
 */
@Entity
public class Athlete {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String name;
    private String sport;
    private String team;

    public Athlete() {
    }

    public Athlete(String name, String sport, String team) {
        this.name = name;
        this.sport = sport;
        this.team = team;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Athlete{" + "id=" + id + ", name=" + name + ", sport=" + sport + ", team=" + team + '}';
    }
}
