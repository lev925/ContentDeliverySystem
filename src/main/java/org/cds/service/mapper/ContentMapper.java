package org.cds.service.mapper;

import org.cds.model.Content;
import org.cds.model.web.WebContent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContentMapper {
    ContentMapper INSTANCE = Mappers.getMapper(ContentMapper.class);

    WebContent contentToWebContent(Content content);
    Content webContentToContent(WebContent webContent);
}
