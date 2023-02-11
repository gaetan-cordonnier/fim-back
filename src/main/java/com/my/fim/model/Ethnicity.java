package com.my.fim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "ETHNICITY")
@Getter
@Setter
@NoArgsConstructor
public class Ethnicity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length= 150)
    private String country;
    @Column(length= 100)
    private String continent;
}
