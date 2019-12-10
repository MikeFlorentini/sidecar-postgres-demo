/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.sidecar_postgres.repository;

import com.example.sidecar_postgres.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mike
 */
public interface AthleteRepository extends JpaRepository<Athlete, Long> {
    
}
