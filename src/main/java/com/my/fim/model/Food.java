package com.my.fim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "FOOD")
@Getter
@Setter
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private Long code;
    @Column(length = 150)
    private String name;
    private Boolean biologic;
    @Column(length = 20)
    private Float quantity;
    @Column(length = 20)
    private Float consumed;
    @Column(length = 20)
    private Float remaining;
}
