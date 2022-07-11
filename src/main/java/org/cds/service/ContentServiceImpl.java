package org.cds.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cds.model.Content;
import org.cds.repository.ContentRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private ContentRepository contentRepository;

    @Override
    public Content findContentById(UUID id) {
        Optional<Content> byId = contentRepository.findById(id);
        return byId.orElseGet(Content::new);
    }

    @Transactional
    @Override
    public Content saveContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public List<Content> findAllContent() {
        return contentRepository.findAll();
    }


}
