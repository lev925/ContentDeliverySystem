package org.cds.service;

import org.cds.model.Target;

import java.util.List;
import java.util.UUID;

public interface TargetService {
    Target findById(UUID id);
    Target saveTarget(Target target);
    List<Target> getAllTarget();
    List<Target> getTargetByUserId(UUID id);
}
