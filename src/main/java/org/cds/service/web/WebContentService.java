package org.cds.service.web;

import org.cds.model.web.WebContent;

public interface WebContentService {
    /**
     * Метод находит контент и возврашает его
     *
     * @param id Индификатро контента
     * @return данные контента
     */
    WebContent findContentById(String id);

    /**
     * Сохраняет контент в бд
     * @param content контент
     * @return данные контента
     */

    WebContent saveContent(WebContent content);
}
