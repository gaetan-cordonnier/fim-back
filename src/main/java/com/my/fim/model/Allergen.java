package com.my.fim.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ALLERGEN")
@Getter
@Setter
@NoArgsConstructor
public class Allergen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(length = 150)
    private String name;
    
}
