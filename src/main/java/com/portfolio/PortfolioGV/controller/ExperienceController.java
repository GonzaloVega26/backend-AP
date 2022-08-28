/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.controller;

import com.portfolio.PortfolioGV.DTO.DtoExperience;
import com.portfolio.PortfolioGV.entity.Experience;
import com.portfolio.PortfolioGV.security.controller.PMessage;
import com.portfolio.PortfolioGV.service.ImpExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gonzalo
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/experience")
public class ExperienceController {
    @Autowired ImpExperienceService impExperienceService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Experience>> listExperience(){
        List<Experience> list = impExperienceService.listExperience();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @GetMapping("/detail-experience/{id}")
    public ResponseEntity<Experience> getOneExperience(@PathVariable("id") int id){
        if(!impExperienceService.existsById(id)){
        return new ResponseEntity(new PMessage("Experience doesn't exists"),HttpStatus.BAD_REQUEST);
    }
        Experience experience = impExperienceService.getExperienceByID(id).get();
        return new ResponseEntity(experience,HttpStatus.OK);
    }
   

    
    @PostMapping("/create-experience")
    public ResponseEntity<?> createExperience(@RequestBody DtoExperience dtoExperience){
        System.out.println(dtoExperience.getName());
        System.out.println(dtoExperience.getDescription());
        if(dtoExperience.getName().isBlank()){
             return new ResponseEntity(new PMessage("Name of Experience is Required"),HttpStatus.BAD_REQUEST);
        }
        
        if(impExperienceService.existsByName(dtoExperience.getName())){
             return new ResponseEntity(new PMessage("The Experience is already created"),HttpStatus.BAD_REQUEST);
        }
        Experience experience = new Experience(dtoExperience.getName(),dtoExperience.getDescription());
        impExperienceService.saveExperience(experience);
        return new ResponseEntity(new PMessage("The Experience was added succesfully"),HttpStatus.OK);
    }
    
    @PutMapping("/update-experience/{id}")
    public ResponseEntity<?> updateExperience(@PathVariable("id") int id, @RequestBody DtoExperience dtoExperience){
        if(!impExperienceService.existsById(id)){
            return new ResponseEntity(new PMessage("Experience don't exists"),HttpStatus.BAD_REQUEST);
        }
        if(dtoExperience.getName().isBlank()){
             return new ResponseEntity(new PMessage("Name of Experience is Required"),HttpStatus.BAD_REQUEST);
        }
        
        if(impExperienceService.existsByName(dtoExperience.getName())){
             return new ResponseEntity(new PMessage("The Experience is already created"),HttpStatus.BAD_REQUEST);
        }
        Experience experience = impExperienceService.getExperienceByID(id).get();
        experience.setName(dtoExperience.getName());
        experience.setDescription(dtoExperience.getDescription());
        impExperienceService.saveExperience(experience);
        return new ResponseEntity(new PMessage("The Experience was updated succesfully"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete-experience/{id}")
    public ResponseEntity<?> deleteExperience(@PathVariable("id") int id){
        if(!impExperienceService.existsById(id)){
            return new ResponseEntity(new PMessage("Experience don't exists"),HttpStatus.BAD_REQUEST);
        }
        
        impExperienceService.deleteExperience(id);
        return new ResponseEntity(new PMessage("The Experience was deleted succesfully"),HttpStatus.OK);
    }
}
