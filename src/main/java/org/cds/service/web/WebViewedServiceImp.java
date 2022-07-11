package org.cds.service.web;

import org.cds.model.Content;
import org.cds.model.User;
import org.cds.model.Viewed;
import org.cds.model.web.WebViewed;
import org.cds.model.web.WebViewedUUID;
import org.cds.service.ContentService;
import org.cds.service.UsersService;
import org.cds.service.ViewedService;
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

    private WebViewed mapper(Viewed viewed){
        WebViewed webViewed = WebViewed.builder()
                .content(viewed.getContent())
                .user(viewed.getUser())
                .build();
        return webViewed;
    }
    @Override
    public Viewed saveViewed(WebViewedUUID webViewedUUID) {
        User user = userService.findById(webViewedUUID.getUserID());
        Content content = contentService.findContentById(webViewedUUID.getContentID());
        Viewed viewed = Viewed.builder().user(user).content(content).build();
        viewedService.saveViewed(viewed);
        return viewed;
    }

    @Override
    public WebViewed findById(UUID id) {
        Viewed viewed = viewedService.findById(id);
        WebViewed webViewed = WebViewed.builder()
                .content(viewed.getContent())
                .user(viewed.getUser())
                .build();
        return webViewed;
    }

    @Override
    public List<WebViewed> findAllViewed() {
        List<Viewed> viewedList = viewedService.findAllViewed();
        List<WebViewed> res = new ArrayList<>();
        for (Viewed viewed : viewedList) {
            WebViewed webViewed = WebViewed.builder()
                    .content(viewed.getContent())
                    .user(viewed.getUser())
                    .build();
            res.add(webViewed);
        }
        return res;
    }
    @Scheduled(fixedRate = 60000)
    public void sendRequest() {

        WebViewed webViewed = WebViewed.builder()
                .content(contentService.findContentById(UUID.fromString("46f85973-64ed-4aa3-9164-e455448b9028")))
                .user(userService.findById(UUID.fromString("9ca106ba-b5da-4c0e-b996-7a555a37dd4d")))
                .build();
        ResponseEntity<WebViewed[]> response = restTemplate.postForEntity(
                "http://localhost:8080/viewed/get",webViewed, WebViewed[].class);
        System.out.println(response.getStatusCode());
        for (WebViewed o : response.getBody()) {
            System.err.println(o);
        }
    }

}
