package de.toxic2302.inventorymanagementsystem.repository;

import de.toxic2302.inventorymanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
