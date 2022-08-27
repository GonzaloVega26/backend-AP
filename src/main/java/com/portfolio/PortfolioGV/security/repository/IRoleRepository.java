/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portfolio.PortfolioGV.security.repository;

import com.portfolio.PortfolioGV.security.entity.Role;
import com.portfolio.PortfolioGV.security.enums.RoleEnum;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gonzalo
 */
@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer>{
    Optional<Role> findByRoleName(RoleEnum roleName);
}
