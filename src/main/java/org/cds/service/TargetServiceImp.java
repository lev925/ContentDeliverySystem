package org.cds.service;

import org.cds.model.Page;
import org.cds.model.Target;
import org.cds.model.User;
import org.cds.repository.TargetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class TargetServiceImp implements TargetService {
    @Autowired
    private TargetRepository targetRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Target findById(UUID id) {
        return targetRepository.findById(id).orElseGet(Target::new);
    }

    @Override
    @Transactional
    public Target saveTarget(Target target) {
        return targetRepository.save(target);
    }

    @Override
    public List<Target> getAllTarget() {
        return targetRepository.findAll();
    }

    @Override
    public List<Target> getTargetByUserIdAndPage(User user, Page page) {
        return targetRepository.getTargetsByUserAndPageOrderByPriority(user, page);
    }
}
