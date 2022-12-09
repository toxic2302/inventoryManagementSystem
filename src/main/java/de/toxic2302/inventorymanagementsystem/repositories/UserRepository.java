package de.toxic2302.inventorymanagementsystem.repositories;

import de.toxic2302.inventorymanagementsystem.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {}

