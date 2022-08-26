/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.service;

import com.portfolio.PortfolioGV.entity.Person;
import com.portfolio.PortfolioGV.interfaces.IPersonService;
import com.portfolio.PortfolioGV.repository.IPersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author gonzalo
 */
@Service
public class ImpPersonService implements IPersonService {
    @Autowired IPersonRepository  iPersonRepository;
    
    @Override
    public List<Person> getPerson() {
        List<Person> person = iPersonRepository.findAll();
        return person;
    }

    @Override
    public void savePerson(Person person) {
        iPersonRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        iPersonRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        Person person = iPersonRepository.findById(id).orElse(null);
        return person;
    }
    
}
