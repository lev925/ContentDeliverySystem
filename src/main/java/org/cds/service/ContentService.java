package org.cds.service;

import org.cds.model.Content;

import java.util.List;
import java.util.UUID;

public interface ContentService {
    /**
     * Метод находит контент и возврашает его
     *
     * @param id Индификатро контента
     * @return Контент
     */
    Content findContentById(UUID id);

    /**
     * Метод сохраняет контент в бд
     *
     * @param content Контент
     * @return Созданный контент
     */
    Content saveContent(Content content);

    /**
     * Метод находит все сущности контента и возврашает их
     *
     * @return Весь контент из бд
     */
    List<Content> findAllContent();
}
