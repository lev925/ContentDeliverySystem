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
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ContentRepository contentRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Viewed saveViewed(UUID contentGuid,UUID userGuid) {
        User user = usersRepository.findById(userGuid).orElseGet(User::new);
        Content content = contentRepository.findById(contentGuid).orElseGet(Content::new);
        Viewed viewed = Viewed.builder().content(content).user(user).build();
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
    @Scheduled(fixedRate = 1000)
    public void sendRequest() {
        List<Viewed> viewed = viewedRepository.findAll();
        ResponseEntity<Viewed[]> response = restTemplate.postForEntity(
                "http://localhost:8080", viewed, Viewed[].class);
        System.out.println(response.getStatusCode());
        for (Viewed o : response.getBody()) {
            System.err.println(o);
        }
    }
}
