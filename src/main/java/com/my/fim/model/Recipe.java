package com.my.fim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "RECIPE")
@Getter
@Setter
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length= 250)
    private String name;
    @Column(length = 10)
    private String prepTime;
    @Column(length= 10)
    private String cookTime;
    @Column(length= 30)
    private String difficulty;
    private Integer nbPerson;
    @Column(length= 20)
    private Float rating;
}
