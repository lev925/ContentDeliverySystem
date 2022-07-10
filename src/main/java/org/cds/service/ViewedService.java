package org.cds.service;

import org.cds.model.Viewed;

import java.util.List;
import java.util.UUID;

public interface ViewedService {
    Viewed saveViewed(Viewed viewed);

    Viewed findById(UUID id);

    List<Viewed> findAllViewed();
}
