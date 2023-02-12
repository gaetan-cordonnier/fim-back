package com.my.fim.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ORIGIN_RECIPE")
@Getter
@Setter
@NoArgsConstructor
public class Origin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length= 150)
    private String type;
    @Column(length= 500)
    private String location;
    @Column(length= 250)
    private String author;
}
