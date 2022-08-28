/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.service;

import com.portfolio.PortfolioGV.entity.Education;
import com.portfolio.PortfolioGV.repository.IEducationRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gonzalo
 */
@Service
@Transactional
public class ImpEducationService {
    @Autowired IEducationRepository iEducationRepository;
    
    public List<Education> listEducation(){
        return iEducationRepository.findAll();
    }
    
    public Optional<Education> getEducationByID(int id){
        return iEducationRepository.findById(id);
    }
    
    public Optional<Education> getEducationByName(String name){
        return iEducationRepository.findByName(name);
    }
    
    public void saveEducation(Education experience){
        iEducationRepository.save(experience);
    }
    
    public void deleteEducation(int id){
        iEducationRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iEducationRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return iEducationRepository.existsByName(name);
    }
}
