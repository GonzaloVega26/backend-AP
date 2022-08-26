/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.controller;

import com.portfolio.PortfolioGV.entity.Person;
import com.portfolio.PortfolioGV.interfaces.IPersonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gonzalo
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonController {
    
    @Autowired IPersonService iPersonService;
    
    @GetMapping("person/get-all")
    public List<Person> getPerson(){
        return iPersonService.getPerson();
    }
    
    @PostMapping("person/create")
    public String createPerson(@RequestBody Person person){
        iPersonService.savePerson(person);
        return "Succesfully Created";
    }
    
    @DeleteMapping("person/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        iPersonService.deletePerson(id);
        return "Succesfully Deleted";
    }
    
    @PutMapping("person/update/{id}")
    public Person updatePerson(@PathVariable Long id, 
            @RequestParam("name") String newName,
            @RequestParam("firstName") String newFirstName,
            @RequestParam("img") String newImg){
        Person person = iPersonService.findPerson(id);
        person.setName(newName);
        person.setFirstName(newFirstName);
        person.setImg(newImg);
        
        iPersonService.savePerson(person);
        
        return person;
        
    }
    
    @GetMapping("person/get-one")
    public Person getOnePerson(){
        Person person = iPersonService.findPerson((long) 1); //There is only one person in database
        return person;
    }
}
