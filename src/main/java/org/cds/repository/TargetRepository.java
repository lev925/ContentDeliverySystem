package org.cds.repository;

import org.cds.model.Page;
import org.cds.model.Target;
import org.cds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TargetRepository extends JpaRepository<Target, UUID> {
    List<Target> getTargetsByUserAndPageOrderByPriority(User user, Page page);
}
