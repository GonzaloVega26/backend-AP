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
public class DtoPerson {
    @NotBlank
    private String name;
    @NotBlank
    private String title;
    @NotBlank
    private String about;
    @NotBlank
    private String imgURL;
    @NotBlank
    private String bannerURL;

    public DtoPerson() {
    }

    public DtoPerson(String name, String title, String about, String imgURL, String bannerURL) {
        this.name = name;
        this.title = title;
        this.about = about;
        this.imgURL = imgURL;
        this.bannerURL = bannerURL;
    }
    
    
}

