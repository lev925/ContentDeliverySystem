package org.cds.service.web;

import org.cds.model.Content;
import org.cds.model.User;
import org.cds.model.Viewed;
import org.cds.model.web.WebViewed;
import org.cds.service.ContentService;
import org.cds.service.UsersService;
import org.cds.service.ViewedService;
import org.cds.service.mapper.ViewedMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class WebViewedServiceImp implements WebViewedService {
    @Autowired
    ViewedService viewedService;
    @Autowired
    UsersService userService;
    @Autowired
    ContentService contentService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ViewedMapper viewedMapper;

    @Override
    public WebViewed saveViewed(WebViewed webViewed) {
        User user = userService.findById(webViewed.getUserId());
        Content content = contentService.findContentById(webViewed.getContentId());
        Viewed viewed = Viewed.builder().user(user).content(content).build();
        viewedService.saveViewed(viewed);
        return webViewed;
    }

    @Override
    public WebViewed findById(UUID id) {
        Viewed viewed = viewedService.findById(id);
        return viewedMapper.ViewedToWebViewed(viewed);
    }

    @Override
    public List<WebViewed> findAllViewed() {
        List<Viewed> viewedList = viewedService.findAllViewed();
        List<WebViewed> res = new ArrayList<>();
        for (Viewed viewed : viewedList) {
            res.add(viewedMapper.ViewedToWebViewed(viewed));
        }
        return res;
    }
    @Scheduled(fixedRate = 60000)
    public void sendRequest() {

        WebViewed webViewed = WebViewed.builder()
                .contentId(UUID.fromString("46f85973-64ed-4aa3-9164-e455448b9028"))
                .userId(UUID.fromString("9ca106ba-b5da-4c0e-b996-7a555a37dd4d"))
                .build();
        ResponseEntity<WebViewed[]> response = restTemplate.postForEntity(
                "http://localhost:8080/viewed/get",webViewed, WebViewed[].class);
    }

}
