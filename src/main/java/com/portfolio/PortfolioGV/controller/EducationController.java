/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.controller;

import com.portfolio.PortfolioGV.DTO.DTOEducation;
import com.portfolio.PortfolioGV.entity.Education;
import com.portfolio.PortfolioGV.security.controller.PMessage;
import com.portfolio.PortfolioGV.service.ImpEducationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/education")
public class EducationController {
    @Autowired ImpEducationService impEducationService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Education>> listExperience(){
        List<Education> list = impEducationService.listEducation();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @GetMapping("/detail-education/{id}")
    public ResponseEntity<Education> getOneEducation(@PathVariable("id") int id){
        if(!impEducationService.existsById(id)){
        return new ResponseEntity(new PMessage("Education doesn't exists"),HttpStatus.BAD_REQUEST);
    }
        Education education = impEducationService.getEducationByID(id).get();
        return new ResponseEntity(education,HttpStatus.OK);
    }
   

    
    @PostMapping("/create-education")
    public ResponseEntity<?> createEducation(@RequestBody DTOEducation dtoEducation){
        
        if(dtoEducation.getName().isBlank()){
             return new ResponseEntity(new PMessage("Name of Education is Required"),HttpStatus.BAD_REQUEST);
        }
        
        if(impEducationService.existsByName(dtoEducation.getName())){
             return new ResponseEntity(new PMessage("The Experience is already created"),HttpStatus.BAD_REQUEST);
        }
        Education education = new Education(dtoEducation.getName(),dtoEducation.getDescription());
        impEducationService.saveEducation(education);
        return new ResponseEntity(new PMessage("The Education was added succesfully"),HttpStatus.OK);
    }
    
    @PutMapping("/update-education/{id}")
    public ResponseEntity<?> updateEducation(@PathVariable("id") int id, @RequestBody DTOEducation dtoEducation){
        if(!impEducationService.existsById(id)){
            return new ResponseEntity(new PMessage("Education don't exists"),HttpStatus.BAD_REQUEST);
        }
        if(dtoEducation.getName().isBlank()){
             return new ResponseEntity(new PMessage("Name of Education is Required"),HttpStatus.BAD_REQUEST);
        }
        
        if(impEducationService.existsByName(dtoEducation.getName())){
             return new ResponseEntity(new PMessage("The Education is already created"),HttpStatus.BAD_REQUEST);
        }
        Education education = impEducationService.getEducationByID(id).get();
        education.setName(dtoEducation.getName());
        education.setDescription(dtoEducation.getDescription());
        impEducationService.saveEducation(education);
        return new ResponseEntity(new PMessage("The Education was updated succesfully"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete-education/{id}")
    public ResponseEntity<?> deleteEducation(@PathVariable("id") int id){
        if(!impEducationService.existsById(id)){
            return new ResponseEntity(new PMessage("Education don't exists"),HttpStatus.BAD_REQUEST);
        }
        
        impEducationService.deleteEducation(id);
        return new ResponseEntity(new PMessage("The Education was deleted succesfully"),HttpStatus.OK);
    }
    
}
