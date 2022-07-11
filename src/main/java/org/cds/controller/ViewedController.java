package org.cds.controller;

import org.cds.model.Viewed;
import org.cds.model.web.WebViewed;
import org.cds.model.web.WebViewedUUID;
import org.cds.service.web.WebViewedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class ViewedController {

    @Autowired
    WebViewedService webViewedService;

    @PostMapping(path = "/viewed/save")
    public Viewed saveViewed(@RequestBody WebViewedUUID webViewedUUID){
        return webViewedService.saveViewed(webViewedUUID);
    }
    @PostMapping("/viewed/get")
    public List<WebViewed> postAllViewed(){
        return webViewedService.findAllViewed();
    }
    @RequestMapping(path = "/viewed/get", method = RequestMethod.GET)
    public List<WebViewed> findAllViewed(){
        return webViewedService.findAllViewed();
    }
}
