
package com.portfolio.PortfolioGV.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String name;
    private String title;
    private String about;
    private String imgURL;
    private String bannerURL;

    public Person() {
    }

    public Person(String name, String title, String about, String imgURL, String bannerURL) {
        this.name = name;
        this.title = title;
        this.about = about;
        this.imgURL = imgURL;
        this.bannerURL = bannerURL;
    }
    
    
    
}
