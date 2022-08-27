/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.security.service;

import com.portfolio.PortfolioGV.security.entity.User;
import com.portfolio.PortfolioGV.security.repository.IUserRepository;
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
public class UserService {
    @Autowired IUserRepository iUserRepository;
    
    public Optional<User> getByEmail(String email){
        return iUserRepository.findByEmail(email);
    }
    
    public boolean existByEmail(String email){
        return iUserRepository.existsByEmail(email);
    }
    
    public void saveUser(User user){
        iUserRepository.save(user);
    }
}
