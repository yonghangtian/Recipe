package com.example.recipe.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author tianyh
 * created by tianyh on 6/12/19 10:16 PM
 */
@Data
@Entity
public class UnitOfMeasure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

}
