package org.cds.service.web;

import org.cds.model.Page;
import org.cds.model.Target;
import org.cds.model.web.WebTarget;
import org.cds.model.web.WebTargetFilter;

import java.util.List;
import java.util.UUID;

public interface WebTargetService {
    List<WebTarget> getAllTargetsByUserAndPage(WebTargetFilter webTargetFilter);
    WebTarget findById(UUID id);
    Target saveTarget(WebTarget target);
    List<WebTarget> getAllTarget();
}
