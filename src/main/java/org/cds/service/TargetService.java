package org.cds.service;

import org.cds.model.Page;
import org.cds.model.Target;
import org.cds.model.User;

import java.util.List;
import java.util.UUID;

public interface TargetService {
    /**
     * Метод находит таргет и возврашает его
     * @param id - guid таргета
     * @return - Основные поля таргета
     */
    Target findById(UUID id);

    /**
     * Метод сохраняет таргет в бд
     * @param target - Таргет
     * @return Таргет с указанием guid
     */
    Target saveTarget(Target target);

    /**
     * Метод находит все сущности таргета и возврашает их
     * @return - Весь таргет из бд
     */
    List<Target> getAllTarget();

    /**
     * Метод находит все сущности таргета по указаным параметрам и возврашает их в порядке их приоритета
     * @param user - Пользователь
     * @param page - Страница
     * @return Весь таргет из бд, который соответствует заданным параметрам
     */
    List<Target> getTargetByUserIdAndPage(User user, Page page);
}
