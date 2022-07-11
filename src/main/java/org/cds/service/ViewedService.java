package org.cds.service;

import org.cds.model.Viewed;

import java.util.List;
import java.util.UUID;

public interface ViewedService {
    /**
     * Метод сохраняет просмотр в бд
     * @param viewed - Просмотр
     * @return Данные просмотра с guid
     */
    Viewed saveViewed(Viewed viewed);

    /**
     * Метод находит просмотр и возврашает его
     * @param id - guid просмотра
     * @return Данные просмотра
     */

    Viewed findById(UUID id);

    /**
     * Метод находит все сущности контента и возврашает их
     * @return Все просмотры из бд
     */

    List<Viewed> findAllViewed();
}
