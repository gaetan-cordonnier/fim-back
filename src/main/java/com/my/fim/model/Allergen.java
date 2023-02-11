package com.my.fim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "ALLERGEN")
@Getter
@Setter
@NoArgsConstructor
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length= 150)
    private String name;
}
