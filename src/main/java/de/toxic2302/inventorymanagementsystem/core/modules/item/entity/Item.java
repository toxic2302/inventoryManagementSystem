package de.toxic2302.inventorymanagementsystem.core.modules.item.entity;

import de.toxic2302.inventorymanagementsystem.base.BaseEntity;
import de.toxic2302.inventorymanagementsystem.core.modules.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter @Setter
public class Item extends BaseEntity {

    // ---- Globales ----
    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String brand;

    @Column
    private String serialNumber;

    @Column(length = 10000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private Boolean sold;

    // ---- Constructor ----
    public Item() {}
    public Item(String name) {
        this.name = name;
        //this.user = user;
    }
}
