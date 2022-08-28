/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.service;

import com.portfolio.PortfolioGV.entity.Experience;
import com.portfolio.PortfolioGV.repository.IExperienceRepository;
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
public class ImpExperienceService {
    @Autowired IExperienceRepository iExperienceRepository;
    
    public List<Experience> listExperience(){
        return iExperienceRepository.findAll();
    }
    
    public Optional<Experience> getExperienceByID(int id){
        return iExperienceRepository.findById(id);
    }
    
    public Optional<Experience> getExperienceByName(String name){
        return iExperienceRepository.findByName(name);
    }
    
    public void saveExperience(Experience experience){
        iExperienceRepository.save(experience);
    }
    
    public void deleteExperience(int id){
        iExperienceRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iExperienceRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return iExperienceRepository.existsByName(name);
    }
}
