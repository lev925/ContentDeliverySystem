package org.cds.controller;

import org.cds.model.web.WebContent;
import org.cds.service.web.WebContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ContentController {

    @Autowired
    private WebContentService webContentService;

    @RequestMapping(path = "/content/get/{content-id}", method = RequestMethod.GET)
    private WebContent getContentById(@PathVariable("content-id") UUID id) {

        return webContentService.findContentById(id);
    }
    @PostMapping ("/content/save")
    private WebContent saveContent(@RequestBody String data){
        WebContent webContent = WebContent.builder().data(data).build();
        return webContentService.saveContent(webContent);
    }
}
