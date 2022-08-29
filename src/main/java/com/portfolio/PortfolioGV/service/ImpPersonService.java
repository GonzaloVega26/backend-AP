/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.service;

import com.portfolio.PortfolioGV.entity.Person;
import com.portfolio.PortfolioGV.repository.IPersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gonzalo
 */
@Service
public class ImpPersonService {
    @Autowired IPersonRepository  iPersonRepository;
    
    
    public List<Person> getPerson() {
        List<Person> person = iPersonRepository.findAll();
        return person;
    }

    
    public void savePerson(Person person) {
        iPersonRepository.save(person);
    }

    
    public void deletePerson(int id) {
        iPersonRepository.deleteById(id);
    }

    
    public Person findPerson(int id) {
        Person person = iPersonRepository.findById(id).orElse(null);
        return person;
    }

    
}
