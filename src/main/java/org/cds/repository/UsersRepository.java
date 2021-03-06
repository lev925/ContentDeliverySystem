package org.cds.repository;

import org.cds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepository extends JpaRepository<User, UUID> {
}
