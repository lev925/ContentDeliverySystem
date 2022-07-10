package org.cds.service;

import org.cds.model.User;

import java.util.List;
import java.util.UUID;

public interface UsersService {
    User findById(UUID id);
    User saveUser(User user);
    void saveAllUser(List<User> users);
}
