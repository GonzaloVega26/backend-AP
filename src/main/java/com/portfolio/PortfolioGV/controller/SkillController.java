/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.controller;

import com.portfolio.PortfolioGV.DTO.DtoSkill;
import com.portfolio.PortfolioGV.entity.Skill;
import com.portfolio.PortfolioGV.security.controller.PMessage;
import com.portfolio.PortfolioGV.service.ImpSkillService;
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
@RequestMapping("/skill")
public class SkillController {
    @Autowired ImpSkillService impSkillService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Skill>> listSkills(){
        List<Skill> list = impSkillService.listSkills();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @GetMapping("/detail-skill/{id}")
    public ResponseEntity<Skill> getOneSkill(@PathVariable("id") int id){
        if(!impSkillService.existsById(id)){
        return new ResponseEntity(new PMessage("Skill doesn't exists"),HttpStatus.BAD_REQUEST);
    }
        Skill skill = impSkillService.getSkillByID(id).get();
        return new ResponseEntity(skill,HttpStatus.OK);
    }
   

    
    @PostMapping("/create-skill")
    public ResponseEntity<?> createSkill(@RequestBody DtoSkill dtoSkill){
        
        if(dtoSkill.getName().isBlank()){
             return new ResponseEntity(new PMessage("Name of Skill is Required"),HttpStatus.BAD_REQUEST);
        }
        
        if(impSkillService.existsByName(dtoSkill.getName())){
             return new ResponseEntity(new PMessage("The Skill is already created"),HttpStatus.BAD_REQUEST);
        }
        Skill skill = new Skill(dtoSkill.getName(),dtoSkill.getPercentage(), dtoSkill.getColor());
        impSkillService.saveSkill(skill);
        return new ResponseEntity(new PMessage("The Skill was added succesfully"),HttpStatus.OK);
    }
    
    @PutMapping("/update-skill/{id}")
    public ResponseEntity<?> updateSkill(@PathVariable("id") int id, @RequestBody DtoSkill dtoSkill){
        if(!impSkillService.existsById(id)){
            return new ResponseEntity(new PMessage("Skill don't exists"),HttpStatus.BAD_REQUEST);
        }
        if(dtoSkill.getName().isBlank()){
             return new ResponseEntity(new PMessage("Name of Skill is Required"),HttpStatus.BAD_REQUEST);
        }
            
        if(impSkillService.existsByName(dtoSkill.getName()) && 
                impSkillService.getSkillByName(dtoSkill.getName()).get().getId() != id){
             return new ResponseEntity(new PMessage("The Skill is already created"),HttpStatus.BAD_REQUEST);
        }
        Skill skill = impSkillService.getSkillByID(id).get();
        skill.setName(dtoSkill.getName());
        skill.setPercentage(dtoSkill.getPercentage());
        skill.setColor(dtoSkill.getColor());
        impSkillService.saveSkill(skill);
        return new ResponseEntity(new PMessage("The Skill was updated succesfully"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete-skill/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable("id") int id){
        if(!impSkillService.existsById(id)){
            return new ResponseEntity(new PMessage("Skill don't exists"),HttpStatus.BAD_REQUEST);
        }
        
        impSkillService.deleteSkill(id);
        return new ResponseEntity(new PMessage("The Skill was deleted succesfully"),HttpStatus.OK);
    }
}
