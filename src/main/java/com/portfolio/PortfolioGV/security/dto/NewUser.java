/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.security.dto;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gonzalo
 */
@Getter
@Setter
public class NewUser {
    private String name;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();

    public NewUser(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    
}
