/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.PortfolioGV.interfaces;

import com.portfolio.PortfolioGV.entity.Person;
import java.util.List;

/**
 *
 * @author gonzalo
 */
public interface IPersonService {
    
    public List<Person> getPerson();
    
    public  void savePerson(Person person);
    
    public void deletePerson(Long id);
    
    public Person findPerson(Long id);
}
