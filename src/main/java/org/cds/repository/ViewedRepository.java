package org.cds.repository;

import org.cds.model.Viewed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ViewedRepository extends JpaRepository<Viewed, UUID> {
}
