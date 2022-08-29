/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.controller;

import com.portfolio.PortfolioGV.DTO.DtoProject;
import com.portfolio.PortfolioGV.entity.Project;
import com.portfolio.PortfolioGV.security.controller.PMessage;
import com.portfolio.PortfolioGV.service.ImpProjectService;
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
@RequestMapping("/project")
public class ProjectController {
    @Autowired ImpProjectService impProjectService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Project>> listProjects(){
        List<Project> list = impProjectService.listProjects();
        return new ResponseEntity(list,HttpStatus.OK);
    }

    @GetMapping("/detail-project/{id}")
    public ResponseEntity<Project> getOneProject(@PathVariable("id") int id){
        if(!impProjectService.existsById(id)){
        return new ResponseEntity(new PMessage("Project doesn't exists"),HttpStatus.BAD_REQUEST);
    }
        Project project = impProjectService.getProjectByID(id).get();
        return new ResponseEntity(project,HttpStatus.OK);
    }
   

    
    @PostMapping("/create-project")
    public ResponseEntity<?> createProject(@RequestBody DtoProject dtoProject){
       
        if(dtoProject.getTitle().isBlank()){
             return new ResponseEntity(new PMessage("Title of Project is Required"),HttpStatus.BAD_REQUEST);
        }
        
        if(impProjectService.existsByTitle(dtoProject.getTitle())){
             return new ResponseEntity(new PMessage("The Project is already created"),HttpStatus.BAD_REQUEST);
        }
        Project project = new Project(dtoProject.getTitle(),dtoProject.getDescription(),
        dtoProject.getHostURL(), dtoProject.getImgURL());
        impProjectService.saveProject(project);
        return new ResponseEntity(new PMessage("The Project was added succesfully"),HttpStatus.OK);
    }
    
    @PutMapping("/update-project/{id}")
    public ResponseEntity<?> updateProject(@PathVariable("id") int id, @RequestBody DtoProject dtoProject){
        if(!impProjectService.existsById(id)){
            return new ResponseEntity(new PMessage("Project don't exists"),HttpStatus.BAD_REQUEST);
        }
        if(dtoProject.getTitle().isBlank()){
             return new ResponseEntity(new PMessage("Name of Project is Required"),HttpStatus.BAD_REQUEST);
        }
        
        if(impProjectService.existsByTitle(dtoProject.getTitle()) && 
                impProjectService.getProjectByTitle(dtoProject.getTitle()).get().getId() != id){
             return new ResponseEntity(new PMessage("The Project is already created"),HttpStatus.BAD_REQUEST);
        }
        Project project = impProjectService.getProjectByID(id).get();
        project.setTitle(dtoProject.getTitle());
        project.setDescription(dtoProject.getDescription());
        project.setHostURL(dtoProject.getHostURL());
        project.setImgURL(dtoProject.getImgURL());
        impProjectService.saveProject(project);
        return new ResponseEntity(new PMessage("The Project was updated succesfully"),HttpStatus.OK);
    }
    
    @DeleteMapping("/delete-project/{id}")
    public ResponseEntity<?> deleteProject(@PathVariable("id") int id){
        if(!impProjectService.existsById(id)){
            return new ResponseEntity(new PMessage("Project don't exists"),HttpStatus.BAD_REQUEST);
        }
        
        impProjectService.deleteProject(id);
        return new ResponseEntity(new PMessage("The Project was deleted succesfully"),HttpStatus.OK);
    }
}
