package org.cds.service.web;

import org.cds.model.Content;
import org.cds.service.mapper.ContentMapper;
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
    private ContentMapper contentMapper;

    @Override
    public WebContent findContentById(UUID id) {
        return contentMapper.contentToWebContent(contentService.findContentById(id));
    }

    @Override
    public WebContent saveContent(WebContent webContent) {
        return contentMapper.contentToWebContent(contentService.saveContent(contentMapper.webContentToContent(webContent)));
    }
}
