package com.my.fim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RECIPE")
@Getter
@Setter
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(length = 250)
    private String name;
    @Column(length = 10)
    private String prepTime;
    @Column(length = 10)
    private String cookTime;
    @Column(length = 30)
    private String difficulty;
    private Integer nbPerson;
    @Column(length = 20)
    private Float rating;
    @Column(updatable = false)
    @CreationTimestamp
    private Date creationDate;
    @UpdateTimestamp
    private Date updateDate;
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Step> steps = new ArrayList<Step>();
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Food> foods = new ArrayList<Food>();
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Origin origin = new Origin();
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Ethnicity ethnicity = new Ethnicity();

}
