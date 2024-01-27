package fr.fixgia.budgetisor.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reagent {

    private String name;
    private Double price;
    private Double quantity;

}
