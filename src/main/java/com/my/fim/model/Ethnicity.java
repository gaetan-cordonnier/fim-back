package com.my.fim.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ETHNICITY")
@Getter
@Setter
@NoArgsConstructor
public class Ethnicity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column(length = 150)
    private String country;
    @Column(length = 100)
    private String continent;
    
}
