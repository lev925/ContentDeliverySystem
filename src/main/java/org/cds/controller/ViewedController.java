package org.cds.controller;

import org.cds.model.Page;
import org.cds.model.Target;
import org.cds.model.Viewed;
import org.cds.service.ViewedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
public class ViewedController {

    @Autowired
    ViewedService viewedService;

    @PostMapping(path = "/viwed/save")
    public Viewed saveViewed(@RequestBody UUID contentId, @RequestBody UUID userId){
        return viewedService.saveViewed(contentId,userId);
    }
}
