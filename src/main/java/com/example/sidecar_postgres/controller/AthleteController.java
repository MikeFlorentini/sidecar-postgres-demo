/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sidecar_postgres.controller;

import com.example.sidecar_postgres.entity.Athlete;
import com.example.sidecar_postgres.repository.AthleteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author mike
 */
public class AthleteController {
        
    @Autowired
    private AthleteRepository repository;
    
    @GetMapping(value = "/athlete/{id}")
    public String getAthlete(@PathVariable(value = "id") String id) {
        Athlete newAthlete = this.repository.getOne(Long.valueOf(id));
        return newAthlete.toString();
    }
    
    @GetMapping(value = "/allAthletes")
    public List<Athlete> showAllAthletes() {
        List<Athlete> list = this.repository.findAll();
        return list;
    }
    
    @GetMapping(value = "/hello")
    public String sayHello() {
        return "Hi buddy! I welcome you, bro!";
    }
    
    @GetMapping("/athlete/delete/{id}")
    public String deleteAthlete(@PathVariable(name = "id") String id) {
        Athlete athlete = this.repository.getOne(Long.valueOf(id));
        this.repository.delete(athlete);

        return "deleted Athlete with id " + id;
    }
    
    @PostMapping("/athlete")
    public String createAthlete(@RequestBody Athlete athlete) {
        this.repository.save(athlete);
        return athlete.toString();
    }

}
