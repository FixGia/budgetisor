package fr.fixgia.budgetisor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "protocol")
public class Protocol {

    @Id
    private UUID id;

    private String name;
    private List<Reagent> reagentList;
    private List<Consumable> consumableList;

}
