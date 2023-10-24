package com.workintech.fruitsandvegetables.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table (name = "fruit" ,schema = "fsweb")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @Column(name = "price")
    @NotNull
    private double price;

    @Enumerated(EnumType.STRING)
    @NotNull
    private FruitType fruitType;
}
