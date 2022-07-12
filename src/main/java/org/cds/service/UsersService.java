package org.cds.service;

import org.cds.model.User;

import java.util.UUID;

public interface UsersService {
    /**
     * Метод находит пользователя по guid и возврашает его
     * @param id - guid пользователя
     * @return - Данные пользователя
     */
    User findById(UUID id);

    /**
     * Метод сохраняет пользователя в бд
     * @param user - Пользователь
     * @return - Данные пользователя
     */
    User saveUser(User user);

}
