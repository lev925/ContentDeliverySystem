package org.cds.service;

import org.cds.model.Page;
import org.cds.model.Target;
import org.cds.model.User;
import org.cds.model.web.WebTarget;

import java.util.List;
import java.util.UUID;

public interface TargetService {
    Target findById(UUID id);
    Target saveTarget(Target target);
    List<Target> getAllTarget();
    List<Target> getTargetByUserIdAndPage(User user, Page page);
}
