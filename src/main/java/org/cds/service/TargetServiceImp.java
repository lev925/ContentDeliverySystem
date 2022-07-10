package org.cds.service;

import org.cds.model.Page;
import org.cds.model.Target;
import org.cds.model.User;
import org.cds.repository.TargetRepository;
import org.cds.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Service
public class TargetServiceImp implements TargetService {
    @Autowired
    private TargetRepository targetRepository;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Target findById(UUID id) {
        return targetRepository.findById(id).get();
    }

    @Override
    @Transactional
    public Target saveTarget(Target target) {
        return targetRepository.save(target);
    }
    @Override
    public List<Target> getAllTarget(){
        return targetRepository.findAll();
    }
    @Override
    public List<Target> getTargetByUserIdAndPage(UUID id, Page page){
        User user = usersRepository.findById(id).orElseGet(User::new);
        return targetRepository.getTargetsByUserAndPageOrderByPriority(user,page);
    }
}
