package org.cds.service.web;

import org.cds.model.Target;
import org.cds.model.web.WebTarget;
import org.cds.model.web.WebTargetFilter;

import java.util.List;
import java.util.UUID;

public interface WebTargetService {
    /**
     * Находит таргет по пользователю и странице
     * @param webTargetFilter Пользователь и страница
     * @return Таргет удовлетворяющий параметрам
     */
    List<WebTarget> getAllTargetsByUserAndPage(WebTargetFilter webTargetFilter);

    /**
     * Находит таргет по uuid
     * @param id uuid таргета
     * @return Таргет
     */
    WebTarget findById(UUID id);

    /**
     * Сохраняет таргет в бд
     * @param target Таргет
     * @return Данные таргета
     */
    Target saveTarget(WebTarget target);

    /**
     * Метод находит все сущности таргета и возврашает их
     * @return Весь таргет из бд
     */
    List<WebTarget> getAllTarget();
}
