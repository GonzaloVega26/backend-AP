/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.security.service;

import com.portfolio.PortfolioGV.security.entity.MainUser;
import com.portfolio.PortfolioGV.security.entity.User;
import com.portfolio.PortfolioGV.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author gonzalo
 */
@Service
public class ImpUserDetails implements UserDetailsService {
    @Autowired UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User  user = userService.getByEmail(email).get();
        return MainUser.build(user);
    }
    
}
