/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.service;

import com.portfolio.PortfolioGV.entity.Skill;
import com.portfolio.PortfolioGV.repository.ISkillRepository;
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
public class ImpSkillService {
    @Autowired ISkillRepository iSkillRepository;
    
    public List<Skill> listSkills(){
        return iSkillRepository.findAll();
    }
    
    public Optional<Skill> getSkillByID(int id){
        return iSkillRepository.findById(id);
    }
    
    public Optional<Skill> getSkillByName(String name){
        return iSkillRepository.findByName(name);
    }
    
    public void saveSkill(Skill skill){
        iSkillRepository.save(skill);
    }
    
    public void deleteSkill(int id){
        iSkillRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iSkillRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return iSkillRepository.existsByName(name);
    }
}
