package org.cds.controller;

import org.cds.model.web.WebViewed;
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
    public WebViewed saveViewed(@RequestBody WebViewed webViewed){
        return webViewedService.saveViewed(webViewed);
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
