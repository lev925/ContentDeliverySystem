package org.cds.service.web;

import org.cds.model.Viewed;
import org.cds.model.web.WebViewed;

import java.util.List;
import java.util.UUID;

public interface WebViewedService {
    /**
     * Метод сохраняет просмотр
     *
     * @param webViewed данные для создания просмотра в виде uuid
     * @return Данные просмотра
     */
    WebViewed saveViewed(WebViewed webViewed);

    /**
     * Метод находит просмотр по uuid
     *
     * @param id uuid просмотра
     * @return Данные просмотра
     */
    WebViewed findById(UUID id);

    /**
     * Метод находит все просмотры и возврашает их
     *
     * @return Все просмотры из бд
     */
    List<WebViewed> findAllViewed();
}
