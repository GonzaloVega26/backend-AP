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
public class DtoSkill {
    @NotBlank
    private String name;
    @NotBlank
    private int  percentage;
    @NotBlank
    private String color;

    public DtoSkill() {
    }

    public DtoSkill(String name, int percentage, String color) {
        this.name = name;
        this.percentage = percentage;
        this.color = color;
    }
}
