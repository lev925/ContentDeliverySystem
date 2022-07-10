package org.cds.controller;

import org.cds.model.Content;
import org.cds.model.DataContent;
import org.cds.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(path = "/content/{content-id}", method = RequestMethod.GET)
    private Content getUserById(@PathVariable("content-id") UUID id) {
        return contentService.getContentById(id);
    }
    @PostMapping ("/content/save")
    private Content saveContent(@RequestBody String data){
        Content content = Content.builder().data(data).build();
        return contentService.saveContent(content);
    }
}
