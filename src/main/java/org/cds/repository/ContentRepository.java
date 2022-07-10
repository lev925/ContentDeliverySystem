package org.cds.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.cds.model.Content;

import java.util.UUID;

public interface ContentRepository extends JpaRepository<Content, UUID> {
}
