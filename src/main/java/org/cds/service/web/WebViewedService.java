package org.cds.service.web;

import org.cds.model.Viewed;
import org.cds.model.web.WebViewed;
import org.cds.model.web.WebViewedUUID;

import java.util.List;
import java.util.UUID;

public interface WebViewedService {
    Viewed saveViewed(WebViewedUUID webViewed);

    WebViewed findById(UUID id);

    List<WebViewed> findAllViewed();
}
