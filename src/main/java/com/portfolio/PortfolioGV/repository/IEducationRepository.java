/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.PortfolioGV.repository;

import com.portfolio.PortfolioGV.entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gonzalo
 */
@Repository
public interface IEducationRepository extends JpaRepository<Education, Integer>{
public Optional<Education> findByName(String name);
public boolean existsByName(String name);


    
}
