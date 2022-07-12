package org.cds.service.web;

import org.cds.model.Viewed;
import org.cds.model.web.WebViewed;
import org.cds.model.web.WebViewedUUID;

import java.util.List;
import java.util.UUID;

public interface WebViewedService {
    /**
     * Метод сохраняет просмотр
     * @param webViewed данные для создания просмотра в виде uuid
     * @return Данные просмотра
     */
    Viewed saveViewed(WebViewedUUID webViewed);

    WebViewed findById(UUID id);

    List<WebViewed> findAllViewed();
}
