package org.cds.controller;

import org.cds.model.Page;
import org.cds.model.Target;
import org.cds.model.Viewed;
import org.cds.model.web.WebViewed;
import org.cds.model.web.WebViewedUUID;
import org.cds.service.ViewedService;
import org.cds.service.web.WebViewedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
public class ViewedController {

    @Autowired
    WebViewedService webViewedService;

    @PostMapping(path = "/viwed/save")
    public Viewed saveViewed(@RequestBody WebViewedUUID webViewedUUID){
        return webViewedService.saveViewed(webViewedUUID);
    }
    @RequestMapping(path = "/target/get", method = RequestMethod.GET)
    public List<WebViewed> findAllViewed(){
        return webViewedService.findAllViewed();
    }
}
