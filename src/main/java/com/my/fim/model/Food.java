package com.my.fim.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "FOOD")
@Getter
@Setter
@NoArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(length = 50)
    private String code;
    @Column(length = 150)
    private String name;
    private Boolean biologic;
    @Column(length = 20)
    private Float quantity;
    @Column(length = 20)
    private Float consumed;
    @Column(length = 20)
    private Float remaining;
    @Column(length = 20)
    private String nutriScore;
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Category category = new Category();
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Brand brand = new Brand();
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Location location = new Location();
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Allergen> allergens = new ArrayList<Allergen>();
    
}
