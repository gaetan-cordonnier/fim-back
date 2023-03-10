package com.my.fim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "READY_MEAL")
@Getter
@Setter
@NoArgsConstructor
public class ReadyMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private Long code;
    @Column(length = 150)
    private String name;
    @Column(length = 150)
    private String category;
    @Column(length = 200)
    private String brand;
    @Column(length = 20)
    private Float quantity;
}
