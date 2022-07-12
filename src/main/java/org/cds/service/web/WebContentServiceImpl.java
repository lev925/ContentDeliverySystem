package org.cds.service.web;

import ma.glasnost.orika.MapperFacade;
import org.cds.model.Content;
import org.cds.model.web.WebContent;
import org.cds.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WebContentServiceImpl implements WebContentService {

    @Autowired
    private ContentService contentService;
    @Autowired
    MapperFacade mapperFacade;

    @Override
    public WebContent findContentById(String id) {
        return mapperFacade.map(contentService.findContentById(UUID.fromString(id)), WebContent.class);
    }

    @Override
    public WebContent saveContent(WebContent content) {
        return mapperFacade.map(contentService.saveContent(mapperFacade.map(content, Content.class)), WebContent.class);
    }
}
