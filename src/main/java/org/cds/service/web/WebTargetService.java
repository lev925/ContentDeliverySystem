package org.cds.service.web;

import org.cds.model.Page;
import org.cds.model.web.WebTarget;

import java.util.List;
import java.util.UUID;

public interface WebTargetService {
    List<WebTarget> getAllTargetsByUserAndPage(UUID id, Page page);
}
