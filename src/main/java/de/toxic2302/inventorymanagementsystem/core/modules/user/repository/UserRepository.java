package de.toxic2302.inventorymanagementsystem.core.modules.user.repository;

import de.toxic2302.inventorymanagementsystem.core.modules.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    User findUserByOauthId(String oauthId);
}
