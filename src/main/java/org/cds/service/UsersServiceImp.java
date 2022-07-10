package org.cds.service;

import org.cds.model.User;
import org.cds.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class UsersServiceImp implements UsersService {
    @Autowired
    private UsersRepository usersRepository;


    @Override
    public User findById(UUID id) {
        return usersRepository.findById(id).orElseGet(User::new);
    }

    @Override
    public User saveUser(User user) {
        return usersRepository.save(user);
    }
    @Override
    public void saveAllUser(List<User> users) {
        usersRepository.saveAll(users);
    }

}
