
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
    private Long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Enter valid name")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 50, message = "Enter valid firstname")
    private String firstName;
    
    private String img;
    
    
    
}
