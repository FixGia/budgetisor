package fr.fixgia.budgetisor;

import fr.fixgia.budgetisor.model.Consumable;
import fr.fixgia.budgetisor.model.Reagent;

public interface BudgetService {

    Double calculatePrice(Integer sample, Consumable consumable, Reagent reagent);


}
