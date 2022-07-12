package org.cds.service.web;

import org.cds.model.web.WebContent;

import java.util.UUID;

public interface WebContentService {
    /**
     * Метод находит контент и возврашает его
     *
     * @param id Индификатро контента
     * @return данные контента
     */
    WebContent findContentById(UUID id);

    /**
     * Сохраняет контент в бд
     * @param content контент
     * @return данные контента
     */

    WebContent saveContent(WebContent content);
}
