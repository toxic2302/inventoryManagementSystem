package de.toxic2302.inventorymanagementsystem.core.modules.user.entity;

import de.toxic2302.inventorymanagementsystem.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
public class User extends BaseEntity {

    private String oauthId;
    private String name;
    private String email;
    private String pictureUrl;

    public User() {}
    public User(String oauthId, String name, String email) {
        this.oauthId = oauthId;
        this.name = name;
        this.email = email;
    }
}
