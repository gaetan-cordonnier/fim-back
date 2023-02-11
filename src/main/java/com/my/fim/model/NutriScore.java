package com.my.fim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "NUTRI_SCORE")
@Getter
@Setter
@NoArgsConstructor
public class NutriScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length= 100)
    private String code;
}
