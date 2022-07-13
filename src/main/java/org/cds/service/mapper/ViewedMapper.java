package org.cds.service.mapper;

import org.cds.model.Viewed;
import org.cds.model.web.WebViewed;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ViewedMapper {
    ViewedMapper INSTANCE = Mappers.getMapper(ViewedMapper.class);
    @Mappings({
            @Mapping(target = "userId", source = "user.guid"),
            @Mapping(target = "contentId", source = "content.guid")
    })
    WebViewed ViewedToWebViewed(Viewed viewed);
}
