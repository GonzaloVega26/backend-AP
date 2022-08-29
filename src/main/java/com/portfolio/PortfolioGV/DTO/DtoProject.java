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
public class DtoProject {
    @NotBlank
    private String title;
    @NotBlank
    private String  description;
    private String  hostURL;
    private String  imgURL;

    public DtoProject() {
    }

    public DtoProject(String title, String description, String hostURL, String imgURL) {
        this.title = title;
        this.description = description;
        this.hostURL = hostURL;
        this.imgURL = imgURL;
    }
}
