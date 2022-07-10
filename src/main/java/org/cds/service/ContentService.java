package org.cds.service;

import org.cds.model.Content;

import java.util.UUID;

public interface ContentService {
    Content findContentById(UUID id);
    Content saveContent(Content content);
}
