package de.toxic2302.inventorymanagementsystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    public Item() {}
    public Item(String name) {
        this.name = name;
    }
}
