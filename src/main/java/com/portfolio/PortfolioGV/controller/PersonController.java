/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.controller;

import com.portfolio.PortfolioGV.DTO.DtoPerson;
import com.portfolio.PortfolioGV.entity.Person;
import com.portfolio.PortfolioGV.security.controller.PMessage;
import com.portfolio.PortfolioGV.service.ImpPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/person")
public class PersonController {
    
    @Autowired ImpPersonService impPersonService;
    
    @GetMapping("/get-one")
    public ResponseEntity<Person> getOnePerson(){
        
        Person person = impPersonService.findPerson(1);
        return new ResponseEntity(person,HttpStatus.OK);
    }
   
    @PutMapping("/update-person")
    public ResponseEntity<?> updatePerson(@RequestBody DtoPerson dtoPerson){
        
        if(dtoPerson.getName().isBlank()){
             return new ResponseEntity(new PMessage("Name of Person is Required"),HttpStatus.BAD_REQUEST);
        }
        if(dtoPerson.getTitle().isBlank()){
             return new ResponseEntity(new PMessage("Title of Person is Required"),HttpStatus.BAD_REQUEST);
        }
        if(dtoPerson.getAbout().isBlank()){
             return new ResponseEntity(new PMessage("About of Person is Required"),HttpStatus.BAD_REQUEST);
        }
        if(dtoPerson.getImgURL().isBlank()){
             return new ResponseEntity(new PMessage("Profile Photo of Person is Required"),HttpStatus.BAD_REQUEST);
        }
        if(dtoPerson.getBannerURL().isBlank()){
             return new ResponseEntity(new PMessage("Banner is Required"),HttpStatus.BAD_REQUEST);
        }
        
       
        Person person = impPersonService.findPerson(1); //Only one person will be created;
        person.setName(dtoPerson.getName());
        person.setTitle(dtoPerson.getTitle());
        person.setAbout(dtoPerson.getAbout());
        person.setImgURL(dtoPerson.getImgURL());
        person.setBannerURL(dtoPerson.getBannerURL());
        impPersonService.savePerson(person);
        return new ResponseEntity(new PMessage("The Person was updated succesfully"),HttpStatus.OK);
    }
    
    
    
}
