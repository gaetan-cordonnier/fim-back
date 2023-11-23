package com.my.fim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "READY_MEAL")
@Getter
@Setter
@NoArgsConstructor
public class Dishe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(length = 50)
    private Long code;
    @Column(length = 150)
    private String name;
    @Column(length = 150)
    private String category;
    @Column(length = 20)
    private Float quantity;
    @Column(length = 20)
    private String nutriScore;
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Brand brand = new Brand();
    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Location location = new Location();
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<Allergen> allergens = new ArrayList<Allergen>();
}
