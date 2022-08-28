/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.PortfolioGV.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author gonzalo
 */
@Getter
@Setter
public class DtoExperience {
    @NotBlank
    private String name;
    @NotBlank
    private String  description;

    public DtoExperience() {
    }

    public DtoExperience(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    
}
