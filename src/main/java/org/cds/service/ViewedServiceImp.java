package org.cds.service;

import org.cds.model.Content;
import org.cds.model.User;
import org.cds.model.Viewed;
import org.cds.repository.ContentRepository;
import org.cds.repository.UsersRepository;
import org.cds.repository.ViewedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
public class ViewedServiceImp implements ViewedService {
    @Autowired
    private ViewedRepository viewedRepository;

    @Override
    public Viewed saveViewed(Viewed viewed) {
        return viewedRepository.save(viewed);
    }

    @Override
    public Viewed findById(UUID id) {
        return viewedRepository.findById(id).orElseGet(Viewed::new);
    }

    @Override
    public List<Viewed> findAllViewed() {
        return viewedRepository.findAll();
    }

}
