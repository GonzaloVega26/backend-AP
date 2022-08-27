/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.security.service;

import com.portfolio.PortfolioGV.security.entity.Role;
import com.portfolio.PortfolioGV.security.enums.RoleEnum;
import com.portfolio.PortfolioGV.security.repository.IRoleRepository;
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
public class RoleService {
    @Autowired IRoleRepository iRoleRepository;
    
    public Optional<Role> getByRoleName (RoleEnum roleName){
        return iRoleRepository.findByRoleName(roleName);
    }
    
    public void saveRole (Role role){
        iRoleRepository.save(role); 
    }
}
