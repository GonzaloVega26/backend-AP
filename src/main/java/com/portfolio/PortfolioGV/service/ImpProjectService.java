/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.service;

import com.portfolio.PortfolioGV.entity.Project;
import com.portfolio.PortfolioGV.repository.IProjectRepository;
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
public class ImpProjectService {
    @Autowired IProjectRepository iProjectRepository;
    
    
    public List<Project> listProjects(){
        return iProjectRepository.findAll();
    }
    
    public Optional<Project> getProjectByID(int id){
        return iProjectRepository.findById(id);
    }
    
    public Optional<Project> getProjectByTitle(String title){
        return iProjectRepository.findByTitle(title);
    }
    
    public void saveProject(Project project){
        iProjectRepository.save(project);
    }
    
    public void deleteProject(int id){
        iProjectRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iProjectRepository.existsById(id);
    }
    
    public boolean existsByTitle(String title){
        return iProjectRepository.existsByTitle(title);
    }
}
